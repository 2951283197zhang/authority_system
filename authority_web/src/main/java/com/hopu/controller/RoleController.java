package com.hopu.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.domain.TMenu;
import com.hopu.domain.TRole;
import com.hopu.domain.TUser;
import com.hopu.domain.TUserRole;
import com.hopu.result.PageEntity;
import com.hopu.result.ResponseEntity;
import com.hopu.result.UUIDUtils;
import com.hopu.service.IRoleMenuService;
import com.hopu.service.IRoleService;
import com.hopu.service.IUserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping("/toRoleListPage")
    public String toRoleListPage() {
        return "admin/role/role_list";
    }

    /**
     * 分页查询用户列表
     */
    @ResponseBody
    @RequestMapping("/RoleList")
    public PageEntity RoleList(long page, long limit, TRole role, HttpServletRequest request) {
        // 设置分页条件
        Page<TRole> page2 = new Page<TRole>(page, limit);
        // QueryWrapper封装查询条件
        QueryWrapper<TRole> queryWrapper = new QueryWrapper<>(new TRole());
        if (!StringUtils.isEmpty(role.getRole()) && role != null) queryWrapper.like("role", role.getRole());
        // 分页查询时，带上分页数据以及查询条件对象
        IPage<TRole> roleIPage = roleService.page(page2, queryWrapper);
        return new PageEntity(roleIPage);
    }


    @RequestMapping("/toAddRole")
    public String toAddRole() {
        return "admin/role/role_add";
    }

    @ResponseBody
    @RequestMapping("/save")
    public ResponseEntity save(TRole role, HttpServletRequest request) {
        role.setId(UUIDUtils.getID());
        role.setCreateTime(new Date());
        roleService.save(role);
        return ResponseEntity.success();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody ArrayList<TRole> roles){
        try {
            List<String> list = new ArrayList<>();
            for (TRole role : roles) {
                if ("vip".equals(role.getRole())) {
                    throw new Exception("贵宾角色不能被删除");
                }
                list.add(role.getId());
            }
            roleService.removeByIds(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.error(e.getMessage());
        }
        return ResponseEntity.success();
    }

    @RequestMapping("/toUpdateRole")
    public String toUpdateRole(String id, HttpServletRequest request) {
        TRole role = roleService.getById(id);
        request.setAttribute("role",role);
        return "admin/role/role_update";
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResponseEntity update(TRole role, HttpServletRequest request) {
        role.setUpdateTime(new Date());
        roleService.updateById(role);
       return ResponseEntity.success();
    }

    /**
     * 跳转分配权限界面
     */
    @RequestMapping("/toSetMenuPage")
    public String toSetMenuPage(String id, Model model){
        model.addAttribute("role_id",id);
        return "admin/role/role_setMenu";
    }
    /**
     * 设置权限
     */
    @ResponseBody
    @RequestMapping("/setMenu")
    public ResponseEntity setMenu(String id, @RequestBody ArrayList<TMenu> menus){
        roleService.setMenu(id, menus);
        return ResponseEntity.success();
    }

    /**
     * 查询用户关联的角色列表
     */
    @ResponseBody
    @RequestMapping("/roleList")
    public PageEntity List(String userId, TRole role) {
        List<TUserRole> userRoles = userRoleService.list(new QueryWrapper<TUserRole>().eq("user_id", userId));

        QueryWrapper<TRole> queryWrapper = new QueryWrapper<TRole>();
        if (role != null) {
            if (!StringUtils.isEmpty(role.getRole())) queryWrapper.like("role", role.getRole());
        }
        List<TRole> roles = roleService.list(queryWrapper);

        List<JSONObject> list = new ArrayList<JSONObject>();
        // 同样需要对用户已经关联的角色进行勾选，根据layui需要填充一个LAY_CHECKED字段
        for (TRole role2 : roles) {
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(role2));
            boolean rs = false;
            for (TUserRole userRole : userRoles) {
                if (userRole.getRoleId().equals(role2.getId())) {
                    rs = true;
                }
            }
            jsonObject.put("LAY_CHECKED", rs);
            list.add(jsonObject);
        }
        return new PageEntity(list.size(), list);
    }
}

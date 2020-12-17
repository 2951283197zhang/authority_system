package com.hopu.controller;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.domain.TRole;
import com.hopu.domain.TUser;
import com.hopu.result.ResponseEntity;
import com.hopu.result.UUIDUtils;
import com.hopu.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.net.SyslogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

/*
    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity<List<TUser>> userList(){
        List<TUser> userList = userService.list();
        return new ResponseEntity<>(userList, HttpStatus.FOUND);
    }
*/
@RequestMapping("/toUserListPage")
public String toUserListPage(){
    return "admin/user/user_list";
}

    /**
     * 分页查询用户列表
     */
    @ResponseBody
    @RequestMapping("/userList")
    public IPage<TUser> userList(long page, long limit, TUser user, HttpServletRequest request){
        // 设置分页条件
        Page<TUser> page2 = new Page<TUser>(page, limit);
        // QueryWrapper封装查询条件
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>(new TUser());
        if (user!=null){
            if (!StringUtils.isEmpty(user.getUserName())) queryWrapper.like("user_name", user.getUserName());
            if (!StringUtils.isEmpty(user.getTel())) queryWrapper.like("tel", user.getTel());
            if (!StringUtils.isEmpty(user.getEmail())) queryWrapper.like("email", user.getEmail());
        }
        // 分页查询时，带上分页数据以及查询条件对象
        IPage<TUser> userIPage = userService.page(page2,queryWrapper);
        return userIPage;
    }

    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "admin/user/user_add";
    }

    @ResponseBody
    @RequestMapping("/save")
    public ResponseEntity save(TUser user, HttpServletRequest request){
        user.setId(UUIDUtils.getID());
        user.setSalt(UUIDUtils.getID());
        user.setCreateTime(new Date());
        userService.save(user);
        return ResponseEntity.success();
    }

    /**
     * 跳转分配角色界面
     */
    @RequestMapping("/toSetRole")
    public String toSetRole(String id, Model model){
        model.addAttribute("user_id", id);
        return "admin/user/user_setRole";
    }
    /**
     * 设置角色
     */
    @ResponseBody
    @RequestMapping("setRole")
    public ResponseEntity setRole(String id, @RequestBody ArrayList<TRole> roles){
        userService.setRole(id, roles);
        return ResponseEntity.success();
    }
}

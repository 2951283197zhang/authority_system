package com.hopu.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hopu.domain.TMenu;
import com.hopu.domain.TRoleMenu;
import com.hopu.result.IconFontUtils;
import com.hopu.result.PageEntity;
import com.hopu.result.ResponseEntity;
import com.hopu.result.UUIDUtils;
import com.hopu.service.IMenuService;
import com.hopu.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/menu")
public class MenuController {
        @Autowired
        private IMenuService menuService;

        @Autowired
        private IRoleMenuService roleMenuService;
        /**
         * 向菜单列表跳转
         */
        @GetMapping("/toMenuPage")
        public String toListPage(){
            return "admin/menu/menu_list";
        }

        /**
         * 三级菜单列表查询(不做分页)
         * @return
         */
        @RequestMapping("/list")
        @ResponseBody
        public PageEntity list(){
            // 先查询父菜单
            List<TMenu> pList = menuService.list(new QueryWrapper<TMenu>().eq("pid", "0"));
            // 接着，根据父菜单id查询对应的所有子菜单，把子菜单封装到父菜单对象的属性nodes中

            // 需求：最终返回的是各个菜单集合
            ArrayList<TMenu> menus = new ArrayList<>();

            findChildMenu(pList, menus);


//        return new PageEntity(menuList.size(),menuList);
            return new PageEntity(menus.size(),menus);

//        // 如果不涉及到子菜单关联
//        List<Menu> list = menuService.list();
//        return new PageEntity(list.size(),list);

        }
        // 私有方法，循环查询儿子菜单列表
        private List<TMenu> findChildMenu(List<TMenu> pList, List<TMenu> menus){
//        pList.forEach(menu -> {
//////            menus.add(menu); // 向返回集合中，添加父菜单
////
////            String pId = menu.getId();
////            List<Menu> childList = menuService.list(new QueryWrapper<Menu>().eq("pid", pId));
////            menu.setNodes(childList);
////
////            menus.addAll(childList); // 向返回集合中，添加子菜单
////
////            if(childList.size()>0){
////                // 递归调用
////                menus= findChildMenu(childList,menus);
////            }
////        });

            for (TMenu menu : pList) {
                if(!menus.contains(menu)){
                    menus.add(menu);
                }

                String pId = menu.getId();
                List<TMenu> childList = menuService.list(new QueryWrapper<TMenu>().eq("pid", pId));
                menu.setNodes(childList);

                if(childList.size()>0){
                    // 递归调用
                    menus= findChildMenu(childList,menus);
                }
            }
            return menus;
        }

    /**
     * 向添加页面跳转
     */
    @RequestMapping("/toAddPage")
    public String toAddPage(HttpServletRequest request){
        //父级菜单
        List<TMenu> list = menuService.list(new QueryWrapper<TMenu>(new TMenu()).eq("pid", '0'));
        findChildrens(list);

        //图标
        List<String> iconFont = IconFontUtils.getIconFont();

        request.setAttribute("iconFont", iconFont);
        request.setAttribute("list", list);
        return "admin/menu/menu_add";
    }
    private void findChildrens(List<TMenu> list){
        for (TMenu menu : list) {
            List<TMenu> list2 = menuService.list(new QueryWrapper<TMenu>(new TMenu()).eq("pid", menu.getId()));
            if (list2!=null) {
                menu.setNodes(list2);
            }
        }
    }
    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public ResponseEntity addMenu(TMenu menu){
        menu.setId(UUIDUtils.getID());
        menu.setCreateTime(new Date());
        menuService.save(menu);
        return ResponseEntity.success();
    }

    /**
     * 跳转修改界面
     */
    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(String id, HttpServletRequest request){
        TMenu menu = menuService.getById(id);
        request.setAttribute("menu", menu);

        List<TMenu> list = menuService.list(new QueryWrapper<TMenu>(new TMenu()).eq("pid", '0').orderByAsc("seq"));
        findChildrens(list);

        //图标
        List<String> iconFont = IconFontUtils.getIconFont();

        request.setAttribute("iconFont", iconFont);
        request.setAttribute("list", list);
        return "admin/menu/menu_update";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("update")
    public ResponseEntity updateMenu(TMenu menu){
        menu.setUpdateTime(new Date());
        menuService.updateById(menu);
        return ResponseEntity.success();
    }

    @ResponseBody
    @RequestMapping("delete")
    public ResponseEntity deleteMenu(@RequestBody ArrayList<TMenu> menus){
            List<String> list = new ArrayList<>();
            for (TMenu menu : menus) {
                list.add(menu.getId());
            }
            menuService.removeByIds(list);
        return ResponseEntity.success();
    }

    /**
     * 角色分配权限页面菜单查询
     * @return
     */
    @RequestMapping("/MenuList")
    @ResponseBody
    public PageEntity menuList(@RequestParam(value = "id") String roleId){
        // 查询当前角色已经关联了的权限
        List<TRoleMenu> roleMenuList = roleMenuService.list(new QueryWrapper<TRoleMenu>().eq("role_id", roleId));

        // 如果不涉及到子菜单关联
        List<TMenu> list = menuService.list();

        //  此处循环的作用就是为了判断角色已有权限，然后添加一个LAY_CHECKED字段，前端layui表格才能自动勾选
        ArrayList<JSONObject> jsonObjects = new ArrayList<>();
        list.forEach(menu -> {
            // 先需要把对象转换为JSON格式
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(menu));
            // 判断是否已经有了对应的权限
            List<String> menuIds = roleMenuList.stream().map(roleMenu -> roleMenu.getMenuId()).collect(Collectors.toList());
            if(menuIds.contains(menu.getId())){
                jsonObject.put("LAY_CHECKED",true);
            }
            jsonObjects.add(jsonObject);
        });

        return new PageEntity(jsonObjects.size(),jsonObjects);
    }
}

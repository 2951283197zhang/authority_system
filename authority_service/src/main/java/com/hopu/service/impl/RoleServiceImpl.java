package com.hopu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hopu.domain.TMenu;
import com.hopu.domain.TRole;
import com.hopu.domain.TRoleMenu;
import com.hopu.mapper.RoleMapper;
import com.hopu.service.IRoleMenuService;
import com.hopu.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, TRole> implements IRoleService {
    @Autowired
    private IRoleMenuService roleMenuService;

    @Override
    public void setMenu(String id, ArrayList<TMenu> menus) {
        roleMenuService.remove(new QueryWrapper<>(new TRoleMenu()).eq("role_id",id));
        for(TMenu menu:menus){
            TRoleMenu roleMenu = new TRoleMenu();
            roleMenu.setRoleId(id);
            roleMenu.setMenuId(menu.getId());
            roleMenuService.save(roleMenu);
        }
    }
}

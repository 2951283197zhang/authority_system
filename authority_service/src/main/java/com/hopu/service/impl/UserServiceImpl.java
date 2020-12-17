package com.hopu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hopu.domain.TRole;
import com.hopu.domain.TUser;
import com.hopu.domain.TUserRole;
import com.hopu.mapper.UserMapper;
import com.hopu.mapper.UserRoleMapper;
import com.hopu.service.IUserRoleService;
import com.hopu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TUser> implements IUserService {
@Autowired
private IUserRoleService userRoleService;

    @Override
    public void setRole(String id, ArrayList<TRole> roles) {
        // 移除之前关联的用户角色数据
        userRoleService.remove(new QueryWrapper<>(new TUserRole()).eq("user_id", id));
        // 新增关联的用户角色数据
        for (TRole role : roles) {
            TUserRole userrole = new TUserRole();
            userrole.setUserId(id);
            userrole.setRoleId(role.getId());
            userRoleService.save(userrole);
        }
    }
}

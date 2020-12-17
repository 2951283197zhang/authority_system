package com.hopu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hopu.domain.TUserRole;
import com.hopu.mapper.UserRoleMapper;
import com.hopu.service.IUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, TUserRole> implements IUserRoleService {
}

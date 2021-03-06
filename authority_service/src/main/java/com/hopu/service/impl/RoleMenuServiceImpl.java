package com.hopu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hopu.domain.TRoleMenu;
import com.hopu.mapper.RoleMenuMapper;
import com.hopu.service.IRoleMenuService;
import org.springframework.stereotype.Service;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, TRoleMenu> implements IRoleMenuService {
}

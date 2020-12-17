package com.hopu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hopu.domain.TMenu;
import com.hopu.mapper.MenuMapper;
import com.hopu.service.IMenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, TMenu> implements IMenuService {
}

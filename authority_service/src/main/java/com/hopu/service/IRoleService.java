package com.hopu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hopu.domain.TMenu;
import com.hopu.domain.TRole;

import java.util.ArrayList;

public interface IRoleService extends IService<TRole> {
    void setMenu(String id, ArrayList<TMenu> menus);
}

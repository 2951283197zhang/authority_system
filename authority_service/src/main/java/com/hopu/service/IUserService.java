package com.hopu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hopu.domain.TRole;
import com.hopu.domain.TUser;

import java.util.ArrayList;

public interface IUserService extends IService<TUser> {
    void setRole(String id, ArrayList<TRole> roles);
}

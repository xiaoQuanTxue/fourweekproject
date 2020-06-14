package com.wyy22.wyy.service;

import com.wyy22.wyy.entity.Users;

import java.util.List;

public interface UsersService {

/**
     * 验证用户信息（登录）
     * @param username
     * @param password
     * @return*/


    public boolean validateUser(String username,String password);

    /**
     * 获取所有用户
     * @return
     */
    List<Users> getAllUsers();

    /**
     * 注册用户
     * @param user
     * @return
     */
    void register(Users user);

    boolean registerTest(Users user);
}

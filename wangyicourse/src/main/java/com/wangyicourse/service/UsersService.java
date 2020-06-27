package com.wangyicourse.service;





import com.wangyicourse.entity.Users;

import java.util.List;

public interface UsersService {

/**
     * 验证用户信息（登录）
     * @param username
     * @param password
     * @return*/


    public Users validateUser(String username, String password);

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

    public String getUserByName(int id);

    String getTouXiangById(int id);

    void updateUserById(Users users);
    List<Users> getUserByUsername(String name);
}

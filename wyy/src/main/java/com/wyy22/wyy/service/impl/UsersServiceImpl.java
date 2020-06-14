package com.wyy22.wyy.service.impl;

import com.wyy22.wyy.entity.Users;
import com.wyy22.wyy.entity.UsersExample;
import com.wyy22.wyy.mapping.UsersMapper;
import com.wyy22.wyy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 86186
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;
    @Override
    public boolean validateUser(String username, String password) {
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andPasswordEqualTo(password).andUsernameEqualTo(username);
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users.size()>0?true:false;
    }

    @Override
    public List<Users> getAllUsers() {
        UsersExample usersExample = new UsersExample();
        return usersMapper.selectByExample(usersExample);
    }

    @Override
    public void register(Users user) {
        int rows= usersMapper.insert(user);
        System.out.println("rows="+rows);
    }

    @Override
    public boolean registerTest(Users user) {
        int rows= usersMapper.insert(user);
        System.out.println("rows="+rows);
        return rows>0?true:false;
        }
    }



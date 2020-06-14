package com.wyy22.wyy;

import com.wyy22.wyy.entity.Users;
import com.wyy22.wyy.entity.UsersExample;
import com.wyy22.wyy.mapping.UsersMapper;
import com.wyy22.wyy.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WyyApplicationTests {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    UsersService usersService;
    @Test
    void contextLoads() {
        List<Users> allUsers = usersService.getAllUsers();
        System.out.println(allUsers.get(0));
    }

}

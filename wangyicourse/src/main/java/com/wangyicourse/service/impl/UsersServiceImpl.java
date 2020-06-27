package com.wangyicourse.service.impl;



import com.wangyicourse.entity.Users;
import com.wangyicourse.entity.UsersExample;
import com.wangyicourse.mappers.UsersMapper;
import com.wangyicourse.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86186
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Users validateUser(String username, String password) {
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andPasswordEqualTo(password).andUsernameEqualTo(username);
        List<Users> users = usersMapper.selectByExample(usersExample);
        System.out.println("从数据库获取的登录用户对象"+users);
        if (users.isEmpty()){
            return null;
        }
        int userid=users.get(0).getUserid();
        System.out.println("从数据库获取的登录用户对象"+userid);
        return users.get(0);
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


    public String getUserByName(int id){
        UsersExample us=new UsersExample();
        us.createCriteria().andUseridEqualTo(id);
        Users users = usersMapper.selectByPrimaryKey(id);
        return users.getUsername();
    }

    @Override
    public String getTouXiangById(int id) {
        UsersExample us=new UsersExample();
        us.createCriteria().andUseridEqualTo(id);

//        根据id查找，id唯一，所以结果只有一个
        List<Users> users = usersMapper.selectByExample(us);
        String img= users.get(0).getImg();
        return  img;
    }


    @Override
    public void updateUserById(Users users) {

        usersMapper.updateByPrimaryKeySelective(users);

    }

    @Override
    public List<Users> getUserByUsername(String name) {
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andUsernameEqualTo(name);
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users;
    }
}



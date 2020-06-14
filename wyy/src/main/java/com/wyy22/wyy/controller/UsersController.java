package com.wyy22.wyy.controller;

import com.wyy22.wyy.entity.Users;
import com.wyy22.wyy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @author 86186
 */
@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    @Qualifier("usersService")
    private UsersService usersService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/new")
    public ModelAndView getFtl(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new");
        modelAndView.addObject("nums",99);
        return modelAndView;
    }

    @RequestMapping("/login1")
    public ModelAndView getLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

/**
     * 验证用户信息
     * @param username
     * @param password
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/validate")
    @ResponseBody
    public String validate(String username,String password){
        /*username=username.substring(1);
        password=password.substring(1);*/
        System.out.println(username);
        System.out.println(password);
        boolean b=usersService.validateUser(username,password);
        usersService.getAllUsers();
        if(b){
            return "登录成功";
        }else{
            return "登录失败";
        }
    }

    /**
     * 获取所有用户
     * @return
     */
    @GetMapping("/all")
    @ResponseBody
    public List<Users> getAll(){
        return usersService.getAllUsers();
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("/register")
    @ResponseBody
    public String register(Users user){
        usersService.register(user);
        return "注册成功";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/registerTest")
    @ResponseBody
    public String registerTest(Users user){
        usersService.registerTest(user);
        boolean b=usersService.registerTest(user);
        if(b){
            return "注册成功";
        }else{
            return "注册失败";
        }
    }
}

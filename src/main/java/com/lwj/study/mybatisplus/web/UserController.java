package com.lwj.study.mybatisplus.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lwj.study.mybatisplus.entity.User;
import com.lwj.study.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 房屋配置信息 前端控制器
 * </p>
 *
 * @author liangwj9
 * @since 2017-11-26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/insert")
    @ResponseBody
    public User insert(User user){
        userService.insert(user);
        return user;
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<User>  search(){
        List<User> users = userService.selectList(new EntityWrapper<>());
        return users;
    }


    @RequestMapping("/update")
    @ResponseBody
    public boolean update(String id){
        User user = userService.selectById(id);
        user.setUserName("测试");
        boolean b = userService.updateById(user);
        return b;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteAll(Integer id){
        boolean delete = userService.deleteById(id);
        return delete;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public boolean deleteAll(){
        boolean delete = userService.delete(new EntityWrapper<User>());
        return delete;
    }
	
}

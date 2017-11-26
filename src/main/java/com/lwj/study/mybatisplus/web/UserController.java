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

    @RequestMapping("/search")
    @ResponseBody
    public List<User>  search(){
        List<User> users = userService.selectList(new EntityWrapper<>());
        return users;
    }
	
}

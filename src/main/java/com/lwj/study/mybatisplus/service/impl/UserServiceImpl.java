package com.lwj.study.mybatisplus.service.impl;

import com.lwj.study.mybatisplus.entity.User;
import com.lwj.study.mybatisplus.mapper.UserMapper;
import com.lwj.study.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 房屋配置信息 服务实现类
 * </p>
 *
 * @author liangwj9
 * @since 2017-11-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}

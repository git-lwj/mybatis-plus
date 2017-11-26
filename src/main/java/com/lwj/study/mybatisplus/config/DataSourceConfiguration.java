package com.lwj.study.mybatisplus.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author liangwj9
 * @Date 16/11/24
 * @Time 下午4:00
 */
@Configuration
public class DataSourceConfiguration {



    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource druidDataSource(
                                      @Value("${spring.datasource.driver-class-name}")String driver,
                                      @Value("${spring.datasource.url}")String url,
                                      @Value("${spring.datasource.username}")String username,
                                      @Value("${spring.datasource.password}")String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }




}

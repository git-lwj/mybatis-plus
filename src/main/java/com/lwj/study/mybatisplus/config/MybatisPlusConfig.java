package com.lwj.study.mybatisplus.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.lwj.study.mybatisplus.hanler.MyMetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liangwj
 * @version 1.0
 * 2017/11/8.
 */
@Configuration
@MapperScan("com.lwj.study.mybatisplus.mapper")
public class MybatisPlusConfig {


    @Bean
    public MyMetaObjectHandler myMetaObjectHandler(){
        return new MyMetaObjectHandler();
    }


    @Bean
    public GlobalConfiguration globalConfiguration(@Autowired MyMetaObjectHandler myMetaObjectHandler){
        GlobalConfiguration globalConfiguration = new GlobalConfiguration(new LogicSqlInjector());
        globalConfiguration.setMetaObjectHandler(myMetaObjectHandler);
        globalConfiguration.setLogicDeleteValue("1");
        globalConfiguration.setLogicNotDeleteValue("0");
        return globalConfiguration;
     }

     @Bean
     public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(@Autowired DruidDataSource dataSource,@Autowired GlobalConfiguration globalConfiguration){
         MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
         sqlSessionFactoryBean.setGlobalConfig(globalConfiguration);
         sqlSessionFactoryBean.setDataSource(dataSource);
         return sqlSessionFactoryBean;
     }

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
        return paginationInterceptor;
    }


    /**
     * 执行分析插件
     *SQL 执行分析拦截器【 目前只支持 MYSQL-5.6.3 以上版本 】，
     * 作用是分析 处理 DELETE UPDATE 语句， 防止小白或者恶意 delete update 全表操作！
     * @return
     */
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor() {
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        sqlExplainInterceptor.setStopProceed(true);
        return sqlExplainInterceptor;
    }

    /**
     * SQL执行效率插件
     * 超过1000秒的抛异常
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000L);
        return performanceInterceptor;
    }


    /**
     * 乐观锁插件
     * 版本对比 配合@version注释
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }


}

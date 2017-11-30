package com.lwj.study.mybatisplus.config;

import com.lwj.study.mybatisplus.DbContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author liangwj9
 * @version 1.0
 * @since 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 取得当前使用哪个数据源
     *
     * @return
     */
    @Override
    protected String determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}




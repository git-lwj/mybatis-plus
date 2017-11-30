package com.lwj.study.mybatisplus;

import java.time.LocalDateTime;

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
public enum  DBTypeEnum {

    one("dataSource_one"),
    two("dataSource_two");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

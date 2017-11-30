package com.lwj.study.mybatisplus.hanler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Objects;

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
public class MyMetaObjectHandler extends MetaObjectHandler {



    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName("createTime", metaObject);
        if(Objects.isNull(createTime)){
            setFieldValByName("createTime", System.currentTimeMillis(), metaObject);
        }
        setFieldValByName("isDelete", 1, metaObject);
        setFieldValByName("lastModifyTime", System.currentTimeMillis(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("lastModifyTime", System.currentTimeMillis(), metaObject);
    }
}

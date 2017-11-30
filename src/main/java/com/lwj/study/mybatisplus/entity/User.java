package com.lwj.study.mybatisplus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 房屋配置信息
 * </p>
 *
 * @author liangwj9
 * @since 2017-11-26
 */
@Data
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 房Id
     */
	@TableField("user_code")
	private Long userCode;
    /**
     * 配置工号
     */
	@TableField("user_name")
	private String userName;
    /**
     * 配置电话
     */
	@TableField("user_phone")
	private String userPhone;
    /**
     * 创建时间
     */
	@TableField(value = "create_time",fill = FieldFill.INSERT)
	private Long createTime;
    /**
     * 最后修改时间
     */
    @Version
	@TableField(value = "last_modify_time",fill = FieldFill.INSERT_UPDATE)
	private Long lastModifyTime;
    /**
     * 是否删除
     */
	@TableField(value = "is_delete",fill = FieldFill.INSERT)
	@TableLogic
	private Integer isDelete;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

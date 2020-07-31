package com.atzlq.micro.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * 
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-07-31 18:11:51
 */
@ApiModel
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "ID")
	private Integer id;
	/**
	 * 帐号
	 */
	@ApiModelProperty(name = "account",value = "帐号")
	private String account;
	/**
	 * 密码
	 */
	@ApiModelProperty(name = "password",value = "密码")
	private String password;
	/**
	 * 昵称
	 */
	@ApiModelProperty(name = "username",value = "昵称")
	private String username;
	/**
	 * 注册时间
	 */
	@ApiModelProperty(name = "regTime",value = "注册时间")
	private Date regTime;

}

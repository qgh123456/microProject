package com.atzlq.micro.role.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户角色表
 * 
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-07-31 18:11:51
 */
@ApiModel
@Data
@TableName("user_role")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "ID")
	private Integer id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(name = "userId",value = "用户id")
	private Integer userId;
	/**
	 * 角色id
	 */
	@ApiModelProperty(name = "roleId",value = "角色id")
	private Integer roleId;

}

package com.atzlq.micro.role.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import lombok.Data;

/**
 * 角色表
 *
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-07-31 18:11:51
 */
@ApiModel
@Data
@TableName("role")
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(name = "id", value = "ID")
    private Integer id;
    /**
     * 角色名称
     */
    @ApiModelProperty(name = "name", value = "角色名称")
    private String name;

}

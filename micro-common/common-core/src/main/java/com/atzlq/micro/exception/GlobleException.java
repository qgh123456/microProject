package com.atzlq.micro.exception;

import com.atzlq.micro.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ProjectName: microProject
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/7/30 17:04
 */
@Data
@ApiModel(value = "自定义全局异常类")
public class GlobleException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    /**
     * 接收状态码和错误消息
     * @param code
     * @param message
     */
    public GlobleException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public GlobleException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}

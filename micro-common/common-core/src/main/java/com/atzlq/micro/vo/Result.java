package com.atzlq.micro.vo;

import com.atzlq.micro.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author helen
 * @since 2019/6/24
 */
@Data
@ApiModel(value="全局统一返回结果")
public class Result<T> {

	@ApiModelProperty(value = "是否成功")
	private Boolean success;

	@ApiModelProperty(value = "返回码",example = "20000")
	private Integer code;

	@ApiModelProperty(value = "返回消息")
	private String message;

	@ApiModelProperty(value = "返回数据")
	private T data ;

	private Result(){}

	public static Result ok(){
		Result result = new Result();
		result.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
		result.setCode(ResultCodeEnum.SUCCESS.getCode());
		result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
		return result;
	}

	public static Result error(){
		return error(ResultCodeEnum.UNKNOWN_REASON.getMessage());
	}

	public  static Result error(String message){
		Result result = new Result();
		result.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
		result.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
		result.setMessage(message);
		return result;
	}
	public Result data(T t){
		this.setData(t);
		return this;
	}



	public Result message(String message){
		this.setMessage(message);
		return this;
	}

	public Result code(Integer code){
		this.setCode(code);
		return this;
	}

	public Result success(Boolean success){
		this.setSuccess(success);
		return this;
	}

	public static Result setResult(ResultCodeEnum resultCodeEnum){
		Result result = new Result();
		result.setSuccess(resultCodeEnum.getSuccess());
		result.setCode(resultCodeEnum.getCode());
		result.setMessage(resultCodeEnum.getMessage());
		return result;
	}
}

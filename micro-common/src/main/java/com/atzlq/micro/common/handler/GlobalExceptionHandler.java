package com.atzlq.micro.common.handler;

import com.atzlq.micro.common.constants.ResultCodeEnum;
import com.atzlq.micro.common.exception.GlobleException;
import com.atzlq.micro.common.util.ExceptionUtil;
import com.atzlq.micro.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.naming.SizeLimitExceededException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author qiguohui
 * @since 2019/6/25
 * 统一异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 异常处理方法
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public Result error(Exception e){
		//e.printStackTrace();//输出异常堆栈信息
		log.error(e.getMessage());
		return Result.error();
	}
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result error(HttpRequestMethodNotSupportedException e){
	log.error(e.getMessage());
	return Result.error(e.getMessage());
}
	@ExceptionHandler(BadSqlGrammarException.class)
	public Result error(BadSqlGrammarException e){
		//e.printStackTrace();//输出异常堆栈信息
		log.error(e.getMessage());
		//return R.error().code(20003).message("SQL语法错误");
		return Result.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Result error(HttpMessageNotReadableException e){
		//e.printStackTrace();//输出异常堆栈信息
		log.error(e.getMessage());
		return Result.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
	}


	@ExceptionHandler(SizeLimitExceededException.class)
	public Result error(SizeLimitExceededException e){
		log.info("错误信息----------------------------");
		log.error(e.getMessage());
		return Result.setResult(ResultCodeEnum.FILE_UPLOAD_ERROR);
	}

	@ExceptionHandler(GlobleException.class)
	public Result error(GlobleException e){
		log.error(ExceptionUtil.getMessage(e));
		return Result.error().message(e.getMessage()).code(e.getCode());
	}


	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result handle(ValidationException exception) {
		//描述错误消息的集合
		Map<String, Object> data = new HashMap<String, Object>();
		if(exception instanceof ConstraintViolationException){
			ConstraintViolationException exs = (ConstraintViolationException) exception;
			Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
			for (ConstraintViolation<?> item : violations) {
				//定义有问题的节点
				PathImpl propertyPath = (PathImpl)item.getPropertyPath();
				//获取节点的名称
				String filedName = propertyPath.getLeafNode().getName();
				//定义错误的描述
				String errorMsg = item.getMessage();
				data.put(filedName,errorMsg);
				System.out.println(item.getMessage());
			}
		}
		return Result.setResult(ResultCodeEnum.PARAM_ERROR).data(data);
	}


}

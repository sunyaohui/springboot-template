package com.thyme.sun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thyme.sun.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(description = "用户")
@EnableSwagger2
@RestController
@RequestMapping("/user")
public class UserController {

	@ApiOperation(value = "获取用户")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successful — 请求已完成"),
		@ApiResponse(code = 302, message = "token失效"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源"),
        @ApiResponse(code = 500, message = "服务器不能完成请求")
	}) 
	@ResponseBody
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public User get() {
		User user = new User();
		user.setId(1);
		user.setName("thyme.sun");
		user.setAge(22);
		user.setDescription("thyme springboot swagger test");
		return user;
	}
	
}
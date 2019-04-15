package com.thyme.sun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User",description = "UserBean")
public class User {

	@ApiModelProperty(value = "主键",name = "id")
	private Integer id;
	
	@ApiModelProperty(value = "姓名" , name = "name")
	private String name;
	
	@ApiModelProperty(value = "年龄" , name = "age")
	private Integer age;
	
	@ApiModelProperty(value = "备注", name = "description")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}

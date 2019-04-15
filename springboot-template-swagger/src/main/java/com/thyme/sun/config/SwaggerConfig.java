package com.thyme.sun.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
//	private static final String TITLE = "api文档";
	private String TITLE = YmlConfigStore.get("title", String.class);
	
//	版本
	private static final String VERSION = "1.0";
//	private String VERSION = YmlConfigStore.get("version", String.class);
	//监控所有的url
	private static final String INTERCEPT_URL = "/.*";
//	private String INTERCEPT_URL = YmlConfigStore.get("interceptor_url", String.class);
	
	private static final String ALL_URL = "/.*";
	//参数:token
	private static final String HEADER_NAME = "token";
//	private String HEADER_NAME = YmlConfigStore.get("header_name", String.class);
	
	//参数备注信息
	private static final String HEADER_DESCRIPTION = "请求头信息";
//	private String HEADER_DESCRIPTION = YmlConfigStore.get("header_description", String.class);
	
	//请求参数类型，header
	private static final String HEADER_PAR_TYPE = "header";
//	private String HEADER_PAR_TYPE =	YmlConfigStore.get("header_par_type", String.class);
	//是否必填:非必填
	private static final Boolean HEADER_PAR_REQUIRED = false;
//	private Boolean HEADER_PAR_REQUIRED = YmlConfigStore.get("header_par_required", Boolean.class);
	//参数数据类型，String
	private static final String DATA_TYPE = "string";
//	private String DATA_TYPE = YmlConfigStore.get("data_type", String.class);
	
	@Bean
	public Docket api() {
		ApiSelectorBuilder asb = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo(TITLE))
				.pathMapping("/")
				.select();
		List<String> list = YmlConfigStore.get("filter_url", List.class);
		if(list != null) {
			for (int i = 0; i < list.size(); i++) {
				asb.paths(Predicates.not(PathSelectors.regex(list.get(i))));
			}
		}
		if(INTERCEPT_URL == null || INTERCEPT_URL.equals("")) {
			return asb.paths(PathSelectors.regex(ALL_URL))
					.build()
					.globalOperationParameters(parameterBuilder());
		}
		return asb.paths(PathSelectors.regex(INTERCEPT_URL))
			.build()
			.globalOperationParameters(parameterBuilder());
    }
	
	private List<Parameter> parameterBuilder() {
    	ParameterBuilder tokenPar = new ParameterBuilder();
    	List<Parameter> pars = new ArrayList<Parameter>();
    	tokenPar.name(HEADER_NAME)
    			.description(HEADER_DESCRIPTION)
    			.modelRef(new ModelRef(DATA_TYPE))
    			.parameterType(HEADER_PAR_TYPE)
    			.required(HEADER_PAR_REQUIRED)
    			.build();
    	 pars.add(tokenPar.build());
    	 return pars;
	}

	private ApiInfo apiInfo(String desc) {
        return new ApiInfoBuilder()
                .title(desc)
                .version(VERSION)
                .build();
    }

}

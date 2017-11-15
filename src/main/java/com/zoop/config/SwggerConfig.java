package com.zoop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * 生成接口文档的主配置
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"com.zoop.controller"})
public class SwggerConfig {

	@Bean
	public Docket customDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("zoop", "https://zoop.com", "jiji@icloud.com");
		return new ApiInfo("Blog前台API接口",//大标题 title
                "Blog前台API接口",//小标题
                "0.0.1",//版本
                "www.fangshuoit.com",//termsOfServiceUrl
                contact,//作者
                "Blog",//链接显示文字
                "https://cc520.me"//网站链接
        );
	}
}

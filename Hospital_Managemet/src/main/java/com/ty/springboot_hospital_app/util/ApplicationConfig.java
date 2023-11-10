package com.ty.springboot_hospital_app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	public Docket getDocket() {
		Contact contact = new Contact("TestYantra", "www.testyantra.com", "tysupport@gmail.com");

		List<VendorExtension> extensions = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("Hospital Management System", "Hospital Management System v1.0", "version 1.0", "www.testyantraservice.com", contact,
				"Akshada Shinde", "www.testyantra.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.springboot_hospital_app")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}

}

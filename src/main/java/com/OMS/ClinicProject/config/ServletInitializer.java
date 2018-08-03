package com.OMS.ClinicProject.config;

import com.OMS.ClinicProject.ClinicProjectApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ClinicProjectApplication.class);
	}

}
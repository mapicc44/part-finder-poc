package com.halfords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.halfords.config.HalfordsPartFinderApplicationConfig;
import com.halfords.config.HalfordsPartFinderSecurityConfig;

@SpringBootApplication
public class HalfordsPartFinderApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(
				HalfordsPartFinderApplication.class, 
				HalfordsPartFinderApplicationConfig.class, 
				HalfordsPartFinderSecurityConfig.class);
	}

    public static void main(String[] args) {
        SpringApplication.run(HalfordsPartFinderApplication.class, args);
    }
}

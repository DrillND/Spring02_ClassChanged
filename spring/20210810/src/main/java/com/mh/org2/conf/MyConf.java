package com.mh.org2.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mh.org2.cls.BB;

@Configuration
public class MyConf {
	
	@Bean
	public BB bb() {
		return new BB();
	}
	
}

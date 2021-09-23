package org1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AnnoConf {
	
	@Bean
	public MemberService memberService() {
		MemberService ms = new MemberService();
		return ms;
	}
}

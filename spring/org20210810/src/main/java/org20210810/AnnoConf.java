package org20210810;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoConf {

	@Bean
	@Qualifier("aa1")
	public AA aa1() {
		return new AA();
	}// 객체담는 통에 AA를 넣는다. 
	
	@Bean
	@Qualifier("aa2")
	public AA aa2() {
		return new AA();
	}// 객체담는 통에 AA를 넣는다. 강제로 통에 AA를 두개 넣음 그럴때 퀄리파이어 지정하면 됨
	
	@Bean
	public Lib lib() {
		return new Lib();
	}
}

package org;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainXmlConfig {
	
	/*
	 * spring 3.xx 버전 -> xml 객체 생성조립
	 * spring 5.xx 버전 -> 어노테이션 객체 생성 조립
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext("classpath:myconf.xml");
		AA a1 = gxac.getBean(AA.class);
		AA a2 = gxac.getBean(AA.class);
		
		System.out.println(a1);
		System.out.println(a2);
		
		
		System.out.println(a1==a2?"true":"false");
		gxac.close();
	}
}

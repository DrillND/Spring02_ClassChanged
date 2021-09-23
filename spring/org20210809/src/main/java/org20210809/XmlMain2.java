package org20210809;

import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlMain2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext("classpath:XmlConf2.xml");
		// Xml 방식으로 객체 통 생성

		// 싱글톤 패턴... 메모리 상에 하나만 만듦(스프링은 경량 컨테이너다. jsp보다 처음에는 느리지만 돌아가는 속도는 빠르다.)

		/*
		 * xml....
		 * 생성자 방식으로 DI
		 * set 방식으로 DI
		 */
		A a1 = gxac.getBean(A.class);
		A a2 = gxac.getBean(A.class);
		B b = gxac.getBean(B.class);

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(b);
		
		System.out.println(a1.getAa());
		a1.setAa(200);
		System.out.println(a2.getAa());
		
		System.out.println(b.getA().getAa());
		
		gxac.close();
	}

}
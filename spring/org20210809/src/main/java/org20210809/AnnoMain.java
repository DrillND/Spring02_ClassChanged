package org20210809;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoMain {
	public static void main(String[] args) {
		
		/*
		 *  AnnoMain -> 메인함수..
		 *  AnnotationConfigApplicationContext 객체담는 통
		 *  AnnoConf 객체 설정정보 담는 클래스
		 *  A...객체 담는 통안에 들어 갈 클래스
		 *  B...객체 담는 통안에 들어 갈 클래스
		 */
		
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AnnoConf.class);
		// 어노테이션 방식으로 객체 통 생성
		
		//싱글톤 패턴... 메모리 상에 하나만 만듦(스프링은 경량 컨테이너다. jsp보다 처음에는 느리지만 돌아가는 속도는 빠르다.)
	
		A a1 = acac.getBean(A.class);
		A a2 = acac.getBean(A.class);
		B b = acac.getBean(B.class);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(b);
		
		acac.close();
	}
}

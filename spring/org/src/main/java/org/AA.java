package org;

public class AA {
	private static AA aa = new AA(); // 메모리상에 계속 있는 함수
	public static AA getInstance() {
		return aa;
	}
	
}

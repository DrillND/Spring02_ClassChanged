package org20210810;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Lib {
	
	@Autowired
	@Qualifier("aa1")
	AA aa;//AA를 주입
	
	@Autowired(required = false) //required = false 주입되는게 없더라도 에러를 표시하지 말아달라
	BB bb;
	
	public void print() {
		aa.doAA();
	}
}

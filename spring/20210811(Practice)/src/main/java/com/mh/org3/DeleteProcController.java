package com.mh.org3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mh.org3.db.DBManager;

@Controller
public class DeleteProcController {

	@Autowired // 객체통에서 꺼내 온다.
	DBManager dbm;

	// 싱글톤 통 안에 들어감
	@RequestMapping(value = "/deleteproc", method = RequestMethod.POST)
	public String deleteproc(Model model, String dpara1) {
		dbm.deletetest(dpara1);
		return "deleteproc";
	}
}

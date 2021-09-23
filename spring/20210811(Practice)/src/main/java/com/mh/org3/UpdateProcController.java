package com.mh.org3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mh.org3.db.DBManager;

@Controller
public class UpdateProcController {
	@Autowired // 객체통에서 꺼내 온다.
	DBManager dbm;

	// 싱글톤 통 안에 들어감
	@RequestMapping(value = "/updateproc", method = RequestMethod.POST)
	public String updateproc(Model model, String upara1, String upara2) {
		dbm.updatetest(upara1,upara2);
		return "updateproc";
	}
}

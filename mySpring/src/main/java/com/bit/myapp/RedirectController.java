package com.bit.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectController {
	
	@RequestMapping(value = "studentConfirm")
	public String studentConfirm(@RequestParam("id") String id) {
		if(id.equals("aaa"))
			return "redirect:studentOK";
		return "redirect:studentNG";
	}

	@RequestMapping(value = "studentOK")
	public String studentOK() {
		return "student/studentOK";
	}
	
	@RequestMapping(value = "studentNG")
	public String studentNG() {
		return "student/studentNG";
	}
}

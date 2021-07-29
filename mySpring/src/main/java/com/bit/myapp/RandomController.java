package com.bit.myapp;


import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// spring 어노테이션 : 기능을 표시한것.@
// 따로 import 필요없음 @DeclareAnnotation @Overiide
@Controller
public class RandomController {
	
	//Controller에 있는 메소드 호출은 반드시 Action명으로 호출
	//액션명은 반드시 unique 중복있으면 실행안됨
	@RequestMapping("/random")
	
	public String random(Model model) {
		Random r = new Random();
		int lucky = r.nextInt(45)+1; //1~45사이의 난수
		model.addAttribute("Lucky",lucky);
		return "random"; //views/random.jsp 호출
	}
}

package com.bit.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.myapp.dto.MemberDto;

@Controller
public class MemberController {
	
	//단순한 views 안에 있는 jsp호출
	@RequestMapping("member/loginForm")
	//member/loginForm.jsp 호출
	public String loginForm() {return "member/loginForm";}
	
	@RequestMapping("member/confirmId")
	public String confirmId(HttpServletRequest req, Model model) {
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
	//	System.out.println(id + ":" + pwd);
		model.addAttribute("id",id);
		model.addAttribute("pwd", pwd);
		//views/member/confirmId.jsp 호출
		return "member/confirmId";
	}
	
	@RequestMapping("member/confirmId1")
	//HttpServletRequest req
	//@RequestParam -> request.getParameter("id")
	public String confirmId(@RequestParam("id") String id, 
			@RequestParam("pwd") String pwd, Model model) {
		model.addAttribute("id",id);
		model.addAttribute("pwd", pwd);
		//views/member/confirmId.jsp 호출
		return "member/confirmId";
	}
	
	//단순한 views 안에 있는 jsp호출
		@RequestMapping("member/joinForm")
		//member/loginForm.jsp 호출
		public String joinForm() {
			return "member/joinForm";
			}
		
		@RequestMapping(value = "member/join", method = RequestMethod.POST)
		public String join(@RequestParam("id") String id,
				@RequestParam("pwd") String pwd,
				@RequestParam("name") String name,
				@RequestParam("email") String email, Model model) {
			MemberDto dto = new MemberDto();
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setName(name);
			dto.setEmail(email);
			model.addAttribute("member", dto);
			return "member/join";
		}
		
		@RequestMapping(value = "member/join1", method = RequestMethod.POST)
		//@ModelAttribute : request, MemberDto 객체를 생성
		//자동적으로 setter가 호출
		//@ModelAttribute("member",dto);가 실행된것
		public String join1(@ModelAttribute("member") MemberDto memder) {
			return "member/join";
		}
		
		@RequestMapping(value = "member/student/{studentId}/{num}")
		public String student(@PathVariable String studentId,
				@PathVariable int num, Model model) {
			model.addAttribute("studentId",studentId);
			model.addAttribute("num",num);
			return "member/student";
		}
		
		@RequestMapping("member/getPostForm")
		public String getPostForm() {
			return "member/getPostForm";
		}
		
		@RequestMapping(value = "member/goGet", method = RequestMethod.GET)
		public String goMethod(@RequestParam("id") String id, Model model) {
			model.addAttribute("id", id);
			return "member/goGet"; // goGet.jsp
		}
		
		@RequestMapping(value = "member/goPost", method = RequestMethod.POST)
		public ModelAndView goMethod(@RequestParam("id") String id) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("id", id);
			mv.setViewName("member/goGet");
			return mv; // goGet.jsp
		}

}

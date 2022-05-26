package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.common.SessionName;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController implements SessionName{
	@Autowired MemberService ms;
	@GetMapping("/login")
	public String loginForm() {
		return "member/login";
	}
	@PostMapping("/logChk")
	public String logChk(//HttpServletRequest req
						@RequestParam String id,
						@RequestParam String pwd,
						RedirectAttributes ra
						) {
		int result = ms.logChk(id, pwd);
		if(result == 0 ) {
			//ra.addFlashAttribute("id", id);
			ra.addAttribute("id", id);
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	@RequestMapping("/successLogin")
	public String successLogin(
						@RequestParam("id") String id,
						HttpSession session) {
		session.setAttribute(LOGIN, id);
		return "member/successLogin";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		ms.memberInfo(model);
		return "member/memberInfo";
	}
	@GetMapping("info")
	public String info(Model model, @RequestParam String id) {
		ms.info(model, id);
		return "member/info";
	}
}


















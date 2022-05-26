package com.care.root.member.service;

import org.springframework.ui.Model;

public interface MemberService {
	public int logChk(String id, String pwd);
	public void memberInfo(Model model);
	public void info(Model model,String id);
}











package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper mapper;
	
	public int logChk(String id, String pwd) {
		int result = 1;
		// select * from table where id=id
		MemberDTO dto = mapper.logChk(id);
		if(dto != null) {
			if(dto.getPw().equals(pwd)) {
				return 0;
			}
		}
		return result;
	}
	public void memberInfo(Model model) {
		model.addAttribute("memberList", 
								mapper.memberInfo() );
	}
	public void info(Model model, String id) {
		model.addAttribute("info", mapper.logChk(id) );
	}
}












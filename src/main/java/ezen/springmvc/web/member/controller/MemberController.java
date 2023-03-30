package ezen.springmvc.web.member.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ezen.springmvc.domain.member.dto.Member;
import ezen.springmvc.domain.member.service.MemberService;


@Controller
@RequestMapping("/springmvc/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	//http://localhost/springmvc/members 들어가면 이게 나옴.
	@GetMapping
	public String members(Model model) {
		// 서비스 객체를 이용한 회원 목록
		List<Member> members = memberService.getMembers(); //진짜 디비에 있는 리스트
		model.addAttribute("members", members); //모델에 멤버즈 저장한다.
		return "member/list";
	}
	
	@GetMapping("/{userId}")
	public String view(@PathVariable String userId, Model model) {
		Member member = memberService.getMember(userId);
		model.addAttribute("member", member);
		return "member/view";
	}
}

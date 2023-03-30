package ezen.springmvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ezen.springmvc.domain.member.dto.Member;
import ezen.springmvc.domain.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest //테스트클래스
@Slf4j //로그 때문에 찍은거
class MemberServiceTest {
	
	@Autowired
	MemberService memberService; //걍 오토 와이어드로 주입
	
	@Test
	void getMembersTest() {
		List<Member> list = memberService.getMembers();
		log.info("전체목록 : {}", list);
	}
	
	@Test
	void getMemberTest() {
		Member member = memberService.getMember("bangry");
		log.info("회원상세 : {}", member);
	}
	

}

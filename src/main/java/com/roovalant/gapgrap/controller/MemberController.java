package com.roovalant.gapgrap.controller;

import com.roovalant.gapgrap.domain.Member;
import com.roovalant.gapgrap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("memberService getClasee = " + memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // 회원가입
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("회원등록 = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    // 회원조회
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}

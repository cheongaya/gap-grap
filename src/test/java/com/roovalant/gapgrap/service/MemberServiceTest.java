package com.roovalant.gapgrap.service;

import com.roovalant.gapgrap.domain.Member;
import com.roovalant.gapgrap.repository.MemberRepository;
import com.roovalant.gapgrap.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given (테스트는, 상황이 주어져서)
        Member member1 = new Member();
        member1.setName("member1");

        //when (이걸 실행했을때)
        Long saveId = memberService.join(member1);

        //then (이 결과가 나와야함)
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertEquals(member1.getName(), findMember.getName());
    }
    @Test
    void 중복_회원_예외_테스트() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
//        memberService.join(member2);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertEquals(e.getMessage(), "이미 존재하는 회원입니다2.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertEquals(e.getMessage(), "이미 존재하는 회원입니다.");
//        }

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
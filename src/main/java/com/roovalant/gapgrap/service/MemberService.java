package com.roovalant.gapgrap.service;

import com.roovalant.gapgrap.domain.Member;
import com.roovalant.gapgrap.repository.MemberRepository;
import com.roovalant.gapgrap.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional // 스프링은 해당 클래스의 메서드를 실행할 때 트랜잭션을 시작하고, 메서드가 정상 종료되면 트랜잭션을 커밋한다. 만약 런타임 예외가 발생하면 롤백한다.
public class MemberService {

    private final MemberRepository memberRepository;

    // DI (의존성 주입)
//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 중복회원 검증 : 이미 이름이 같은 회원이 있다면, 에러 리턴
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();

        // TODO : 회원 조회 시간 측정 추가
//        long start = System.currentTimeMillis();
//
//        // 같은 이름이 있는 중복 회원 x
//        try{
//            validateDuplicateMember(member);
//            memberRepository.save(member);
//            return member.getId();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join = " + timeMs + "ms");
//        }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();

        // TODO : 회원 조회 시간 측정 추가
//        long start = System.currentTimeMillis();
//
//        try {
//            return memberRepository.findAll();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("findMembers " + timeMs + "ms");
//        }
    }

    /**
     * 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

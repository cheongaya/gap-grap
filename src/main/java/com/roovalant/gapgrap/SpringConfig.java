package com.roovalant.gapgrap;

import com.roovalant.gapgrap.repository.*;
import com.roovalant.gapgrap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 자바 코드로, 직접 스프링 빈을 등록하는 방법
    // @Bean : spring bean을 등록할 거라는 의미
    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

//    // 반환형을 인터페이스 타입으로 작성함 : 추후 리포지토리 변경 용이
//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource); // JdbcTemplate 회원 리포지토리를 스프링 컨테이너에 등록
//        return new JpaMemberRepository(em);
//    }
}

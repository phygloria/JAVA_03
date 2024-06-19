package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정정보관리
public class ContextConfiiguration {

    @Bean(name = "account")
    public Account accountGenerator(){
        return new PersonalAccount(20, "3333-03-2323232");

    }

    @Bean(name = "member")
    public MemberDTO memberGenerator(){
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("홍길동");
        member.setPhone("010-2222-3333");
        member.setEmail("hong124@gmail.com");
        member.setPersonalAccount(accountGenerator());

        return member;
    }


}

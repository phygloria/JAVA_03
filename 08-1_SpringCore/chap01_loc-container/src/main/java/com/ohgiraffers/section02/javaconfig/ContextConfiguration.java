package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationSection02") //정보들을 저장하는 곳
public class ContextConfiguration {

    @Bean(name = "member")
    public MemberDTO getMemberDTO(){
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }



}

package com.ohgiraffers.chap07thymeleaf.controller;

import com.ohgiraffers.chap07thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.chap07thymeleaf.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("lecture")
public class LectureController {
    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){
        mv.addObject("member", new MemberDTO("개발세발", 20000,'남',"프젝3 화이팅"));
        mv.addObject("testAlert", "hello! 팝업입니당");
        mv.setViewName("lecture/expression");
        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv){
        mv.addObject("num", 1);
        mv.addObject("str", "사과");
        List<MemberDTO> memberDTOList = new ArrayList<>();
        memberDTOList.add(new MemberDTO("홍길동", 19, '남', "서초구"));
        memberDTOList.add(new MemberDTO("홍길준", 32, '남', "강남구"));
        memberDTOList.add(new MemberDTO("홍길선", 18, '남', "광진구"));
        memberDTOList.add(new MemberDTO("홍길홍", 17, '남', "노원구"));
        memberDTOList.add(new MemberDTO("홍길감", 21, '남', "강동구"));
        mv.addObject("memberList", memberDTOList);
        mv.setViewName("/lecture/conditional");

        return mv;
    }



    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv){
        SelectCriteria selectCriteria = new SelectCriteria(1, 10, 3);
        mv.addObject("selectCriteria", selectCriteria);

        MemberDTO member = new MemberDTO("홍길동", 20, '남', "서울시 서초구");

        mv.addObject("member", member);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        memberList.add(new MemberDTO("유관순", 22, '여', "서울시 노원구"));
        memberList.add(new MemberDTO("장보고", 40, '남', "서울시 종로구"));
        memberList.add(new MemberDTO("신사임당", 30, '여', "서울시 성북구"));

        mv.addObject("memberList", memberList);
        // 데이터 전달  memberlsit로 포장하고 mv로 데이터 전달


        Map<String, MemberDTO> memberMap = new HashMap<>();
        memberMap.put("m01", new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        memberMap.put("m02", new MemberDTO("유관순", 22, '여', "서울시 노원구"));
        memberMap.put("m03", new MemberDTO("장보고", 40, '남', "서울시 종로구"));
        memberMap.put("m04", new MemberDTO("신사임당", 30, '여', "서울시 성북구"));

        mv.addObject("memberMap", memberMap);
        mv.setViewName("/lecture/etc");
        return mv;
    }

    @GetMapping("/fragment")
    public ModelAndView fragment(ModelAndView mv){
        mv.addObject("test1", "values1");
        mv.addObject("test2", "values2");
        mv.addObject("testAlert", "hello! 팝업입니당");
        mv.setViewName("/lecture/fragment");
        return mv;
    }






}
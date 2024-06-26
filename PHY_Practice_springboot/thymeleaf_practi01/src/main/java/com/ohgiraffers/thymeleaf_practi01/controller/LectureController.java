package com.ohgiraffers.thymeleaf_practi01.controller;

import com.ohgiraffers.thymeleaf_practi01.model.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lecture")
public class LectureController {

    @GetMapping("movieInfo")
    public ModelAndView movieInfo(ModelAndView mv){
        mv.addObject("member01", new MemberDTO("이상한 변호사 우영우", 2022, "대한민국 | 낭만크루"));
        mv.addObject("member02", new MemberDTO("내일", 2022, "대한민국 | 스튜디오N"));
        mv.addObject("member03", new MemberDTO("나는 내일 어제의 너와 만난다", 2016, "일본 | 도호주식회사"));
        mv.addObject("member04", new MemberDTO("절대쌍교", 2020, "중국 | CCTV8"));
        mv.addObject("member05", new MemberDTO("침향여설", 2022, "중국 | YOUKU"));
        mv.setViewName("lecture/movieInfo");
        return mv;
    }

    @GetMapping("movieDetail")
    public ModelAndView movieDetail(ModelAndView mv){
        mv.setViewName("lecture/movieDetail");
        return mv;
    }

//    @GetMapping("koreaDrama")
//    public ModelAndView koreaDrama(ModelAndView mv){
//
//        mv.setViewName("lecture/koreaDrama");
//        return mv;
//    }


}


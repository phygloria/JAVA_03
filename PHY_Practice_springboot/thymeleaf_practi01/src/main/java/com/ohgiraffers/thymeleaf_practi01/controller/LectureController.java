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
        mv.addObject("member01", new MemberDTO("인사이드아웃2", 2024, "디즈니·픽사"));
        mv.addObject("member02", new MemberDTO("쿵푸팬더4", 2024, "드림웍스"));
        mv.addObject("member03", new MemberDTO("캐리비안의해적5", 2017, "디즈니"));
        mv.addObject("member04", new MemberDTO("엘리멘탈", 2023, "데니즈림"));
        mv.addObject("member05", new MemberDTO("굴뚝마을의 푸펠", 2021, "STUDIO4℃"));
        mv.setViewName("lecture/movieInfo");
        return mv;
    }

    @GetMapping("movieDetail")
    public ModelAndView movieDetail(ModelAndView mv){
        mv.setViewName("lecture/movieDetail");
        return mv;
    }


}

package com.ohgiraffers.blog.hayoung.controller;


import com.ohgiraffers.blog.hayoung.model.dto.BlogDTO;
import com.ohgiraffers.blog.hayoung.service.HayoungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hayoung")
public class HayoungController {

    private final HayoungService hayoungService;

    @Autowired
    public HayoungController(HayoungService hayoungService){

        this.hayoungService = hayoungService;
    }


    @GetMapping
    public String indexHayoung(){
        return "HayoungPage";
    }

    @PostMapping
    public ModelAndView postBlog(BlogDTO blogDTO, ModelAndView mv){

        if(blogDTO.getBlogTitle() == null || blogDTO.getBlogTitle().equals("")){
            mv.setViewName("redirect:/hayoung");
        }
        if(blogDTO.getBlogContent() == null || blogDTO.getBlogContent().equals("")){
            mv.setViewName("redirect:/hayoung");
        }

        int result = hayoungService.post(blogDTO);

        if(result <= 0){
            mv.setViewName("error/error");
        }else{
            mv.setViewName("HayoungPage");
        }

        return mv;
    }

}

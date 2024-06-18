package com.ogiraffers.practice0617;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PracticeController {

    @GetMapping("/mission")
    public ModelAndView mission(ModelAndView mv, @RequestParam("inputData") String value, String selectMenu, RedirectAttributes rttr) {
        mv.addObject("message", value);
        mv.setViewName("mission");

        if ("선택2".equals(selectMenu)) {
            rttr.addFlashAttribute("flashMessage", "얼럿입니당");
            mv.setViewName("redirect:/");
            return mv;
        }

        return mv;
    }


}
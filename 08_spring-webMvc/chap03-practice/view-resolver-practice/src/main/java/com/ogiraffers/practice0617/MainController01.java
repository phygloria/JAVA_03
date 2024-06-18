package com.ogiraffers.practice0617;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/*"})
public class MainController01 {

    public String main(){ return "index"; }

}

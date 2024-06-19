package com.ohgiraffers.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application01 {

    public static void main(String[] args){

        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
    }

}

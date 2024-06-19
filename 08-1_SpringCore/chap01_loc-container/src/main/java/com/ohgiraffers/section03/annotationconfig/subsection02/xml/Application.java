package com.ohgiraffers.section03.annotationconfig.subsection02.xml;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args){

        ApplicationContext context = new GenericXmlApplicationContext("section03/annotationconfig/subsection02/xml");

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames){
            System.out.println("beanName : " + beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        System.out.println(memberDAO.selectMember(1));
        System.out.println(memberDAO.selectMember(new MemberDAO(3)));
        System.out.println(memberDAO.selectMember(2));

    }
}

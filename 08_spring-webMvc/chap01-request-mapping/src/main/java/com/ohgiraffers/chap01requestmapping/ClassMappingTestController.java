package com.ohgiraffers.chap01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
* 클래스 레벨에 @RequestMapping 어노테이션 사용이 가능하다.
* 클래스레벨에 url을 공통 부분을 이용해 설정하고 나면 매번 핸들러 메소드에 url의 중복되는 내용은 작성하지 않아도 된다.
* 이 떄 와일드 카드를 이용해서 조금 더 포괄적인 url 패턴을 설정할 수 있다.
* */


//classMappingTestController
//controller: 사용자가 요청을 하면 그걸 처리해줌 이걸 스프링측에서 관리를 함?
// 하나의 객체 -> 우리는 그걸 빈이라고 부름, 빈의 이름을 명시함
// RestController는 http://localhost:8000/orders 이렇게 쓰면 hellow 뜸


// 리퀘스트 어노테이션은 네임을 생략할 수 있다
@Controller
@RequestMapping("/orders/*")
public class ClassMappingTestController {

    // class 레벨 매핑
    @GetMapping("/regist")
    public String registOrder(Model model){
        model.addAttribute("message", "get 방식의 주문 등록용 핸들러 메소드를 호출함");
        return "mappingResult";
    }

    @PostMapping("/regist")
    public String registOrderPost(Model model){
        model.addAttribute("message", "post 방식의 주문 등록용 핸들러 메소드를 호출함");
        return "mappingResult";
    }

    // 여러 개의 패턴 매핑
    // value 속성에 중괄호를 이용해 매핑할 url을 나열한다.
    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model){     //postman 이용 get를 post 바꿈
        model.addAttribute("message", "post 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출함");
        return "mappingResult";
    }


    // orders/1 : get   pathVariable방식
    // orders?name=아메리카노 : get    쿼리스트링파라미터?방식
    /*
    * path varisble
    * @PathVariable 어노테이션을 이용해 요청 path로부터 변수를 받아올 수 있다.
    * path variable로 전달되는 { 변수명 } 값은 반드시 매개변수명과 동일해야한다.
    * 만약 동일하지 않으면 @PathVariable("이름")을 설정해주어야한다.
    * 이는 Rest형 웹 서비스를 설계할 때 유용하게 사용된다.
     */
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model,@PathVariable("orderNo") int orderNo ){
            model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러");
        return "mappingResult";
    }


    @GetMapping("/")
    public String registOrders(Model model,@RequestParam String test, @RequestParam String value){
        //orders?test=hi~~&value=test
        model.addAttribute("message", test + " : " + value);
        return "mappingResult";
    }

    /*
    * 그 외의 다른 요청
    * @RequestMapping 어노테이션에 마무런 url을 설정하지 않으면 요청 처리에 대한 핸들러 메소드가
    * 준비되지 않았을 때 해당 메소드를 호출한다.
    * */

    @RequestMapping
    public String OtherRequest(Model model){
        model.addAttribute("message", "order 요청이긴 하지만 다른 기능 준비 안함");
        return "mappingResult";
    }

}

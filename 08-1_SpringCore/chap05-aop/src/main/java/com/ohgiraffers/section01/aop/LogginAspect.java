package com.ohgiraffers.section01.aop;

/*
* AOP(Aspect-oriented programming, 관점지향프로그래밍)
* 프로그램의 관심사를 분리하여 모듈화하는 것을 목표로 한다.
* aop는 특히 애플리케이션의 핵심 비즈니스 로직과는 별도로 부가적인 기능(예: 로깅, 보안, 트랜젝션 관리 등)
* 모듈성을 높이고 유지보수성을 향상시키는데 유용하다.
*
* */

/*
* pointcut : 특정 조건에 의해 필터링된 조인포인트, 수많은 조인포인트 중에 특정 메소드만 횡단 공통기능을 수행하기 위해서 사용한다.
* advice : 횡단 관심에 해당하는 공통 기능의 ㅣ코드, 독립된 클래스의 메소드로 작성한다.
*  - before : 메소드 실행 전에 동작
*  - After : 메소드 실행 후에 동작
*  - After -returning : 메소드가정상적으로 실행된 후에 동작
*  - After-throwing : 예외가 발생한 후에 동작
*  - Around : 메소드 호출 이전, 이후, 예외발생 등 모든 시점에 동작
* */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
/*
* pointcut :  관심 조인 포인트를 결정하여 어드바이스가 실행되는 시기를 제어한다.
* execution :  메서드 실행 조인 포이트를 매칭한다.
* execution ([수식어] 리턴타입 [클래스이름].이름(파라미터))
* 수식어는 생략이 가능하다 public price protected default (접근제어자)
* *Service.*(..) : 매개변수가 0개 이상인 모든 메서드
* *Service.*(*) : 매개변수가 1개인 모든 메서드
* *Service.*(*,..) : 매개변수가 2개인 모든 메서드
* */
public class LogginAspect {

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut(){

    }

    @Before("LogginAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("before joinPoint.getTarget() " + joinPoint.getTarget());
        System.out.println("before joinPoint.getSignature() " + joinPoint.getSignature());
        if(joinPoint.getArgs().length>0){
            System.out.println("before joinPoint.getAgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    @After("LogginAspect.logPointcut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("after joinPoint.getTarget() " + joinPoint.getTarget());
        System.out.println("after joinPoint.getSignature() " + joinPoint.getSignature());
        if(joinPoint.getArgs().length>0){
            System.out.println("after joinPoint.getAgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterRetruning(JoinPoint joinPoint, Object result){
        System.out.println("After Returning result " + result);
        if(result != null&& result instanceof Map){
            ((Map<Long,MemberDTO>)result).put(100L, new MemberDTO(100L, "반환값 가공"));
        }
    }


}

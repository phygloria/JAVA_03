package com.ohgiraffers.dispatcherservlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/")
public class HelloServlet extends HttpServlet {


    @Override //요청이 들어왔을 때 가장 먼저 실행됨
    public void init() throws ServletException {
        super.init();
    }


    @Override //
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest)  req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        String method = httpRequest.getMethod();
        // post delete get put patch optional
        // : http 요청을 날리는 방식

        if("GET".equals(method)){
            doGet(httpRequest, httpResponse);
        }else if("POST".equals(method)){
            doPost(httpRequest, httpResponse);
        } else if ("PUT".equals(method)){
            doPut(httpRequest, httpResponse);
        }else if("DELETE".equals(method)){
            doDelete(httpRequest, httpResponse);
        }

        // 다음체인 스코프에 전달해주는 애
//        super.service(req, res);
    }



    /* http 리퀘스트 요청이 들어왔을 때 아래애들중 누가 요청을 처리할지 호출할지 대기중 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    private void prossesRequest(HttpServletRequest request, HttpServletResponse response){
        String path = request.getRequestURI().substring(request.getContextPath().length());
    }


}
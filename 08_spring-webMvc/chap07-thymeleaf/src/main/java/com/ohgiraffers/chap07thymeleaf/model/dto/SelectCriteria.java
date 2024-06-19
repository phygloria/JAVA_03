package com.ohgiraffers.chap07thymeleaf.model.dto;

//SelectCriteria 뜻:  기준 선택
import lombok.*;

// 롬복은 자동으로 해주지만 에러가 많이난다. 사용 비추. 근데 알아볼것;
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor // 기본생성자를 만들겠다.

public class SelectCriteria {

    private int startPage;

    private int endPage;

    private int pageNo;

    public SelectCriteria(int startPage, int endPage, int pageNo) {
        this.startPage = startPage;
        this.endPage = endPage;
        this.pageNo = pageNo;

    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "SelectCriteria{" +
                "startPage=" + startPage +
                ", endPage=" + endPage +
                ", pageNo=" + pageNo +
                '}';
    }
}
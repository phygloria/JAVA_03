package com.ohgiraffers.thymeleaf_practi01.model.dto;

public class MemberDTO {

        private String title;
        private int year;
        private String maker;


        public MemberDTO() {
        }

        public MemberDTO(String title, int year, String maker) {
            this.title = title;
            this.year = year;
            this.maker = maker;

        }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", maker='" + maker + '\'' +
                '}';
    }
}

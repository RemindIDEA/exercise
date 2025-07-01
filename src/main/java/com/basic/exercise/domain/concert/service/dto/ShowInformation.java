package com.basic.exercise.domain.concert.service.dto;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ShowInformation {
    private int showId;
    private String title;
    private String showDate;
    private int runningTime;
    private String mainCharacter;
    private BigDecimal price;

    public void displayShowInfo() {
        System.out.println("공연번호   : " + showId);
        System.out.println("공연제목   : " + title);
        System.out.println("공연일시   : " + showDate);
        System.out.println("공연시간   : " + runningTime);
        System.out.println("메인배우   : " + mainCharacter);
        System.out.println("공연가격   : " + price);
        System.out.println();
    }
}

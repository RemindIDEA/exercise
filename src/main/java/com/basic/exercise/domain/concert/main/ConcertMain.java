package com.basic.exercise.domain.concert.main;

import com.basic.exercise.domain.concert.member.Member;
import com.basic.exercise.domain.concert.service.BookService;
import com.basic.exercise.domain.concert.service.MemberService;
import com.basic.exercise.domain.concert.service.ShowService;

import java.util.Scanner;
import java.util.Set;

public class ConcertMain {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService memberService = new MemberService();
        BookService bookService = new BookService();
        ShowService showService = new ShowService();

        // 예매자 입장
        memberService.join("memberA","1234");
        Member memberA = memberService.login("memberA", "1234");

        // 공연 목록 제공
        showService.showList();
        System.out.print("원하시는 공연을 골라주세요 : ");
        int choiceShowNumber = sc.nextInt();

        // 예매 요청
        bookService.bookingShow(choiceShowNumber, memberA);
        Set<Integer> showIds = bookService.getBookingInfo(memberA.getMemberId());
        showIds.forEach(showService::getShowInfo);

        System.out.println("취소하고 싶은 공연을 골라주세요");
        choiceShowNumber = sc.nextInt();
        bookService.cancelBooking(memberA.getMemberId(), choiceShowNumber);

        bookService.getBookingInfo(memberA.getMemberId())
                .forEach(showService::getShowInfo);;
    }
}

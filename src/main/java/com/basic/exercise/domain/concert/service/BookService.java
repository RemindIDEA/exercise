package com.basic.exercise.domain.concert.service;

import com.basic.exercise.domain.concert.member.Member;
import com.basic.exercise.domain.concert.repository.BookRepository;
import com.basic.exercise.domain.concert.repository.ShowRepository;
import com.basic.exercise.domain.concert.service.dto.ShowInformation;

public class BookService {

    private final PayService payService = new PayService();
    private final ShowRepository showRepository = new ShowRepository();
    private final BookRepository bookRepository = new BookRepository();

    public void bookingShow(int showId, Member member) {
        if(!hasSeat(showId)){
            System.out.println("만석입니다.");
            return;
        }
        // 결제하기 기능 필요.
        Long showPrice = showRepository.getShowPrice(showId);
        payService.pay(member, showPrice);
        bookRepository.booking(member.getMemberId(), showId);
        System.out.println("예약이 완료되었습니다.");
    }

    private boolean hasSeat(int showId) {
        return bookRepository.getLeftSeat(showId) >= 1;
    }

    public int getBookingInfo(int memberId){

    }

    public void cancelBooking(int memberId, int showId){

    }
}

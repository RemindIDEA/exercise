package com.basic.exercise.domain.concert.service;

import com.basic.exercise.domain.concert.member.Member;
import com.basic.exercise.domain.concert.repository.BookRepository;
import com.basic.exercise.domain.concert.repository.ShowRepository;

import java.util.Set;

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
        payService.pay(member.getMemberId(), showId, showPrice);
        bookRepository.booking(member.getMemberId(), showId);
        System.out.println("예약이 완료되었습니다.");
    }

    private boolean hasSeat(int showId) {
        return bookRepository.getLeftSeat(showId) >= 1;
    }

    public Set<Integer> getBookingInfo(int memberId){
        return bookRepository.getBookingInfo(memberId);
    }

    public void cancelBooking(int memberId, int showId){
        if(payService.isPayShow(memberId, showId)){
            payService.cancelPay(memberId, showId);
            bookRepository.cancel(memberId, showId);
            return;
        }
        System.out.println("예매 취소가 실패하였습니다.");
    }
}

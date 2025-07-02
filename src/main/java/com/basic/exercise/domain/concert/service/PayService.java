package com.basic.exercise.domain.concert.service;

import com.basic.exercise.domain.concert.member.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PayService {

    private final Map<Integer, Integer> payRepository = new HashMap<>();

    public void pay(int memberId, int showId, Long showPrice) {
        System.out.println("공연 가격은 " + showPrice + "원이고, 결제 계좌는 국민 123456123입니다.");
        System.out.println("계좌 결제가 성공했습니다.");
        payRepository.put(memberId, showId);
    }

    public boolean isPayShow(int memberId, int showId){
        return payRepository.get(memberId) == showId;
    }

    public void cancelPay(int memberId, int showId){
        if(payRepository.get(memberId) == showId){
            payRepository.remove(memberId);
            System.out.println("환불처리가 완료되었습니다.");
        }
    }
}

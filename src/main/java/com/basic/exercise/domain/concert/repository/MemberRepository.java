package com.basic.exercise.domain.concert.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemberRepository {
    private final AtomicInteger memberId = new AtomicInteger();
    private final Map<String, Integer> memberRepository = new HashMap<>();

    public void join(String id, String pw) {
        if (memberRepository.containsKey(id + pw)) {
            System.out.println("이미 가입되어 있는 회원입니다.");
            return;
        }
        memberRepository.put(id + pw, memberId.getAndIncrement());
        System.out.println(memberId);
    }

    public int login(String id, String pw) {
        return memberRepository.get(id+pw);
    }
}

package com.basic.exercise.domain.concert.service;

import com.basic.exercise.domain.concert.member.Member;
import com.basic.exercise.domain.concert.repository.MemberRepository;

public class MemberService {

    private final MemberRepository memberRepository = new MemberRepository();

    public Member login(String id, String pw) {
        int memberId = memberRepository.login(id, pw);
        return new Member(memberId);
    }

    public void join(String id, String pw) {
        if (id == null || pw == null || id.isBlank() || pw.isBlank()) {
            System.out.println("id와 pw를 확인하세요.");
            return;
        }
        memberRepository.join(id,pw);
        System.out.println("회원 가입이 완료되었습니다.");
    }
}
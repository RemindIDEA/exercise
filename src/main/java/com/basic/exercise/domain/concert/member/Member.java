package com.basic.exercise.domain.concert.member;

import com.basic.exercise.domain.concert.enums.MemberStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    private MemberStatus status;
    private int memberId;

    public Member(int memberId) {
        this.memberId = memberId;
        status = MemberStatus.LOGIN;
    }
}

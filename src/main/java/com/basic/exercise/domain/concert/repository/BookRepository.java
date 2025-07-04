package com.basic.exercise.domain.concert.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class BookRepository {

    private final Map<Integer, Set<Integer>> bookingMap = new HashMap<>();
    private final Map<Integer, Integer> leftSeatMap = new HashMap<>(
            Map.of(
                    1, 59,
                    2, 50,
                    3, 66,
                    4, 70,
                    5, 72)
    );

    public void booking(int memberId, int showId) {
        bookingMap.computeIfAbsent(memberId, showIds -> new HashSet<>()).add(showId);
        leftSeatMap.computeIfPresent(showId, (key, leftSeat) -> leftSeat > 0 ? leftSeat - 1 : 0);
    }

    public int getLeftSeat(int showId) {
        return leftSeatMap.get(showId);
    }

    public Set<Integer> getBookingInfo(int memberId) {
        return bookingMap.get(memberId);
    }

    public void cancel(int memberId, int showId) {
        Set<Integer> bookings = bookingMap.get(memberId);
        if (bookings != null) {
            bookings.remove(showId);
            leftSeatMap.computeIfPresent(showId, (key, leftSeat) -> leftSeat + 1);
            System.out.println("공연이 취소되었습니다.");
        }
    }
}

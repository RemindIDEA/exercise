package com.basic.exercise.domain.concert.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ShowRepository {
    Map<Integer, Long> showPriceInfoRepo = Map.of(
            1,155000L,
            2,165000L,
            3,160000L,
            4,155000L,
            5,165000L
    );

    public Long getShowPrice(int showId){
        return showPriceInfoRepo.get(showId);
    }
}

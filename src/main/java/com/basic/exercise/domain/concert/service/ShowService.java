package com.basic.exercise.domain.concert.service;

import com.basic.exercise.domain.concert.service.dto.ShowInformation;

import java.math.BigDecimal;
import java.util.List;

public class ShowService {

    private final List<ShowInformation> showInformationList = List.of(
            new ShowInformation(1, "노트르담 드 파리", "2025.07.24", 150, "홍광호", new BigDecimal(150000)),
            new ShowInformation(2, "레미제라블", "2025.08.01", 180, "조승우", new BigDecimal(160000)),
            new ShowInformation(3, "위키드", "2025.07.20", 160, "정선아", new BigDecimal(155000)),
            new ShowInformation(4, "지킬 앤 하이드", "2025.07.22", 170, "홍광호", new BigDecimal(165000)),
            new ShowInformation(5, "엘리자벳", "2025.07.28", 165, "김소현", new BigDecimal(158000))
    );

    public void showList() {
        showInformationList.forEach(ShowInformation::displayShowInfo);
    }
}

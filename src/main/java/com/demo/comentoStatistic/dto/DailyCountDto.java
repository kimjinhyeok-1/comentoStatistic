package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DailyCountDto {
    private String ymd;     // 2020040404? 아니고 20200404 같은 날짜
    private Integer totCnt;
}

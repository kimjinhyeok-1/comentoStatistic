package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptMonthCountDto {
    private String dept;
    private String yearMonth;
    private Integer totCnt;
}

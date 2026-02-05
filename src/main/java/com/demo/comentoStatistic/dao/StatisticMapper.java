package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);
    List<YearMonthCountDto> selectMonthlyUsers();
    List<DailyCountDto> selectDailyUsers();
    AvgDailyLoginDto selectAvgDailyLogins();
    List<DeptMonthCountDto> selectDeptMonthlyLogins();
    List<YearMonthCountDto> selectMonthlyUniqueUsersExcludeHoliday();
    List<DayCountDto> selectDailyUniqueUsersExcludeHoliday();

}
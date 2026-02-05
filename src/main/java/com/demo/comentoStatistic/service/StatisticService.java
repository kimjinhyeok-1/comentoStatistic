package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin(year+month);
    }

    public List<YearMonthCountDto> getMonthlyUsers() {
        return statisticMapper.selectMonthlyUsers();
    }

    public List<DailyCountDto> getDailyUsers(){
        return statisticMapper.selectDailyUsers();
    }

    public AvgDailyLoginDto getAvgDailyLogins() {
        return statisticMapper.selectAvgDailyLogins();
    }

    public List<DeptMonthCountDto> getDeptMonthlyLogins() {
        return statisticMapper.selectDeptMonthlyLogins();
    }

    public List<YearMonthCountDto> getMonthlyUniqueExcludeHoliday() {
        return statisticMapper.selectMonthlyUniqueUsersExcludeHoliday();
    }

    public List<DayCountDto> getDailyUniqueExcludeHoliday() {
        return statisticMapper.selectDailyUniqueUsersExcludeHoliday();
    }


}
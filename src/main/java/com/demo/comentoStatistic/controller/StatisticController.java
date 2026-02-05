package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.*;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value="/api/v1/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){

        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){

        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    @RequestMapping(value="/api/v1/logins/monthly", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<YearMonthCountDto>> getMonthlyUsers() {
        return ResponseEntity.ok(statisticService.getMonthlyUsers());
    }

    @RequestMapping(value="/api/v1/logins/daily", produces="application/json")
    @ResponseBody
    public ResponseEntity<List<DailyCountDto>> getDailyUsers(){
        return ResponseEntity.ok(statisticService.getDailyUsers());
    }

    @RequestMapping(value="/api/v1/logins/daily/avg", produces = "application/json")
    @ResponseBody
    public ResponseEntity<AvgDailyLoginDto> getAvgDailyLoginAvg(){
        return ResponseEntity.ok(statisticService.getAvgDailyLogins());
    }

    @RequestMapping(value="/api/v1/logins/dept/monthly", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<DeptMonthCountDto>> getDeptMonthlyLoginCount() {
        return ResponseEntity.ok(statisticService.getDeptMonthlyLogins());
    }
    @RequestMapping(value="/api/v1/logins/monthly/unique/exclude-holiday", produces="application/json")
    @ResponseBody
    public ResponseEntity<List<YearMonthCountDto>> monthlyUniqueExcludeHoliday() {
        return ResponseEntity.ok(statisticService.getMonthlyUniqueExcludeHoliday());
    }

    @RequestMapping(value="/api/v1/logins/daily/unique/exclude-holiday", produces="application/json")
    @ResponseBody
    public ResponseEntity<List<DayCountDto>> dailyUniqueExcludeHoliday() {
        return ResponseEntity.ok(statisticService.getDailyUniqueExcludeHoliday());
    }

}
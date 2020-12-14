package com.ss.basics.date;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.*;



public class Dates {
    public static void main(String[] args){
        //1. DateTime ex.
        LocalDate date =  LocalDate.parse("1996-09-09");
        //2.
        Calendar cal = Calendar.getInstance();
        while(cal.get( Calendar.DAY_OF_WEEK ) != Calendar.THURSDAY)
            cal.add( Calendar.DAY_OF_WEEK, -1 );
        System.out.println(cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DATE) + "/" + cal.get(Calendar.YEAR));
        //3.
        //ZoneId is id for different time zones
        //ZoneOffset is one of the 3 types of ids in ZoneId

        //4.
        //It looks Like GMT+12 or UTC+0:4:00
        Instant instant = Instant.now();
        ZonedDateTime zdt = instant.atZone(ZoneId.of("America/New_York"));
        System.out.println(zdt);

        Arrays.stream(getMonthLengths(2020)).forEach(month -> System.out.print(month + ", "));
        System.out.println();

        List<String> mondays =  getMondays(2020, 12);
        mondays.forEach(monday -> {
            System.out.println(monday);
        });

        System.out.println(isTodayTheFriday13th(2020, 11, 13));
    }

    //get lengths of months in a certain year
    public static int[] getMonthLengths(int year){
        int[] monthLengths = new int[12];
        if(year < 0)
            return monthLengths;
        for(int i=1; i <= 12; i++)
            monthLengths[i-1] = YearMonth.of(year, i).lengthOfMonth();
        return monthLengths;
    }

    //get all mondays this month
    public static List<String> getMondays(int year, int month){
        List<String> mondays = new ArrayList<>();
        Calendar current = Calendar.getInstance();
        current.set(year, month-1, 1);
        Calendar end =  Calendar.getInstance();;
        end.set(year, month, 1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        while (current.before(end)){
            while (current.get(Calendar.DAY_OF_WEEK) != 2){
                current.add(Calendar.DATE, 1);
            }

            mondays.add(format.format(current.getTime()));
            current.add(Calendar.DATE, 7);
        }
        return mondays;
    }

    //check if today is the friday 13th
    public static Boolean isTodayTheFriday13th(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, day);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        return calendar.get(Calendar.DAY_OF_WEEK) == 6 && calendar.get(Calendar.DATE) == 13;
    }
}

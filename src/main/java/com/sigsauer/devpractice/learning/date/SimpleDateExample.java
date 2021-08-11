package com.sigsauer.devpractice.learning.date;

import javax.swing.text.DateFormatter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SimpleDateExample {
    static Double x, y, z;
    static Short tt;

    public static void main(String[] args) {
        LocalDateTime current = LocalDateTime.now();
        System.out.println(current);
        System.out.println(current.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));

        //value = 7.01.2020 12:02:37
        LocalDateTime value = LocalDateTime.of(2020,1,7,12,2,37);
        System.out.println("value : " + value.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));

        LocalDate today = LocalDate.now();
        System.out.println("today: "+today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        //(period) days form value to today
        System.out.println("(period) days between value and today " + Period.between(LocalDate.from(value),today).getDays());

//        //(duration) days between value and today
//        System.out.println("(duration) days between value and today" + Duration.between(LocalDate.from(value),today));
//
//        //(chrono localdate) days from value
//        System.out.println("(chrono localdate) days from value" + ChronoLocalDate.from(LocalDate.from(value)).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        //(chrono unit) days from value and today
        System.out.println("(chrono unit) days between value and today " + ChronoUnit.DAYS.between(LocalDate.from(value),today));

        //(chrono unit) days from value and current
        System.out.println("(chrono unit) days between value and today " + ChronoUnit.DAYS.between(value,current));

        y = 1.2;
        z = 4d;
        tt = 5;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);



    }
}

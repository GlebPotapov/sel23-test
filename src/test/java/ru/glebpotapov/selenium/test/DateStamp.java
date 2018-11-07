package ru.glebpotapov.selenium.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateStamp {
    public static String now () {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd_hhmmss");
        String date = sdf.format(cal.getTime());
        return date;
    }
}
package br.edu.farol.gadoplus.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static Date StringToDate(String sDate){
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date)formatter.parse(sDate);
        } catch (ParseException e) {
            //trabalhar depois
        }
        return date;

    }

    public static String DateToString(Date date){
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);

    }
}

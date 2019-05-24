package com.example.matheushardman.avaliacoes_tablet.utils;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Utils {

    public static String pegarData(){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String data = sdf.format(tm);

        return data;

    }
}

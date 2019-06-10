package com.example.matheushardman.avaliacoes_tablet.utils;


import android.content.Context;
import android.widget.Toast;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Utils {

    public static final int TIPO_ACS = 1;
    public static final int TIPO_ACE = 2;

    public static final String ACE = "_ACE";
    public static final String ACS = "_ACS";
    public static String AGENTE = "";



    public static String pegarData(){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String data = sdf.format(tm);

        return data;

    }

    public static void showToast(Context context, String mensagem){

        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}

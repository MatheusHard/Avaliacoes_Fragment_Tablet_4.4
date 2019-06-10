package com.example.matheushardman.avaliacoes_tablet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.matheushardman.avaliacoes_tablet.classes.Avaliacao;
import com.example.matheushardman.avaliacoes_tablet.classes.Cidade;
import com.example.matheushardman.avaliacoes_tablet.classes.Uf;

import java.util.ArrayList;

public class Db_Avaliacao extends SQLiteOpenHelper {

    private static final String DATABASE = "adbAvaliacao";
    private static final int VERSION = 1;

    public Db_Avaliacao(Context context) {

        super(context, DATABASE,null, VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String usuarios = "CREATE TABLE IF NOT EXISTS usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR NOT NULL, senha VARCHAR(11) NOT NULL)";
        db.execSQL(usuarios);

        /************************TABELA AVALIACAO*****************************/

        String avaliacao = "CREATE TABLE IF NOT EXISTS avaliacao("+
        "id_av INTEGER PRIMARY KEY autoincrement, radioSim_1 INTEGER, radioNao_1 INTEGER, "+
        "radioMuito_2 INTEGER, radiobom_2 INTEGER, radioRegular_2 INTEGER, radioRuim_2 INTEGER, "+
        "radioSeguro_3 INTEGER, radioPoucoSeguro_3 INTEGER, radioInseguro_3 INTEGER, "+
        "radioExcessiva_4 INTEGER, radioRazoavel_4 INTEGER, RadioInsuficiente_4 INTEGER, "+
        "radioMuito_5 INTEGER, radiobom_5 INTEGER, radioRegular_5 INTEGER, radioRuim_5 INTEGER, "+
        "radioMuito_6 INTEGER, radiobom_6 INTEGER, radioRegular_6 INTEGER, radioRuim_6 INTEGER, "+
        "radioMuito_7 INTEGER, radiobom_7 INTEGER, radioRegular_7 INTEGER, radioRuim_7 INTEGER, "+
        "radioMuito_8 INTEGER, radiobom_8 INTEGER, radioRegular_8 INTEGER, radioRuim_8 INTEGER, "+
        "radioMuito_9 INTEGER, radiobom_9 INTEGER, radioRegular_9 INTEGER, radioRuim_9 INTEGER, "+
        "radioMuito_10 INTEGER, radiobom_10 INTEGER, radioRegular_10 INTEGER, radioRuim_10 INTEGER, "+
        "descricao VARCHAR (500), id_cidade INTEGER, data VARCHAR(20), nome_agente VARCHAR(50), " +
        "tipo_agente INTEGER)";

        db.execSQL(avaliacao);

        /*****************************UF***************************************/

        String uf = "CREATE TABLE IF NOT EXISTS uf(id_uf INTEGER PRIMARY KEY autoincrement, descricao VARCHAR(2))";
        db.execSQL(uf);



        String u1 = "INSERT INTO uf(descricao) VALUES ('AC')";
        String u2 = "INSERT INTO uf(descricao) VALUES ('AL')";
        String u3 = "INSERT INTO uf(descricao) VALUES ('AM')";
        String u4 = "INSERT INTO uf(descricao) VALUES ('AP')";
        String u5 = "INSERT INTO uf(descricao) VALUES ('BA')";
        String u6 = "INSERT INTO uf(descricao) VALUES ('CE')";
        String u7 = "INSERT INTO uf(descricao) VALUES ('DF')";
        String u8 = "INSERT INTO uf(descricao) VALUES ('ES')";
        String u9 = "INSERT INTO uf(descricao) VALUES ('GO')";
        String u10 = "INSERT INTO uf(descricao) VALUES ('MA')";
        String u11 = "INSERT INTO uf(descricao) VALUES ('MG')";
        String u12 = "INSERT INTO uf(descricao) VALUES ('MS')";
        String u13 = "INSERT INTO uf(descricao) VALUES ('MT')";
        String u14 = "INSERT INTO uf(descricao) VALUES ('PA')";
        String u15 = "INSERT INTO uf(descricao) VALUES ('PB')";
        String u16 = "INSERT INTO uf(descricao) VALUES ('PE')";
        String u17 = "INSERT INTO uf(descricao) VALUES ('PI')";
        String u18 = "INSERT INTO uf(descricao) VALUES ('PR')";
        String u19 = "INSERT INTO uf(descricao) VALUES ('RJ')";
        String u20 = "INSERT INTO uf(descricao) VALUES ('RN')";
        String u21 = "INSERT INTO uf(descricao) VALUES ('RO')";
        String u22 = "INSERT INTO uf(descricao) VALUES ('RR')";
        String u23 = "INSERT INTO uf(descricao) VALUES ('RS')";
        String u24 = "INSERT INTO uf(descricao) VALUES ('SC')";
        String u25 = "INSERT INTO uf(descricao) VALUES ('SE')";
        String u26 = "INSERT INTO uf(descricao) VALUES ('SP')";
        String u27 = "INSERT INTO uf(descricao) VALUES ('TO')";


        db.execSQL(u1);
        db.execSQL(u2);
        db.execSQL(u3);
        db.execSQL(u4);
        db.execSQL(u5);
        db.execSQL(u6);
        db.execSQL(u7);
        db.execSQL(u8);
        db.execSQL(u9);
        db.execSQL(u10);
        db.execSQL(u11);
        db.execSQL(u12);
        db.execSQL(u13);
        db.execSQL(u14);
        db.execSQL(u15);
        db.execSQL(u16);
        db.execSQL(u17);
        db.execSQL(u18);
        db.execSQL(u19);
        db.execSQL(u20);
        db.execSQL(u21);
        db.execSQL(u22);
        db.execSQL(u23);
        db.execSQL(u24);
        db.execSQL(u25);
        db.execSQL(u26);
        db.execSQL(u27);



        /******************************CIDADES*********************************/

        String city = "CREATE TABLE IF NOT EXISTS cidades(id_cidade INTEGER PRIMARY KEY autoincrement, descricao VARCHAR(100), cod_uf INTEGER)";
        db.execSQL(city);


        String ci1 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('AGUA PRETA', 16)";
        String ci2 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('ALHANDRA', 15)";
        String ci3 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('ARAPONGA', 11)";
        String ci4 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('ARES', 20)";
        String ci5 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('BERNARDINO BATISTA', 15)";
        String ci6 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('BRUMADO', 5)";
        String ci7 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('CAJURI', 11)";
        String ci8 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('CANAÃ', 11)";
        String ci9 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('CONDADO', 16)";
        String ci10 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('ESPERA FELIZ', 11)";
        String ci11 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('EUNAPOLIS', 5)";
        String ci12 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('FREI MARTINHO', 15)";
        String ci13 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('GOIANINHA', 20)";
        String ci14 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('GUAMARÉ', 20)";
        String ci15 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('GUARACIABA', 11)";
        String ci16 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('GURINHÉM', 15)";
        String ci17 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('ITAPOROROCA', 15)";
        String ci18 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('ITATUBA', 15)";
        String ci19 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('JABOATÃO DOS GUARARAPES', 16)";
        String ci20 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('JOCA CLAUDINO(SANTAREM)', 15)";
        String ci21 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('MACAU', 20)";
        String ci22 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('MOSSORÓ', 20)";
        String ci23 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('PAULA CANDIDO', 11)";
        String ci24 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('PAULISTA', 16)";
        String ci25 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('PEDRA LAVRADA', 15)";
        String ci26 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('PIRAÍ', 19)";
        String ci27 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('PORTO DO MANGUE', 20)";
        String ci28 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('REMIGIO', 15)";
        String ci29 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('SANTA LUZIA', 15)";
        String ci30 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('SÃO JOSÉ DE UBA', 19)";
        String ci31 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('SÃO JOSÉ DO MIPIBU', 20)";
        String ci32 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('SERRA DO MEL', 20)";
        String ci33 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('SERTÂNIA', 16)";
        String ci34 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('TAIPU', 20)";
        String ci35 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('TAPEROÁ', 15)";
        String ci36 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('TIBAU', 20)";
        String ci37 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('TIBAU DO SUL', 20)";
        String ci38 = "INSERT INTO cidades(descricao, cod_uf) VALUES ('TIBAU DO SUL(EDEIMAS)', 20)";

        db.execSQL(ci1);
        db.execSQL(ci2);
        db.execSQL(ci3);
        db.execSQL(ci4);
        db.execSQL(ci5);
        db.execSQL(ci6);
        db.execSQL(ci7);
        db.execSQL(ci8);
        db.execSQL(ci9);
        db.execSQL(ci10);
        db.execSQL(ci11);
        db.execSQL(ci12);
        db.execSQL(ci13);
        db.execSQL(ci14);
        db.execSQL(ci15);
        db.execSQL(ci16);
        db.execSQL(ci17);
        db.execSQL(ci18);
        db.execSQL(ci19);
        db.execSQL(ci20);
        db.execSQL(ci21);
        db.execSQL(ci22);
        db.execSQL(ci23);
        db.execSQL(ci24);
        db.execSQL(ci25);
        db.execSQL(ci26);
        db.execSQL(ci27);
        db.execSQL(ci28);
        db.execSQL(ci29);
        db.execSQL(ci30);
        db.execSQL(ci31);
        db.execSQL(ci32);
        db.execSQL(ci33);
        db.execSQL(ci34);
        db.execSQL(ci35);
        db.execSQL(ci36);
        db.execSQL(ci37);
        db.execSQL(ci38);



        /*********USUARIO**********/

        String usuarioPadrao = "INSERT INTO USUARIOS(nome, senha) VALUES ('admin', '123')";

        db.execSQL(usuarioPadrao);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String usuarios = "DROP TABLE IF EXISTS usuarios";
        db.execSQL(usuarios);

        String avaliacao = "DROP TABLE IF EXISTS avaliacao";
        db.execSQL(avaliacao);

        String cidades = "DROP TABLE IF EXISTS cidades";
        db.execSQL(cidades);

        String uf = "DROP TABLE IF EXISTS uf";
        db.execSQL(uf);
    }


    public void inserirAvaliacao(Avaliacao a){

        try {

            ContentValues values = new ContentValues();

            values.put("radioSim_1", a.getRadioSim_1());
            values.put("radioNao_1", a.getRadioNao_1());

            values.put("radioMuito_2", a.getRadioMuito_2());
            values.put("radiobom_2", a.getRadiobom_2());
            values.put("radioRegular_2",a.getRadioRegular_2());
            values.put("radioRuim_2",a.getRadioRuim_2());

            values.put("radioSeguro_3",a.getRadioSeguro_3());
            values.put("radioPoucoSeguro_3",a.getRadioPoucoSeguro_3());
            values.put("radioInseguro_3",a.getRadioInseguro_3());

            values.put("radioExcessiva_4",a.getRadioExcessiva_4());
            values.put("radioRazoavel_4",a.getRadioRazoavel_4());
            values.put("RadioInsuficiente_4",a.getRadioInsuficiente_4());

            values.put("radioMuito_5", a.getRadioMuito_5());
            values.put("radiobom_5", a.getRadiobom_5());
            values.put("radioRegular_5",a.getRadioRegular_5());
            values.put("radioRuim_5",a.getRadioRuim_5());

            values.put("radioMuito_6", a.getRadioMuito_6());
            values.put("radiobom_6", a.getRadiobom_6());
            values.put("radioRegular_6",a.getRadioRegular_6());
            values.put("radioRuim_6",a.getRadioRuim_6());

            values.put("radioMuito_7", a.getRadioMuito_7());
            values.put("radiobom_7", a.getRadiobom_7());
            values.put("radioRegular_7",a.getRadioRegular_7());
            values.put("radioRuim_7",a.getRadioRuim_7());

            values.put("radioMuito_8", a.getRadioMuito_8());
            values.put("radiobom_8", a.getRadiobom_8());
            values.put("radioRegular_8",a.getRadioRegular_8());
            values.put("radioRuim_8",a.getRadioRuim_8());

            values.put("radioMuito_9", a.getRadioMuito_9());
            values.put("radiobom_9", a.getRadiobom_9());
            values.put("radioRegular_9", a.getRadioRegular_9());
            values.put("radioRuim_9", a.getRadioRuim_9());

            values.put("radioMuito_10", a.getRadioMuito_10());
            values.put("radiobom_10", a.getRadiobom_10());
            values.put("radioRegular_10",a.getRadioRegular_10());
            values.put("radioRuim_10", a.getRadioRuim_10());

            values.put("descricao", a.getSugestoes());

            values.put("id_cidade", a.getIdCidade());

            values.put("data", a.getData());

           /***Novos dados***/

            values.put("nome_agente", a.getNomeAgente());
            values.put("tipo_agente", a.getTipoAgente());

            getWritableDatabase().insert("avaliacao", null, values);

        }catch (Exception e){
            //Log.i("ERROS",e.getMessage());
            e.printStackTrace();

        }

    }

public void updateAvaliacao(Avaliacao a){

     try {

        ContentValues values = new ContentValues();

        values.put("radioSim_1", a.getRadioSim_1());
        values.put("radioNao_1", a.getRadioNao_1());

        values.put("radioMuito_2", a.getRadioMuito_2());
        values.put("radiobom_2", a.getRadiobom_2());
        values.put("radioRegular_2",a.getRadioRegular_2());
        values.put("radioRuim_2",a.getRadioRuim_2());

        values.put("radioSeguro_3",a.getRadioSeguro_3());
        values.put("radioPoucoSeguro_3",a.getRadioPoucoSeguro_3());
        values.put("radioInseguro_3",a.getRadioInseguro_3());

        values.put("radioExcessiva_4",a.getRadioExcessiva_4());
        values.put("radioRazoavel_4",a.getRadioRazoavel_4());
        values.put("RadioInsuficiente_4",a.getRadioInsuficiente_4());

        values.put("radioMuito_5", a.getRadioMuito_5());
        values.put("radiobom_5", a.getRadiobom_5());
        values.put("radioRegular_5",a.getRadioRegular_5());
        values.put("radioRuim_5",a.getRadioRuim_5());

        values.put("radioMuito_6", a.getRadioMuito_6());
        values.put("radiobom_6", a.getRadiobom_6());
        values.put("radioRegular_6",a.getRadioRegular_6());
        values.put("radioRuim_6",a.getRadioRuim_6());

        values.put("radioMuito_7", a.getRadioMuito_7());
        values.put("radiobom_7", a.getRadiobom_7());
        values.put("radioRegular_7",a.getRadioRegular_7());
        values.put("radioRuim_7",a.getRadioRuim_7());

        values.put("radioMuito_8", a.getRadioMuito_8());
        values.put("radiobom_8", a.getRadiobom_8());
        values.put("radioRegular_8",a.getRadioRegular_8());
        values.put("radioRuim_8",a.getRadioRuim_8());

        values.put("radioMuito_9", a.getRadioMuito_9());
        values.put("radiobom_9", a.getRadiobom_9());
        values.put("radioRegular_9",a.getRadioRegular_9());
        values.put("radioRuim_9",a.getRadioRuim_9());

        values.put("radioMuito_10", a.getRadioMuito_10());
        values.put("radiobom_10", a.getRadiobom_10());
        values.put("radioRegular_10",a.getRadioRegular_10());
        values.put("radioRuim_10",a.getRadioRuim_10());

        values.put("descricao",a.getSugestoes());


         /***Novos dados***/

         values.put("nome_agente", a.getNomeAgente());
         values.put("tipo_agente", a.getTipoAgente());

         values.put("id_av", a.getIdAv());


         String[] args = {a.getIdAv().toString()};

         getWritableDatabase().update("avaliacao",  values, "id_av = ?", args);
    }catch (Exception e){
        //Log.i("ERROS",e.getMessage());
        e.printStackTrace();

    }

}

    public ArrayList<Avaliacao> getAvaliacoes(){

        String colums[] =

                /*7*/{"id_av", "radioSim_1", "radioNao_1", "radioMuito_2","radiobom_2","radioRegular_2","radioRuim_2",
                /*6*/"radioSeguro_3","radioPoucoSeguro_3","radioInseguro_3","radioExcessiva_4","radioRazoavel_4","RadioInsuficiente_4",
                /*8*/"radioMuito_5","radiobom_5","radioRegular_5","radioRuim_5","radioMuito_6","radiobom_6","radioRegular_6", "radioRuim_6",
                /*8*/"radioMuito_7","radiobom_7","radioRegular_7","radioRuim_7","radioMuito_8","radiobom_8","radioRegular_8","radioRuim_8",
                /*9*/"radioMuito_9","radiobom_9","radioRegular_9","radioRuim_9","radioMuito_10","radiobom_10","radioRegular_10","radioRuim_10","descricao","id_cidade"};


        Cursor cursor = getWritableDatabase().query("avaliacao", colums, null, null, null,null, null, null);
        ArrayList<Avaliacao> arrayListAvaliacoes = new ArrayList<Avaliacao>();

        cursor.moveToFirst();

        while (cursor.moveToNext()){



            Avaliacao a = new Avaliacao();

            //1
            a.setIdAv (cursor.getInt(0));
            a.setRadioSim_1(Integer.parseInt(cursor.getString(1)));
            a.setRadioNao_1(Integer.parseInt(cursor.getString(2)));
            //2
            a.setRadioMuito_2(Integer.parseInt(cursor.getString(3)));
            a.setRadiobom_2(Integer.parseInt(cursor.getString(4)));
            a.setRadioRegular_2(Integer.parseInt(cursor.getString(5)));
            a.setRadioRuim_2(Integer.parseInt(cursor.getString(6)));
            //3
            a.setRadioSeguro_3(Integer.parseInt(cursor.getString(7)));
            a.setRadioPoucoSeguro_3(Integer.parseInt(cursor.getString(8)));
            a.setRadioInseguro_3(Integer.parseInt(cursor.getString(9)));
            //4
            a.setRadioExcessiva_4(Integer.parseInt(cursor.getString(10)));
            a.setRadioRazoavel_4(Integer.parseInt(cursor.getString(11)));
            a.setRadioInsuficiente_4(Integer.parseInt(cursor.getString(12)));
            //5
            a.setRadioMuito_5(Integer.parseInt(cursor.getString(13)));
            a.setRadiobom_5(Integer.parseInt(cursor.getString(14)));
            a.setRadioRegular_5(Integer.parseInt(cursor.getString(15)));
            a.setRadioRuim_5(Integer.parseInt(cursor.getString(16)));
            //6
            a.setRadioMuito_6(Integer.parseInt(cursor.getString(17)));
            a.setRadiobom_6(Integer.parseInt(cursor.getString(18)));
            a.setRadioRegular_6(Integer.parseInt(cursor.getString(19)));
            a.setRadioRuim_6(Integer.parseInt(cursor.getString(20)));
            //7
            a.setRadioMuito_7(Integer.parseInt(cursor.getString(21)));
            a.setRadiobom_7(Integer.parseInt(cursor.getString(22)));
            a.setRadioRegular_7(Integer.parseInt(cursor.getString(23)));
            a.setRadioRuim_7(Integer.parseInt(cursor.getString(24)));
            //8
            a.setRadioMuito_8(Integer.parseInt(cursor.getString(25)));
            a.setRadiobom_8(Integer.parseInt(cursor.getString(26)));
            a.setRadioRegular_8(Integer.parseInt(cursor.getString(27)));
            a.setRadioRuim_8(Integer.parseInt(cursor.getString(28)));
            //9
            a.setRadioMuito_9(Integer.parseInt(cursor.getString(29)));
            a.setRadiobom_9(Integer.parseInt(cursor.getString(30)));
            a.setRadioRegular_9(Integer.parseInt(cursor.getString(31)));
            a.setRadioRuim_9(Integer.parseInt(cursor.getString(32)));
            //10
            a.setRadioMuito_10(Integer.parseInt(cursor.getString(33)));
            a.setRadiobom_10(Integer.parseInt(cursor.getString(34)));
            a.setRadioRegular_10(Integer.parseInt(cursor.getString(35)));
            a.setRadioRuim_10(Integer.parseInt(cursor.getString(36)));
            //11
            a.setSugestoes(cursor.getString(37));

            a.setIdCidade(Integer.parseInt(cursor.getString(38)));


            arrayListAvaliacoes.add(a);
        }

        return arrayListAvaliacoes;
    }

 public void deletarAvaliacao(Avaliacao a){

        String[] args = {a.getIdAv().toString()};
        getWritableDatabase().delete("avaliacao",  "id_av = ?", args);

    }

    /**********Metodo para buscar Avaliações por Cidade************/

    public ArrayList<Avaliacao> getAvaliacoesCidade(int cod_cidade, int type_agente){

        Avaliacao a = null;
        String cod = String.valueOf(cod_cidade);
        String tipo_agente = String.valueOf(type_agente);

        ArrayList<Avaliacao> arrayListAv = new ArrayList<Avaliacao>();

        SQLiteDatabase database = this.getWritableDatabase();

        String query = "SELECT id_av, radioSim_1, radioNao_1, radioMuito_2, radiobom_2, radioRegular_2, radioRuim_2, radioSeguro_3, " +
                "radioPoucoSeguro_3, radioInseguro_3, radioExcessiva_4, radioRazoavel_4, RadioInsuficiente_4, radioMuito_5, radiobom_5," +
                "radioRegular_5, radioRuim_5 , radioMuito_6, radiobom_6, radioRegular_6,  radioRuim_6, radioMuito_7, radiobom_7, radioRegular_7," +
                "radioRuim_7, radioMuito_8, radiobom_8, radioRegular_8, radioRuim_8, radioMuito_9, radiobom_9, radioRegular_9, radioRuim_9," +
                "radioMuito_10, radiobom_10 , radioRegular_10, radioRuim_10, descricao, id_cidade, data, nome_agente, tipo_agente FROM avaliacao " +
                "WHERE id_cidade ="+cod+" AND tipo_agente="+tipo_agente;

        Cursor cursor = database.rawQuery(query,null);

            //cursor.moveToFirst();

        while (cursor.moveToNext()) {

            a = new Avaliacao();
            //1
            a.setIdAv (cursor.getInt(0));
            a.setRadioSim_1(Integer.parseInt(cursor.getString(1)));
            a.setRadioNao_1(Integer.parseInt(cursor.getString(2)));
            //2
            a.setRadioMuito_2(Integer.parseInt(cursor.getString(3)));
            a.setRadiobom_2(Integer.parseInt(cursor.getString(4)));
            a.setRadioRegular_2(Integer.parseInt(cursor.getString(5)));
            a.setRadioRuim_2(Integer.parseInt(cursor.getString(6)));
            //3
            a.setRadioSeguro_3(Integer.parseInt(cursor.getString(7)));
            a.setRadioPoucoSeguro_3(Integer.parseInt(cursor.getString(8)));
            a.setRadioInseguro_3(Integer.parseInt(cursor.getString(9)));
            //4
            a.setRadioExcessiva_4(Integer.parseInt(cursor.getString(10)));
            a.setRadioRazoavel_4(Integer.parseInt(cursor.getString(11)));
            a.setRadioInsuficiente_4(Integer.parseInt(cursor.getString(12)));
            //5
            a.setRadioMuito_5(Integer.parseInt(cursor.getString(13)));
            a.setRadiobom_5(Integer.parseInt(cursor.getString(14)));
            a.setRadioRegular_5(Integer.parseInt(cursor.getString(15)));
            a.setRadioRuim_5(Integer.parseInt(cursor.getString(16)));
            //6
            a.setRadioMuito_6(Integer.parseInt(cursor.getString(17)));
            a.setRadiobom_6(Integer.parseInt(cursor.getString(18)));
            a.setRadioRegular_6(Integer.parseInt(cursor.getString(19)));
            a.setRadioRuim_6(Integer.parseInt(cursor.getString(20)));
            //7
            a.setRadioMuito_7(Integer.parseInt(cursor.getString(21)));
            a.setRadiobom_7(Integer.parseInt(cursor.getString(22)));
            a.setRadioRegular_7(Integer.parseInt(cursor.getString(23)));
            a.setRadioRuim_7(Integer.parseInt(cursor.getString(24)));
            //8
            a.setRadioMuito_8(Integer.parseInt(cursor.getString(25)));
            a.setRadiobom_8(Integer.parseInt(cursor.getString(26)));
            a.setRadioRegular_8(Integer.parseInt(cursor.getString(27)));
            a.setRadioRuim_8(Integer.parseInt(cursor.getString(28)));
            //9
            a.setRadioMuito_9(Integer.parseInt(cursor.getString(29)));
            a.setRadiobom_9(Integer.parseInt(cursor.getString(30)));
            a.setRadioRegular_9(Integer.parseInt(cursor.getString(31)));
            a.setRadioRuim_9(Integer.parseInt(cursor.getString(32)));
            //10
            a.setRadioMuito_10(Integer.parseInt(cursor.getString(33)));
            a.setRadiobom_10(Integer.parseInt(cursor.getString(34)));
            a.setRadioRegular_10(Integer.parseInt(cursor.getString(35)));
            a.setRadioRuim_10(Integer.parseInt(cursor.getString(36)));
            //11
            a.setSugestoes(cursor.getString(37));

            a.setIdCidade(Integer.parseInt(cursor.getString(38)));

            a.setData(cursor.getString(39));

            a.setNomeAgente(cursor.getString(40));

            a.setTipoAgente(Integer.parseInt(cursor.getString(41)));

            arrayListAv.add(a);


        }
        return arrayListAv;
    }

    /**********Metodo para Buscar a soma das Avaliações por Cidade*************/

    public Avaliacao getSomaAvaliacoesCidade(int cod_cidade)
    {

            String cod = String.valueOf(cod_cidade);

            Avaliacao a = null;

            SQLiteDatabase database = this.getWritableDatabase();

            String query = "SELECT sum(radioSim_1), sum(radioNao_1), sum(radioMuito_2), sum(radiobom_2), sum(radioRegular_2), sum(radioRuim_2), sum(radioSeguro_3), " +
                    "sum(radioPoucoSeguro_3), sum(radioInseguro_3), sum(radioExcessiva_4), sum(radioRazoavel_4), sum(RadioInsuficiente_4), sum(radioMuito_5), sum(radiobom_5)," +
                    "sum(radioRegular_5), sum(radioRuim_5 ), sum(radioMuito_6), sum(radiobom_6), sum(radioRegular_6),  sum(radioRuim_6), sum(radioMuito_7), sum(radiobom_7), sum(radioRegular_7)," +
                    "sum(radioRuim_7), sum(radioMuito_8), sum(radiobom_8), sum(radioRegular_8), sum(radioRuim_8), sum(radioMuito_9), sum(radiobom_9), sum(radioRegular_9), sum(radioRuim_9)," +
                    "sum(radioMuito_10), sum(radiobom_10), sum(radioRegular_10), sum(radioRuim_10), id_cidade FROM avaliacao WHERE id_cidade =" + cod;

            Cursor cursor = database.rawQuery(query, null);

            //cursor.moveToFirst();

            if (cursor != null) {

                while (cursor.moveToNext()) {

                    a = new Avaliacao();
                    //1
                    a.setRadioSim_1(Integer.parseInt(cursor.getString(0)));
                    a.setRadioNao_1(Integer.parseInt(cursor.getString(1)));
                    //2
                    a.setRadioMuito_2(Integer.parseInt(cursor.getString(2)));
                    a.setRadiobom_2(Integer.parseInt(cursor.getString(3)));
                    a.setRadioRegular_2(Integer.parseInt(cursor.getString(4)));
                    a.setRadioRuim_2(Integer.parseInt(cursor.getString(5)));
                    //3
                    a.setRadioSeguro_3(Integer.parseInt(cursor.getString(6)));
                    a.setRadioPoucoSeguro_3(Integer.parseInt(cursor.getString(7)));
                    a.setRadioInseguro_3(Integer.parseInt(cursor.getString(8)));
                    //4
                    a.setRadioExcessiva_4(Integer.parseInt(cursor.getString(9)));
                    a.setRadioRazoavel_4(Integer.parseInt(cursor.getString(10)));
                    a.setRadioInsuficiente_4(Integer.parseInt(cursor.getString(11)));
                    //5
                    a.setRadioMuito_5(Integer.parseInt(cursor.getString(12)));
                    a.setRadiobom_5(Integer.parseInt(cursor.getString(13)));
                    a.setRadioRegular_5(Integer.parseInt(cursor.getString(14)));
                    a.setRadioRuim_5(Integer.parseInt(cursor.getString(15)));
                    //6
                    a.setRadioMuito_6(Integer.parseInt(cursor.getString(16)));
                    a.setRadiobom_6(Integer.parseInt(cursor.getString(17)));
                    a.setRadioRegular_6(Integer.parseInt(cursor.getString(18)));
                    a.setRadioRuim_6(Integer.parseInt(cursor.getString(19)));
                    //7
                    a.setRadioMuito_7(Integer.parseInt(cursor.getString(20)));
                    a.setRadiobom_7(Integer.parseInt(cursor.getString(21)));
                    a.setRadioRegular_7(Integer.parseInt(cursor.getString(22)));
                    a.setRadioRuim_7(Integer.parseInt(cursor.getString(23)));
                    //8
                    a.setRadioMuito_8(Integer.parseInt(cursor.getString(24)));
                    a.setRadiobom_8(Integer.parseInt(cursor.getString(25)));
                    a.setRadioRegular_8(Integer.parseInt(cursor.getString(26)));
                    a.setRadioRuim_8(Integer.parseInt(cursor.getString(27)));
                    //9
                    a.setRadioMuito_9(Integer.parseInt(cursor.getString(28)));
                    a.setRadiobom_9(Integer.parseInt(cursor.getString(29)));
                    a.setRadioRegular_9(Integer.parseInt(cursor.getString(30)));
                    a.setRadioRuim_9(Integer.parseInt(cursor.getString(31)));
                    //10
                    a.setRadioMuito_10(Integer.parseInt(cursor.getString(32)));
                    a.setRadiobom_10(Integer.parseInt(cursor.getString(33)));
                    a.setRadioRegular_10(Integer.parseInt(cursor.getString(34)));
                    a.setRadioRuim_10(Integer.parseInt(cursor.getString(35)));
                    //11

                    a.setIdCidade(Integer.parseInt(cursor.getString(36)));

                }
            }

        return a;
    }

    public void inserirCidade(Uf u){
        try {

            ContentValues values = new ContentValues();
            values.put("descricao", u.getCidade().getDescricao());
            values.put("cod_uf", u.getCidade().getCod_uf());

            getWritableDatabase().insert("cidades", null, values);

        }catch (Exception e){

            e.printStackTrace();

        }
    }

    public ArrayList<String> getCidades(){

        SQLiteDatabase database = this.getWritableDatabase();

        String c = new String();
        String query = "SELECT descricao FROM cidade";

        Cursor cursor = database.rawQuery(query,null);

        ArrayList<String> arrayListCidades= new ArrayList<>();

        while (cursor.moveToNext()){

            c =  cursor.getString(0);
            arrayListCidades.add(c);
        }

        return arrayListCidades;
    }

    /* public static boolean insertNormal(String nome_tabela, ContentValues ctv) {
        SQLiteDatabase myDataBase = SQLiteDatabase.openDatabase(myPa, null, SQLiteDatabase.OPEN_READWRITE);
        if ((myDataBase.insert(nome_tabela, null, ctv) > 0)) {
            myDataBase.close();
            return true;
        } else {
            myDataBase.close();
            return false;
        }


    }*/


    public ArrayList<Uf> getUfs(){

        String colums[] = {"id_uf", "descricao"};

        Cursor cursor = getWritableDatabase().query("uf", colums, null, null, null,null, null, null);
        ArrayList<Uf> arrayListUfs = new ArrayList<>();

        while (cursor.moveToNext()){

            Uf u = new Uf();
            u.setId_uf(cursor.getInt(0));
            u.setDescricao(cursor.getString(1));
            arrayListUfs.add(u);
        }

        return arrayListUfs;
    }

    public ArrayList<Cidade> getCitys(){

        String colums[] = {"id_cidade", "descricao", "cod_uf"};

        Cursor cursor = getWritableDatabase().query("cidades", colums, null, null, null,null, null, null);
        ArrayList<Cidade> arrayListCidades = new ArrayList<>();

        while (cursor.moveToNext()){

            Cidade c = new Cidade();
            c.setId_cidade(cursor.getInt(0));
            c.setDescricao(cursor.getString(1));
            c.setCod_uf(cursor.getInt(2));
            arrayListCidades.add(c);
        }

        return arrayListCidades;
    }


    public ArrayList<Uf> getCidadesUf(){

        SQLiteDatabase database = this.getWritableDatabase();

        String query = "SELECT uf.id_uf, uf.descricao, cidades.id_cidade, cidades.descricao FROM uf INNER JOIN cidades WHERE uf.id_uf = cidades.cod_uf ORDER BY cidades.descricao";


        Cursor cursor = database.rawQuery(query,null);

        ArrayList<Uf> arrayListCidadesUfs = new ArrayList<>();

        while (cursor.moveToNext()){

            Cidade c = new Cidade();
            Uf uf = new Uf();

            uf.setId_uf(cursor.getInt(0));
            uf.setDescricao(cursor.getString(1));
            c.setId_cidade(cursor.getInt(2));
            c.setDescricao(cursor.getString(3));
            uf.setCidade(c);

            arrayListCidadesUfs.add(uf);
        }

        return arrayListCidadesUfs;
    }


    public Uf getUfId(int id){

        String id_uf = String.valueOf(id);
        Uf uf = null;
        SQLiteDatabase database = this.getWritableDatabase();

        String query = "SELECT uf.id_uf, uf.descricao FROM uf WHERE uf.id_uf ="+id_uf;

        Cursor cursor = database.rawQuery(query,null);

        while (cursor.moveToNext()){

            uf = new Uf();
            uf.setId_uf(cursor.getInt(0));
            uf.setDescricao(cursor.getString(1));

        }
        return uf;
    }

}


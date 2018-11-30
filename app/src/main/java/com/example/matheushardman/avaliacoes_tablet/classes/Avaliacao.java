package com.example.matheushardman.avaliacoes_tablet.classes;

import java.io.Serializable;

public class Avaliacao implements Serializable {

    private String data;
    private Integer idAv;
    private Integer idCidade;

    @Override
    public String toString(){

        return  "Código: " +this.idAv+ "\nData: "+ this.data;
    }

    /**********************Conteudo Teórico*******************************/

    private int radioSim_1, radioNao_1;

    /**********************Conteudo Prático*******************************/

    private int radioMuito_2, radiobom_2, radioRegular_2, radioRuim_2;
    private int radioSeguro_3, radioPoucoSeguro_3, radioInseguro_3;
    private int radioExcessiva_4, radioRazoavel_4, RadioInsuficiente_4;

    /*****************************Instrutor*******************************/

    private int radioMuito_5, radiobom_5, radioRegular_5, radioRuim_5;
    private int radioMuito_6, radiobom_6, radioRegular_6, radioRuim_6;
    private int radioMuito_7, radiobom_7, radioRegular_7, radioRuim_7;

    /***************************Equipe de Apoio***************************/

    private int radioMuito_8, radiobom_8, radioRegular_8, radioRuim_8;
    private int radioMuito_9, radiobom_9, radioRegular_9, radioRuim_9;
    private int radioMuito_10, radiobom_10, radioRegular_10, radioRuim_10;

    /******************************Sugestões******************************/

    private String sugestoes;

    /******************************GET E SET******************************/

    public Integer getIdAv() { return idAv;}

    public void setIdAv(Integer idAv) {this.idAv = idAv;}

    public Integer getIdCidade() {return idCidade;}

    public void setIdCidade(Integer idCidade) {this.idCidade = idCidade;}

    public int getRadioSim_1() {
        return radioSim_1;
    }

    public void setRadioSim_1(int radioSim_1) {
        this.radioSim_1 = radioSim_1;
    }

    public int getRadioNao_1() {
        return radioNao_1;
    }

    public void setRadioNao_1(int radioNao_1) {
        this.radioNao_1 = radioNao_1;
    }

    public int getRadioMuito_2() {
        return radioMuito_2;
    }

    public void setRadioMuito_2(int radioMuito_2) {
        this.radioMuito_2 = radioMuito_2;
    }

    public int getRadiobom_2() {
        return radiobom_2;
    }

    public void setRadiobom_2(int radiobom_2) {
        this.radiobom_2 = radiobom_2;
    }

    public int getRadioRegular_2() {
        return radioRegular_2;
    }

    public void setRadioRegular_2(int radioRegular_2) {
        this.radioRegular_2 = radioRegular_2;
    }

    public int getRadioRuim_2() {
        return radioRuim_2;
    }

    public void setRadioRuim_2(int radioRuim_2) {
        this.radioRuim_2 = radioRuim_2;
    }

    public int getRadioSeguro_3() {
        return radioSeguro_3;
    }

    public void setRadioSeguro_3(int radioSeguro_3) {
        this.radioSeguro_3 = radioSeguro_3;
    }

    public int getRadioPoucoSeguro_3() {
        return radioPoucoSeguro_3;
    }

    public void setRadioPoucoSeguro_3(int radioPoucoSeguro_3) {
        this.radioPoucoSeguro_3 = radioPoucoSeguro_3;
    }

    public int getRadioInseguro_3() {
        return radioInseguro_3;
    }

    public void setRadioInseguro_3(int radioInseguro_3) {
        this.radioInseguro_3 = radioInseguro_3;
    }

    public int getRadioExcessiva_4() {
        return radioExcessiva_4;
    }

    public void setRadioExcessiva_4(int radioExcessiva_4) {this.radioExcessiva_4 = radioExcessiva_4;}

    public int getRadioRazoavel_4() {
        return radioRazoavel_4;
    }

    public void setRadioRazoavel_4(int radioRazoavel_4) {
        this.radioRazoavel_4 = radioRazoavel_4;
    }

    public int getRadioInsuficiente_4() {
        return RadioInsuficiente_4;
    }

    public void setRadioInsuficiente_4(int radioInsuficiente_4) {
        RadioInsuficiente_4 = radioInsuficiente_4;
    }

    public int getRadioMuito_5() {
        return radioMuito_5;
    }

    public void setRadioMuito_5(int radioMuito_5) {
        this.radioMuito_5 = radioMuito_5;
    }

    public int getRadiobom_5() {
        return radiobom_5;
    }

    public void setRadiobom_5(int radiobom_5) {
        this.radiobom_5 = radiobom_5;
    }

    public int getRadioRegular_5() {
        return radioRegular_5;
    }

    public void setRadioRegular_5(int radioRegular_5) {
        this.radioRegular_5 = radioRegular_5;
    }

    public int getRadioRuim_5() {
        return radioRuim_5;
    }

    public void setRadioRuim_5(int radioRuim_5) {
        this.radioRuim_5 = radioRuim_5;
    }

    public int getRadioMuito_6() {
        return radioMuito_6;
    }

    public void setRadioMuito_6(int radioMuito_6) {
        this.radioMuito_6 = radioMuito_6;
    }

    public int getRadiobom_6() {
        return radiobom_6;
    }

    public void setRadiobom_6(int radiobom_6) {
        this.radiobom_6 = radiobom_6;
    }

    public int getRadioRegular_6() {
        return radioRegular_6;
    }

    public void setRadioRegular_6(int radioRegular_6) {
        this.radioRegular_6 = radioRegular_6;
    }

    public int getRadioRuim_6() {
        return radioRuim_6;
    }

    public void setRadioRuim_6(int radioRuim_6) {
        this.radioRuim_6 = radioRuim_6;
    }

    public int getRadioMuito_7() {
        return radioMuito_7;
    }

    public void setRadioMuito_7(int radioMuito_7) {
        this.radioMuito_7 = radioMuito_7;
    }

    public int getRadiobom_7() {
        return radiobom_7;
    }

    public void setRadiobom_7(int radiobom_7) {
        this.radiobom_7 = radiobom_7;
    }

    public int getRadioRegular_7() {
        return radioRegular_7;
    }

    public void setRadioRegular_7(int radioRegular_7) {
        this.radioRegular_7 = radioRegular_7;
    }

    public int getRadioRuim_7() {
        return radioRuim_7;
    }

    public void setRadioRuim_7(int radioRuim_7) {
        this.radioRuim_7 = radioRuim_7;
    }

    public int getRadioMuito_8() {
        return radioMuito_8;
    }

    public void setRadioMuito_8(int radioMuito_8) {
        this.radioMuito_8 = radioMuito_8;
    }

    public int getRadiobom_8() {
        return radiobom_8;
    }

    public void setRadiobom_8(int radiobom_8) {
        this.radiobom_8 = radiobom_8;
    }

    public int getRadioRegular_8() {
        return radioRegular_8;
    }

    public void setRadioRegular_8(int radioRegular_8) {
        this.radioRegular_8 = radioRegular_8;
    }

    public int getRadioRuim_8() {
        return radioRuim_8;
    }

    public void setRadioRuim_8(int radioRuim_8) {
        this.radioRuim_8 = radioRuim_8;
    }

    public int getRadioMuito_9() {
        return radioMuito_9;
    }

    public void setRadioMuito_9(int radioMuito_9) {
        this.radioMuito_9 = radioMuito_9;
    }

    public int getRadiobom_9() {
        return radiobom_9;
    }

    public void setRadiobom_9(int radiobom_9) {
        this.radiobom_9 = radiobom_9;
    }

    public int getRadioRegular_9() {
        return radioRegular_9;
    }

    public void setRadioRegular_9(int radioRegular_9) {
        this.radioRegular_9 = radioRegular_9;
    }

    public int getRadioRuim_9() {
        return radioRuim_9;
    }

    public void setRadioRuim_9(int radioRuim_9) {
        this.radioRuim_9 = radioRuim_9;
    }

    public int getRadioMuito_10() {
        return radioMuito_10;
    }

    public void setRadioMuito_10(int radioMuito_10) {
        this.radioMuito_10 = radioMuito_10;
    }

    public int getRadiobom_10() {
        return radiobom_10;
    }

    public void setRadiobom_10(int radiobom_10) {
        this.radiobom_10 = radiobom_10;
    }

    public int getRadioRegular_10() {
        return radioRegular_10;
    }

    public void setRadioRegular_10(int radioRegular_10) {
        this.radioRegular_10 = radioRegular_10;
    }

    public int getRadioRuim_10() {
        return radioRuim_10;
    }

    public void setRadioRuim_10(int radioRuim_10) {
        this.radioRuim_10 = radioRuim_10;
    }

    public String getSugestoes() {
        return sugestoes;
    }

    public void setSugestoes(String sugestoes) {
        this.sugestoes = sugestoes;
    }

    public String getData() {return data;}

    public void setData(String data) {this.data = data;}
}

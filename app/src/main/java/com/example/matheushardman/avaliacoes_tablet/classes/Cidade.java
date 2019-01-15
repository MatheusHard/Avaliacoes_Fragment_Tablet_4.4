package com.example.matheushardman.avaliacoes_tablet.classes;

public class Cidade {

    private int id_cidade;
    private String descricao;
    private int cod_uf;


    @Override
    public String toString() { return this.descricao;}

    public int getCod_uf() {
        return cod_uf;
    }

    public void setCod_uf(int cod_uf) {
        this.cod_uf = cod_uf;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}

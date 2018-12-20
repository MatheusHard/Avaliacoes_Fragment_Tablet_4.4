package com.example.matheushardman.avaliacoes_tablet.classes;

public class Uf {


    private int id_uf;
    private String descricao;

    @Override
    public String toString() {
        return this.cidade +"/"+ this.descricao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    private Cidade cidade;


    public int getId_uf() {
        return id_uf;
    }

    public void setId_uf(int id_uf) {
        this.id_uf = id_uf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

package br.edu.farol.gadoplus.model;

public class Propriedade extends BaseModel {

    private double hectares;
    private String descricao;


    public double getHectares() {
        return hectares;
    }

    public void setHectares(double hectares) {
        this.hectares = hectares;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
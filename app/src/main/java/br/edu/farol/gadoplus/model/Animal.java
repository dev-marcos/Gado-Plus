package br.edu.farol.gadoplus.model;

import java.util.Date;

public class Animal extends BaseModel{
    private Lote lote;
    private String sexo;
    private Date dtEntrada;
    private Date dtPrimeiraPesagem;
    private double primeiroPeso;
    private Raca raca;
    private double precoCompra;
    private Date dtNascimento;
    private Date dtDesmame;
    private String observacoes;

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Date getDtPrimeiraPesagem() {
        return dtPrimeiraPesagem;
    }

    public void setDtPrimeiraPesagem(Date dtPrimeiraPesagem) {
        this.dtPrimeiraPesagem = dtPrimeiraPesagem;
    }

    public double getPrimeiroPeso() {
        return primeiroPeso;
    }

    public void setPrimeiroPeso(double primeiroPeso) {
        this.primeiroPeso = primeiroPeso;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Date getDtDesmame() {
        return dtDesmame;
    }

    public void setDtDesmame(Date dtDesmame) {
        this.dtDesmame = dtDesmame;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

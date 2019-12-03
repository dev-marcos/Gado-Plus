package br.edu.farol.gadoplus.model;

import java.util.Date;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "animal")
public class Animal{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "lote_id")
    private int loteId;

    @ColumnInfo(name = "sexo")
    private String sexo;

    @ColumnInfo(name = "dt_entrada")
    private Date dtEntrada;

    @ColumnInfo(name = "dt_primeira_pesagem")
    private Date dtPrimeiraPesagem;

    @ColumnInfo(name = "primeiro_peso")
    private double primeiroPeso;

    @ColumnInfo(name = "raca_id")
    private int racaId;

    @ColumnInfo(name = "preco_compra")
    private double precoCompra;

    @ColumnInfo(name = "dt_nascimento")
    private Date dtNascimento;

    @ColumnInfo(name = "dt_desmame")
    private Date dtDesmame;

    @ColumnInfo(name = "observacoes")
    private String observacoes;

    @Ignore
    public Animal(String nome, int loteId, String sexo, Date dtEntrada,
                  Date dtPrimeiraPesagem, double primeiroPeso, int racaId, double precoCompra,
                  Date dtNascimento, Date dtDesmame, String observacoes){
        this.nome = nome;
        this.loteId = loteId;
        this.sexo = sexo;
        this.dtEntrada = dtEntrada;
        this.dtPrimeiraPesagem = dtPrimeiraPesagem;
        this.primeiroPeso = primeiroPeso;
        this.racaId = racaId;
        this.precoCompra = precoCompra;
        this.dtNascimento = dtNascimento;
        this.dtDesmame = dtDesmame;
        this.observacoes = observacoes;
    }

    public Animal(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLoteId() {
        return loteId;
    }

    public void setLoteId(int loteId) {
        this.loteId = loteId;
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

    public int getRacaId() {
        return racaId;
    }

    public void setRacaId(int racaId) {
        this.racaId = racaId;
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

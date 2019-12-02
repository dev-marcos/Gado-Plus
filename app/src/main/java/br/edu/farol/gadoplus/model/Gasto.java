package br.edu.farol.gadoplus.model;

import java.util.Date;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "gasto")
public class Gasto {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "tipo_gasto_id")
    private int tipoGastoId;

    @ColumnInfo(name = "animal_id")
    private int animalId;

    @ColumnInfo(name = "data")
    private Date data;

    @ColumnInfo(name = "valor")
    private double valor;

    @ColumnInfo(name = "descricao")
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoGastoId() {
        return tipoGastoId;
    }

    public void setTipoGastoId(int tipoGastoId) {
        this.tipoGastoId = tipoGastoId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

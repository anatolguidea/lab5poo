package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Comenzi {
    private int comandaID;
    private String dataComenzii;
    private double totalComanda;
    private String produs;
    private int cantitate;
    private int cumparatorID;

    public Comenzi(){}
    public Comenzi(int comandaID, String dataComenzii, double totalComanda, String produs, int cantitate, int cumparatorID) {
        this.comandaID = comandaID;
        this.dataComenzii = dataComenzii;
        this.totalComanda = totalComanda;
        this.produs = produs;
        this.cantitate = cantitate;
        this.cumparatorID = cumparatorID;
    }

    @Override
    public String toString() {
        return "Comenzi{" +
                "comandaID=" + comandaID +
                ", dataComenzii=" + dataComenzii +
                ", totalComanda=" + totalComanda +
                ", produs='" + produs + '\'' +
                ", cantitate=" + cantitate +
                ", cumparatorID=" + cumparatorID +
                '}';
    }
}

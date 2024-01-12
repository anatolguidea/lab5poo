package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Produs {
    private int codProdus;
    private String denumire;
    private double pret;
    private int stoc;

    public Produs(){}
    public Produs(int codProdus, String denumire, double pret, int stoc) {
        this.codProdus = codProdus;
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "codProdus='" + codProdus + '\'' +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", stoc=" + stoc +
                '}';
    }
}

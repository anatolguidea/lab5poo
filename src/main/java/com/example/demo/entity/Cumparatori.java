package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Cumparatori {

    private int cumparatorID;
    private String nume;
    private String prenume;
    private String email;
    private String telefon;
    private String adresa;



    // Constructor
    public Cumparatori(){}
    public Cumparatori(String nume, String prenume, String email, String telefon, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Cumparatori{" +
                "cumparatorID=" + cumparatorID +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}

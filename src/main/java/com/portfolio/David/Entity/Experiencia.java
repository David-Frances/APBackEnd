/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.David.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author David
 */
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreXP;
    private String descripXP;

    public Experiencia() {
    }

    public Experiencia(String nombreXp, String descripXP) {
        this.nombreXP = nombreXp;
        this.descripXP = descripXP;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreXP() {
        return nombreXP;
    }

    public void setNombreXP(String nombreXp) {
        this.nombreXP = nombreXp;
    }

    public String getDescripXP() {
        return descripXP;
    }

    public void setDescripXP(String descripXP) {
        this.descripXP = descripXP;
    }
    
    
}

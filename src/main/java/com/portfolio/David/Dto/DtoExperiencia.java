/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.David.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author David
 */

public class DtoExperiencia {
    @NotBlank
    private String nombreXP;
    @NotBlank
    private String descripXP;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreXP, String descripXP) {
        this.nombreXP = nombreXP;
        this.descripXP = descripXP;
    }

    public String getNombreXP() {
        return nombreXP;
    }

    public void setNombreXP(String nombreXP) {
        this.nombreXP = nombreXP;
    }

    public String getDescripXP() {
        return descripXP;
    }

    public void setDescripXP(String descripXP) {
        this.descripXP = descripXP;
    }
    
    
}

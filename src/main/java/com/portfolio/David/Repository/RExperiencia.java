/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.David.Repository;

import com.portfolio.David.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public interface RExperiencia extends JpaRepository<Experiencia,Integer>{
    public Optional<Experiencia> findByNombreXP(String nombreXP);
    public boolean existsByNombreXP(String nombreXP);
    
}

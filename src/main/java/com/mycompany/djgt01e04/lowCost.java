/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.djgt01e04;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Daniel
 */
public class lowCost extends Habitacion {

    public lowCost(String numero) {
        super("L"+numero);
    }

    @Override
    public double checkout() {
        int dias = (int) super.getfReserva().until(LocalDateTime.now(), ChronoUnit.DAYS);
        super.setEstado(false);
        return dias * 50;
    }

    @Override
    public String toString() {
        return "Habitación lowcost " + super.toString();
    }

}

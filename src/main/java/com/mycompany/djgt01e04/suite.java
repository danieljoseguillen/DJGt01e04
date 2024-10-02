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
public class suite extends Habitacion {

    @Override
    public double checkout() {
        /**
         * Codigo de prueba.
         * int dias = (int) super.getfReserva().until(LocalDateTime.now(), ChronoUnit.SECONDS);
         */
        int dias = (int) super.getfReserva().until(LocalDateTime.now(), ChronoUnit.DAYS);
        double mult = 1.0;
        if (dias >= 10) {
            mult = 0.8;
        }
        super.setEstado(false);
        return (dias * 200) * mult;
    }

    public suite(String numero) {
        super("S"+numero);
    }

    @Override
    public String toString() {
        return "Habitación suite " + super.toString();
    }

}

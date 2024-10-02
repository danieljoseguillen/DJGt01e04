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
public class doble extends Habitacion {

    public doble(String numero) {
        super("D"+numero);
    }

    @Override
    public double checkout() {
        int dias = (int) super.getfReserva().until(LocalDateTime.now(), ChronoUnit.DAYS);
        double mult = 1.0;
        int mSalida = LocalDateTime.now().getMonthValue();
        if (mSalida == 4 | mSalida == 7 | mSalida == 8) {
            mult = 0.8;
        }
        super.setEstado(false);
        return (dias * 100) * mult;
    }

    @Override
    public String toString() {
        return "Habitación doble " + super.toString();
    }
}

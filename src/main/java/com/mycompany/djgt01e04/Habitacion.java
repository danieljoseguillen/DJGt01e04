/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.djgt01e04;

import java.time.LocalDateTime;

/**
 *
 * @author Daniel
 */
public abstract class Habitacion {

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        if (estado==false){
        return numero+" No reservada.";
        }else{
        return numero+" Reservada en fecha "+fReserva;
        }
    }

    public LocalDateTime getfReserva() {
        return fReserva;
    }

    public void setfReserva(LocalDateTime fReserva) {
        this.fReserva = fReserva;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Habitacion(String numero) {
        this.numero=numero;
        this.estado = false;
    }
    private LocalDateTime fReserva;
    private boolean estado;
    private String numero;
    
    public void checkin() {
        fReserva = LocalDateTime.now();
        estado = true;
    }

    public abstract double checkout();

}

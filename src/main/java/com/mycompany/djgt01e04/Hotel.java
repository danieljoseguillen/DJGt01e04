/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.djgt01e04;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class Hotel {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Hotel(String nombre) {
        this.nombre = nombre;
        habitaciones = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            habitaciones.add(new lowCost(String.valueOf(i + 1)));
        }
        for (int i = 0; i < 10; i++) {
            habitaciones.add(new doble(String.valueOf(i + 1)));
        }
        for (int i = 0; i < 5; i++) {
            habitaciones.add(new suite(String.valueOf(i + 1)));
        }
    }
    private String nombre;
    ArrayList<Habitacion> habitaciones;

    public void listhablibres() {
        int lc = 0, db = 0, su = 0;
        for (Habitacion h : habitaciones) {
            if (h.isEstado() == false) {
                System.out.println(h.toString());
                if (h instanceof suite) {
                    su++;
                } else if (h instanceof doble) {
                    db++;
                } else {
                    lc++;
                }
            }
        }
        System.out.println("Habitaciones disponibles:\nLowCost: " + lc
                + "\nDobles: " + db + "\nSuite: " + su);
    }

    public void listhabreservadas() {
        int lc = 0, db = 0, su = 0;
        for (Habitacion h : habitaciones) {
            if (h.isEstado() == true) {
                System.out.println(h.toString());
                if (h instanceof suite) {
                    su++;
                } else if (h instanceof doble) {
                    db++;
                } else {
                    lc++;
                }
            }
        }
        System.out.println("Habitaciones reservadas:\nLowCost: " + lc
                + "\nDobles: " + db + "\nSuite: " + su);
    }

    public String realizarReserva(String val) throws Exception {
        String nom = "";
        if (!val.equalsIgnoreCase("suite") && !val.equalsIgnoreCase("doble") && !val.equalsIgnoreCase("lowcost")) {
            throw new RuntimeException("No existe una habitación de ese tipo.");
        } else {
            for (int i = 0; i < habitaciones.size(); i++) {
                if (habitaciones.get(i).isEstado() == false) {
                    if (val.equalsIgnoreCase("suite") && habitaciones.get(i) instanceof suite) {
                        habitaciones.get(i).checkin();
                        return habitaciones.get(i).getNumero();
                    } else if (val.equalsIgnoreCase("doble") && habitaciones.get(i) instanceof doble) {
                        habitaciones.get(i).checkin();
                        return habitaciones.get(i).getNumero();
                    } else if (val.equalsIgnoreCase("lowcost") && habitaciones.get(i) instanceof lowCost) {
                        habitaciones.get(i).checkin();
                        return habitaciones.get(i).getNumero();
                    }
                }
            }
            throw new RuntimeException("No se encontró una habitación de ese tipo desocupada.");
        }
    }

    public double AnularReserva(String val) throws Exception {
        boolean check = false;
        for (Habitacion h : habitaciones) {
            if (h.getNumero().equalsIgnoreCase(val)) {
                if (h.isEstado() == true) {
                    return h.checkout();
                } else {
                    throw new RuntimeException("La habitación no está ocupada.");
                }
            }
        }
        throw new RuntimeException("No se encontró la habitación.");
    }
}

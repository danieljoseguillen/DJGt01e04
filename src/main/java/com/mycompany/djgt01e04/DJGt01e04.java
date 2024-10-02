/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.djgt01e04;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class DJGt01e04 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nombre del hotel?");
        String nom = scan.nextLine();
        Hotel ho = new Hotel(nom);
        int num = 0;
        String val;
        System.out.println("\nBienvenido al hotel " + ho.getNombre());
        do {
            val="";
            System.out.println("\nQué operación desea realizar?"
                    + "\n1 - Consultar habitaciones vacías."
                    + "\n2 - Consultar habitaciones ocupadas"
                    + "\n3 - Realizar una reserva."
                    + "\n4 - Anular reserva."
                    + "\n0 - Salir.");
            try {
                num = Integer.parseInt(scan.nextLine());
                switch (num) {
                    case 0 -> {
                         System.out.println("Hasta pronto!");
                    }
                    case 1 -> {
                        ho.listhablibres();
                    }
                    case 2 -> {
                        ho.listhabreservadas();
                    }
                    case 3 -> {
                        System.out.println("Ingrese el tipo de suite:\nLowCost\nDoble\nSuite");
                        val=scan.nextLine();
                        ho.realizarReserva(val);
                    }
                    case 4 -> {
                        System.out.println("Ingrese el numero de habitación.");
                        val=scan.nextLine();
                        ho.AnularReserva(val);
                    }
                    default -> {
                        System.out.println("Digito erroneo.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: no se ingresó un numero.");
            }
        } while (num != 0);
        /**
         * Codigo de prueba (Nunca está de mas tenerlo.) ho.listhablibres();
         * ho.realizarReserva("suite"); ho.realizarReserva("dobel");
         * ho.realizarReserva("doble"); ho.listhabreservadas();
         * ho.listhablibres(); try { Thread.sleep(15000); } catch
         * (InterruptedException ex) {
         * Logger.getLogger(DJGt01e04.class.getName()).log(Level.SEVERE, null,
         * ex); } ho.AnularReserva("l1"); *
         */
    }
}

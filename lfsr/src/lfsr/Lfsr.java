/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfsr;

import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Lfsr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj ziarno, wartosc poczatkowa");
        String z = skaner.next();
        System.out.println("ziarno = " + z + " ");
        System.out.println("Podaj wielomian, ktore przelaczniki maja byc uzyte");
        String p = skaner.next();
        System.out.println("wielomian = " + p + " ");
        lfsrCode lfsr = new lfsrCode();
        lfsr.makeLfsr(z, p);
        
        
    }
    
}

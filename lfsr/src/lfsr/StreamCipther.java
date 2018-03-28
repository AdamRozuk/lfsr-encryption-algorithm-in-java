/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfsr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author dell
 */
public class StreamCipther {

    private final ArrayList<Integer> bits = new ArrayList<>();
    private final ArrayList<String> bits2 = new ArrayList<>();

    public void makeStreamCipther(String z, String p, String mes) throws FileNotFoundException, IOException {

        Integer count = 0;
        /*        try (Scanner sc = new Scanner(new File("testy.txt"), "ISO-8859-1")) { //albo test21.bin
        while (sc.hasNextLine()) {
        String line = sc.nextLine();
        System.out.println(line);
        count++;
        }
        // note that Scanner suppresses exceptions
        // zwykle pliki txt fajnie czyta linia po linii
        // z binarnymi troche gorzej
        if (sc.ioException() != null) {
        throw sc.ioException();
        }
        }
        System.out.println("count: " + count);*/

        //System.out.println("line: " + bits2.get(0));*/
        //to na dole generalnie czyta pliki txt i chyba binarne i zaminia wszystko na int ascii
        // nw jak powinien  wyglądać plik binarny  wiec nw czy dibrze wypisuje
        // ale jak by co użyc możesz jakiegos lepszego kodu 
        FileInputStream f = new FileInputStream("testy.txt");  // albo test21.bin
        int b;
        long checkSum = 0L;
        while ((b = f.read()) != -1) {
            checkSum += b;
            bits.add(b);
            System.out.println(b);
            count++;
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("bits: " + bits.get(i));
        }

        System.out.println("count: " + count);

        String[] tabz = new String[z.length()];
        String[] tabp = new String[p.length()];
        String[] tabm = new String[mes.length()];
        Integer[] tabMesOut = new Integer[mes.length()];
        String[] tabzPast = new String[z.length()];
        String[] tmpt = new String[p.length() - 1];
        int n = z.length();
        String[] tabAll = new String[(n * n) - 1];
        String tmp = new String();
        String tmp2 = new String();
        Integer tmp3 = 0;
        Vector<Integer> vect = new Vector();

        for (int i = 0; i < mes.length(); i++) {
            tabm[i] = mes.charAt(i) + "";
        }

        for (int i = 0; i < p.length(); i++) {
            tabp[i] = p.charAt(i) + "";
            tabz[i] = z.charAt(i) + "";
        }

        for (int i = 0; i < p.length(); i++) {
            if (Integer.parseInt(tabp[i]) == 1) {
                vect.add(i);
            }
        }

        for (int i = 0; i < mes.length(); i++) {
            for (int j = 0; j < n - 1; j++) {
                tmp += tabz[j];
            }

            tmp3 = 0;
            for (Integer vect1 : vect) {
                tmp3 += Integer.parseInt(tabz[vect1]);
            }
            tmp2 = ((tmp3) % 2) + tmp;
            tabAll[i] = tmp2;
            tabMesOut[i] = (((tmp3) % 2) + Integer.parseInt(tabm[i])) % 2;
            for (int m = 0; m < n; m++) {
                tabzPast[m] = tabz[m];
            }

            for (int k = 0; k < n; k++) {
                tabz[k] = tabAll[i].charAt(k) + "";
            }
            tmp = "";
        }
        System.out.println("Zaszyfrowana/Odszyfrowana wiadomość : ");
        for (Integer message : tabMesOut) {
            System.out.print(message);
        }
        System.out.println();

    }

}

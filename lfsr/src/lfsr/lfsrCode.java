/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfsr;

/**
 *
 * @author dell
 */
public class lfsrCode {

    public lfsrCode() {
    }

    public void makeLfsr(String z, String p) {
        String[] tabz = new String[z.length()];
        String[] tabp = new String[p.length()];
        String[] tabzPast = new String[z.length()];
        String[] tmpt = new String[p.length()-1];
        int n = z.length();
        String[] tabAll = new String[(n*n)-1];
        String tmp = new String();
        String tmp2 = new String();

        for (int i = 0; i < z.length() ; i++) {
            tabz[i] = z.charAt(i) + "";
            tabp[i] = p.charAt(i) + "";
            tabzPast[i] = z.charAt(i) + "";
            System.out.println(tabz[i]);
        }

        for (int i = 0; i < (n*n)-1; i++) {
            for (int j = 0; j < n - 1; j++) {
                tmp += tabz[j];
                //tmpt[j] = tmp.charAt(j)+"";
            }
            //System.out.println("tmp: " +tmp);
            System.out.println("int0: " + (Integer.parseInt(tabzPast[0]) +" int1: " + Integer.parseInt(tabzPast[1]) + " int2: " + Integer.parseInt(tabzPast[2]) +" int3:  " + Integer.parseInt(tabzPast[3])));
            System.out.println("tmp: " + tmp);
            tmp2 = ((Integer.parseInt(tabz[0]) + Integer.parseInt(tabz[3]))%2) + tmp;
            System.out.println("tmp2: " + tmp2);
            tabAll[i] = tmp2;
            
            for (int m = 0; m < n ; m++) {
                tabzPast[m] = tabz[m];
            }
            
            for (int k = 0; k < n ; k++) {
                tabz[k] = tabAll[i].charAt(k) + "";
            }
            tmp = "";
        }

        for (String tabAll1 : tabAll) {
            System.out.println(tabAll1);
        }

    }

}

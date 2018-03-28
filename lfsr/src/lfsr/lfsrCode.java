/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lfsr;
import java.util.Vector;
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
        Integer tmp3 = 0;
        Vector<Integer> vect = new Vector();

        for (int i = 0; i < z.length() ; i++) {
            tabz[i] = z.charAt(i) + "";
            tabp[i] = p.charAt(i) + "";
        }
        
        for (int i = 0; i < p.length() ; i++) {
            if(Integer.parseInt(tabp[i])==1){
                vect.add(i);
            }
        }
        
        for (int i = 0; i < (n*n)-1; i++) {
            for (int j = 0; j < n - 1; j++) {
                tmp += tabz[j];
            }

            tmp3 = 0;
            for (Integer vect1 : vect) {
                tmp3 += Integer.parseInt(tabz[vect1]);
            }
            tmp2 = ((tmp3)%2) + tmp;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nic.scanner;

import java.util.Scanner;
/**
 *
 * @author #Shap_Manasick
 */
public class NICScanner {
    
    String id;
    int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public NICScanner() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your NIC Number \nLike : 000000000V");
        id = input.next();
    }

    public int getYear() {
        return (1900 + Integer.parseInt(id.substring(0, 2)));
    }

    public int getDays() {
        int d = Integer.parseInt(id.substring(2, 5));
        if (d > 500) {
            return (d - 500);
        } else {
            return d;
        }
    }

    public void setMonth() {
        int mo = 0, da = 0;
        int days = getDays();

        for (int i = 0; i < month.length; i++) {
            if (days < month[i]) {
                mo = i + 1;
                da = days;
                break;
            } else {
                days = days - month[i];
            }
        }
        System.out.println("Month : " + mo + "\nDate : " + da);

    }

    public String getSex() {
        String M = "Male", F = "Female";
        int d = Integer.parseInt(id.substring(2, 5));
        if (d > 500) {
            return F;
        } else {
            return M;
        }
    }

    public static void main(String[] args) {
        NICScanner N = new NICScanner();
        System.out.println("Your Deatials of Date of Birth from NIC Number");
        System.out.println("Year : " + N.getYear());
        N.setMonth();
        System.out.println("Sex : " + N.getSex());
    }
    
}

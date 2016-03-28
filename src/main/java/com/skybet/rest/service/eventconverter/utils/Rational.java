package com.skybet.rest.service.eventconverter.utils;


import java.math.BigInteger;

public class Rational {

    private int num, denom;

    public Rational(double d) {
        String s = String.valueOf(d);
        int digitsDec = s.length() - 1 - s.indexOf('.');
        int denom = 1;
        for (int i = 0; i < digitsDec; i++) {
            d *= 10;    
            denom *= 10;
        }

        int num = (int) Math.round(d);
        int g = gcd(num, denom);
        this.num = num / g;
        this.denom = denom /g;
    }

    public Rational(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public String toString() {
        return String.valueOf(num) + "/" + String.valueOf(denom);
    }

    
    private static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }


    public static void main(String[] args) {
    	double val = 2.38;
        System.out.println(new Rational(val -1.00));
    }
}
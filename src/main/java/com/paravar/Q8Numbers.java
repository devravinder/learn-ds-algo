package com.paravar;

public class Q8Numbers {
    public static void main(String[] args) {

        int n = 2;
        System.out.printf("binary form %s & no of 1bits of %d : %d%n",Integer.toBinaryString(n), n, noOf1Bits(n));

    }

    public static int noOf1Bits(int n){

        /*
         number - binary form - noOf1s
         0      - 0           - 0
         1      - 1           - 1
         2      - 10          - 1
         3      - 11          - 2
         4      - 100         - 1
         5      - 101         - 2
         6      - 110         - 2

        * */

        int noOf1Bits=0;

        while (n!=0){
            noOf1Bits = noOf1Bits + (n & 1);
            n = n >>> 1;
        }

        return noOf1Bits;
    }

}

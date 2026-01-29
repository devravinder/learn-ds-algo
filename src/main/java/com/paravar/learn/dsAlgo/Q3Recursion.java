package com.paravar.learn.dsAlgo;

import java.util.Arrays;

public class Q3Recursion {
    public static void main(String[] args) {

        /*
        Loops only one direction (iteration),
        but recursion = iteration + back tracking
        */


        //printNumbersRecursion(0,5);// 0,1,2,3,4,5 (or) 5,4,3,2,1,0


        //printAscendingAndDescending(5);
        // 1,2,3,4,5, then 10,9,8,7,6


        fibonacciSeries(6);

        factorialOfNum(8);
    }

    private static void factorialOfNum(int i) {
        int[] dp = new int[i+1];
        Arrays.fill(dp, -1);

        System.out.printf("Factorial of num %d is %d %n", i, factorialOfNum(i, dp));

    }

    private static int factorialOfNum(int i, int[] dp) {


        if(dp[i]!=-1)
            return dp[i];

        if(i==1)
            return 1;

        var fact = i * factorialOfNum(i-1, dp);

        dp[i] = fact;
        return fact;

    }


    public static void printNumbersRecursion(int start, int end){
        printNumber(start,end);
    }

    public static void printNumber(int n, int limit){
        if(n>limit)
            return;
        else {
            // System.out.println(n); // pre processing ( while going )
            printNumber(n+1, limit);
            System.out.println(n); // reverse order // back tracking ( while coming back )
        }
    }
    public static void printAscendingAndDescending(int size) {
        printAscendingAndDescending(1,size);
    }
    public static void printAscendingAndDescending(int n, int limit){

        if(n>limit)
            return;

        System.out.println(n);
        printAscendingAndDescending(n+1, limit);
        System.out.println(n+limit);
    }

    public static void fibonacciSeries(int size){
        for (int i=0; i<=size; i++)
         System.out.println("fibonacci at index "+i+" is: "+ fibonacci(i));
    }

    public static int fibonacci(int n){
        if(n<=1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

}

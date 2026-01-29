package com.paravar.learn.dsAlgo.practice4.dynamicProgramming;

import java.util.Arrays;

public class Q1FibonacciSeries {
    public static void main(String[] args) {

        // 0,1,1,2,3,5,8,13,21,34

        System.out.println("FibonacciSeries");

        System.out.println("8th :"+ recursionFibonacci(8)); // O( 2^n)  {2 pow n} calls

        System.out.println("8th :"+ recursionFibonacciMemoization(8)); // O(n+1) calls

        System.out.println("8th :"+ iterativeFibonacciTabulation(8)); // O(n+1) calls


    }

    public static int recursionFibonacci(int index){
        if(index<=1)
            return 1;

        return recursionFibonacci(index-1) + recursionFibonacci(index-2);
    }

    public static int recursionFibonacciMemoization(int index){

        int[] arr = new int[index+1]; // or use map  // length = index=1

        Arrays.fill(arr, -1); // fill with -1

        return recursionFibonacciMemoization(index, arr);
    }
    public static int recursionFibonacciMemoization(int n, int[] arr) {
        if(arr[n]!=-1)// store the previously calculated values
            return arr[n];

        if(n<=1)
            return 1;

        int result = recursionFibonacciMemoization(n-1, arr) + recursionFibonacciMemoization(n-2, arr);

        arr[n] = result;


        return result;
    }

    public static int iterativeFibonacciTabulation(int index){

        if(index<=1)
            return 1;

        int[] arr = new int[index+1]; // use table = data structure used to store calculated data

        Arrays.fill(arr, -1);
        arr[0]=0;
        arr[1]=1;

        for( int i=2; i<=index; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[index];
    }







}

package com.paravar.learn.dsAlgo.practice2.searching;

public class Q1BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10}; // sorted array

        search(4, arr);


    }


    public static void search(int num, int... arr){

        int index = search(num, 0, arr.length-1, arr);

        if(index>=0)
            System.out.println(num+" found at index: "+index);
        else System.out.println(" not found ");

    }

    private static int search( int num, int start, int end, int... arr){

        if(start > end)
            return  -1;

        int mid = end + (start - end)/2; // Prevent overflow
//        int mid = (start + end)/2;

        if(arr[mid] ==num)
            return  mid;

        if(num < arr[mid] ){
            return search(num, start, mid-1, arr);
        }
        return  search(num, mid+1, end, arr);

    }

}

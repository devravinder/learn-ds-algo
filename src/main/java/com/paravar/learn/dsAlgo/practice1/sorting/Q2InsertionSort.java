package com.paravar.learn.dsAlgo.practice1.sorting;

import java.util.Arrays;

public class Q2InsertionSort {
    public static void main(String[] args) {
        /*
         Like Playing cards
         - select an element
         - traverse to left...move bigger elements one position right
         - insert the element at the correct position
        * */
        int[] arr = {1, 2, 4, 2, 4, 4, 5};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){

        for( int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>key){
                swap(j, j+1, arr);// move one position right
                j--;
            }
            arr[j+1]=key;
        }

    }
    public static void swap(int first, int second, int[] arr){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}

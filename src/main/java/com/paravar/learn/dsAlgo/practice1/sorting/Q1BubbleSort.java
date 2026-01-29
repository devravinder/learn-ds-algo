package com.paravar.learn.dsAlgo.practice1.sorting;

import java.util.Arrays;

public class Q1BubbleSort {
    public static void main(String[] args) {

        int[] arr = {21, 12,9, 1,2,3,6,7,8,9,10};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));


    }
    public static void bubbleSort(int... arr){

        for(int i=0; i< arr.length-1; i++){

            // Flag to optimize and stop if no swaps are made
            boolean swapped = false;

            for(int j=0; j< arr.length-i-1; j++){ // every time one element get sorted
                if(arr[j]>arr[j+1]){
                    swap(j, j+1, arr);
                    swapped= true;
                }
            }

            // If no swaps were made, the array is already sorted
            if (!swapped) {
                break;
            }
        }

    }
    public static void swap(int first, int second, int[] arr){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

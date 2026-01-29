package com.paravar.learn.dsAlgo.practice1.sorting;

import java.util.Arrays;

public class Q3SelectionSort {
    public static void main(String[] args) {

        /*
         - select an element & keep at the correct place
        */

        int[] arr = {1, 2, 4, 2, 4, 4, 5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int... arr){

        // Easy sorting ***
        for( int i=0; i<arr.length; i++){
            int minIndex = i;

            for(int j=i+1; j<arr.length; j++){
                if(arr[j]< arr[minIndex])
                    minIndex = j;
            }

            swap(i, minIndex,arr); // keep at the correct place
        }
    }
    public static void swap(int first, int second, int[] arr){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

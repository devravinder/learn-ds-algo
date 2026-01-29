package com.paravar;

public class Q9Jump {
    public static void main(String[] args) {


        int[] arr = {4,3,2,1,0};


        int lastIndex = arr.length - 1;

        for(int i=0; i<arr.length; i++){
            if(i+ arr[i]==lastIndex){
                System.out.println("index"+i+" jump "+arr[i]);
                return;
            }
        }

        System.out.println(" not possible ");
    }
}

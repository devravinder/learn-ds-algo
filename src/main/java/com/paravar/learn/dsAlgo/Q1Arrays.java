package com.paravar.learn.dsAlgo;

public class Q1Arrays {
    public static void main(String[] args) {

         uniqueElements(1,2,3,4,5,6,1,2,3);
        uniqueElements2(1,2,3,4,5,6,1,2,3);
         duplicates(1,2,3,4,5,6,1,2,3);
        duplicates2(1,2,3,4,5,6,1,2,3);

         nonRepeating(1,2,3,4,5,6,1,2,3);
         subArraySum(14, 2,2,3,4,7,9,10);// ***
         secondLargest(1,2,3,4,5);



    }
    public static void uniqueElements2(int... arr){

        System.out.println("unique elements-2");
        boolean[] visits = new boolean[arr.length];

        for (int i=0; i<arr.length; i++){
            if(visits[i])
                continue;
            for(int j=i+1; j< arr.length; j++){
                if(arr[i]==arr[j]){
                    visits[j]=true;
                }
            }
                System.out.println(arr[i]);


        }
    }
    public static void uniqueElements(int... arr){

        System.out.println("unique elements");

        for (int i=0; i<arr.length; i++){
            boolean unique = true;
            for(int j=0; j< i; j++){
                if(arr[i]==arr[j]){
                    unique = false;
                    break;
                }
            }
            if(unique){
                System.out.println(arr[i]);
            }

        }
    }

    public static void duplicates(int... arr){

        System.out.println("duplicate elements ");
        for(int i=0; i< arr.length; i++){

            boolean duplicate = false;

            for(int j=0; j<arr.length; j++){
                if( arr[i] == arr[j] && i!=j){
                    if(j<i){
                        break;
                    }
                    duplicate = true;
                }
            }
            if(duplicate){
                System.out.println(arr[i]);
            }

        }


    }
    public static void duplicates2(int... arr){

        System.out.println("duplicate elements 2");
        boolean[] visits = new boolean[arr.length];

        for(int i=0; i< arr.length; i++){
            if(visits[i])
                continue;

            boolean duplicate = false;

            for(int j=i+1; j<arr.length; j++){
                if( arr[i] == arr[j]){
                    visits[j]=true;
                    duplicate = true;
                }
            }
            if(duplicate){
                System.out.println(arr[i]);
            }

        }


    }

    public static void  nonRepeating(int... arr){
        System.out.println("nonRepeating");
        for(int i=0; i< arr.length; i++){
            boolean duplicate = false;
            for(int j=0; j< arr.length; j++){
                if(arr[i]==arr[j] && i!=j){
                    duplicate = true;
                    break;
                }
            }
            if(!duplicate)
                System.out.println(arr[i]);
        }
    }

    public static void subArraySum(int num, int...arr){

        System.out.println("subArraySum");

        for(int i=0; i< arr.length; i++){
            int sum = arr[i];
            for(int j=i+1; j< arr.length; j++){
                sum = sum+arr[j];
                if(sum ==num){
                    System.out.println("found "+i+", "+j);
                    return;
                }
                if(sum > num)
                    break;
            }
        }
        System.out.println(" not found");

    }

    public static void secondLargest(int... arr){

        System.out.println("secondLargest");

        if(arr.length < 2){
            System.out.println(" not enough values");
            return;
        }

        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;

        for( int i : arr){
            if(i>large){
                secondLarge = large;
                large = i;
            }
        }

        System.out.println("secondLarge "+secondLarge);

    }



}

package com.paravar.interview.dsAlgo;

import java.util.Arrays;

public class Q2MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.printf("Minimum coins required for %d amount is %d with %s coins%n", amount, minCoins(coins, amount), Arrays.toString(coins) );
    }
    public static int minCoins(int[] coins, int amount){
        int[] minCoins=new int[amount+1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0]=0;

        for(int coin: coins){
            for(int i=coin; i<=amount; i++){
                if(minCoins[i-coin]!=Integer.MAX_VALUE){
                    minCoins[i]= Math.min(minCoins[i], minCoins[i-coin]+1);
                }
            }
        }

        return minCoins[amount]==Integer.MAX_VALUE ? -1 : minCoins[amount];
    }
}

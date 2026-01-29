package com.paravar.learn.dsAlgo.practice4.dynamicProgramming;

public class Q4KnapsackContainer {
    public static void main(String[] args) {
        /*
        Q:-
        You are given a knapsack with a maximum weight capacity of 50 units.
        There are 4 items, each with a specific weight and value:

        Item 1: Weight = 10, Value = 60
        Item 2: Weight = 20, Value = 100
        Item 3: Weight = 30, Value = 120
        Item 4: Weight = 25, Value = 90
        Find the maximum value that can be obtained
        by selecting a subset of items such that the total weight does not exceed 50 units.
        */

        /*
        Algorithm Explanation:-
        This is the 0/1 Knapsack Problem where:
         - Each item can either be included entirely (1) or excluded (0).
         - The goal is to maximize the total value without exceeding the given weight capacity.

        Steps to Solve:
         - Dynamic Programming Table:
           - Create a 2D table dp[i][w] where:
               - i is the number of items considered.
               - w is the weight capacity.
           - dp[i][w] represents the maximum value obtainable
              - with the first i items and a knapsack capacity of w.

        Initialization:
          - dp[0][w] = 0: If no items are considered, the maximum value is 0.
          - dp[i][0] = 0: If the capacity is 0, the maximum value is 0.

        Recurrence Relation:
         - If the weight of the i-th item is less than or equal to w
           - dp[i][w] = max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
             - dp[i - 1][w]: Value excluding the item.
             - values[i - 1] + dp[i - 1][w - weights[i - 1]]: Value including the item.

         - else, the item is excluded:
            - dp[i][w] = dp[i - 1][w];

       Result:
        - The value at dp[n][capacity] gives the maximum value obtainable.

        */


        int[] weights = {10, 20, 30, 25};
        int[] values = {60, 100, 120, 90};
        int capacity = 50;
        int n = weights.length;

        // Solve the problem using DP
        int maxValue = knapsack(weights, values, capacity, n);
        System.out.println("The maximum value that can be obtained: " + maxValue);
    }

    // Function to solve the knapsack problem
    public static int knapsack(int[] weights, int[] values, int capacity, int n) {
        // n = weights.length
        int[][] dp = new int[n + 1][capacity + 1]; // to store max  values

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) { // imp
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Return the maximum value that can be obtained
        return dp[n][capacity];
    }
}


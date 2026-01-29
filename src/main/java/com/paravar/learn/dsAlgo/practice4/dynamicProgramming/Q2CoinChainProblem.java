package com.paravar.learn.dsAlgo.practice4.dynamicProgramming;

import java.util.Arrays;

public class Q2CoinChainProblem {
    public static void main(String[] args) {

        /*
         i/p: coins {1,2,5}, amount: 11
         o/p: minimum coins required: 3 ={ 5+5+1 }

        * */
        dynamicProgramming();

    }
    public static void dynamicProgramming(){

        /*
        Dynamic Programming (DP), which breaks it into subproblems and builds up solutions.

        Steps:
        - Define a DP Array:
            - Let dp[i] represent the minimum number of coins needed to make an amount i.

        - Initialization:
           - Set dp[0] = 0 (0 coins needed for amount 0).
           - Initialize all other dp[i] to Integer.MAX_VALUE (indicating no solution yet).



        - Iterate Over Coins:
          - For each coin, update the dp array for every amount from the coin value to the target amount.

        - Recursive Relation:
          - For each amount j and coin c:
              - dp[j] = Math.min(dp[j], dp[j - c] + 1);
              - This means we either:
                - Do not use the coin (dp[j] remains the same), or
                - Use the coin (dp[j - c] + 1 because we add one more coin).


        - Result:
           - The answer is dp[amount].
           - If dp[amount] == Integer.MAX_VALUE, it means the amount cannot be formed with the given coins.

        * */

        int[] coins = {1, 2, 5};
        int amount = 1;
        int result = coinChangeDPTabulation(coins, amount);
        System.out.println("DP: Minimum coins required: " + result);

    }
    public static int coinChangeDPTabulation(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // DP array to store minimum coins for each amount

        int NOT_FOUND=Integer.MAX_VALUE;

        // Initialize DP array with a large value
        Arrays.fill(dp, NOT_FOUND);
        dp[0] = 0; // Base case: 0 coins needed to make amount 0

        // Iterate over each coin
        for (int coin : coins) {

            /*
             for each amount(j)...calculate the min no of coins required...with the available coins
            * */

            for (int j = coin; j <= amount; j++) { // this is imp condition
                if (dp[j - coin] != NOT_FOUND) { // this is imp condition ***
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                       /*
                       for amount j min no of coins = min(
                                                    - amount of coins required for amount j ( calculated in previous iteration),
                                                                  - with different coins
                                                    -  min-coins required for amount of (amount-coin + 1)
                                                         - eg:
                                                          - for amount 11...
                                                              - if the coin is 5
                                                              - coins required = coins required for amount 6 + 1
                                                                               = coins required for ( 11-5 ) +1
                                                                               = coins required for ( amount-count ) +1


                        */

                }
            }
        }

        // If dp[amount] is still NOT_FOUND, no solution exists
        return dp[amount] == NOT_FOUND ? -1 : dp[amount];
    }

}

package com.paravar.learn.dsAlgo.leetcode;

// 2. Best Time to Buy and Sell Stock
class Q2BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}

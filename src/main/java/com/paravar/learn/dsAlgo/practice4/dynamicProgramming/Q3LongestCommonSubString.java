package com.paravar.learn.dsAlgo.practice4.dynamicProgramming;

public class Q3LongestCommonSubString {

    public static void main(String[] args) {
        String str1 = "ABABC";
        String str2 = "BABCAB";

        String subStr = findLongestCommonSubstring(str1, str2);
        System.out.println("Length of Longest Common Substring: " + subStr);
    }
    public static String findLongestCommonSubstring(String str1, String str2) {

        /*
        Dynamic Programming Approach:-
        a 2D array table dp where dp[i][j] represents the length of the longest common substring
            - ending at indices i-1 in the first string, and j-1 in the second string.

        Steps:
        Create a 2D array dp[m+1][n+1], where m and n are the lengths of the two strings.
        Fill the array:
        If characters match (str1[i-1] == str2[j-1]), set dp[i][j] = dp[i-1][j-1] + 1.
        Otherwise, set dp[i][j] = 0.
        Track the maximum value in the dp table, which will be the length of the longest common substring.
        Optionally, reconstruct the substring by backtracking.

        */
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0; // To store the length of the longest common substring
        int endIndex = -1; // To store the ending index of the longest substring in str1

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if(dp[i][j]>maxLength){
                        maxLength = dp[i][j];
                        endIndex = i-1;
                    }
                } else {
                    dp[i][j] = 0; // Reset if characters don't match
                }
            }
        }
        // Extract the substring using maxLength and endIndex
        if (maxLength > 0) {
            return str1.substring(endIndex - maxLength + 1, endIndex + 1);
        }

        return ""; // If no common substring exists
    }


}

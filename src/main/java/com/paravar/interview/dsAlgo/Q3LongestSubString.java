package com.paravar.interview.dsAlgo;

public class Q3LongestSubString {
    public static void main(String[] args) {
        // Dynamic Programming
        String str1 = "ABABC";
        String str2 = "BABCAB";

        /*String str1 = "ABABC123abcdabcd1aaaa";
        String str2 = "BABCAB123abcdabcd2aaaa";*/

        String subStr = commonSubString(str1, str2);
        System.out.println("Length of Longest Common Substring: " + subStr);
    }

    public static String commonSubString(String str1, String str2){

        int first = str1.length();
        int second = str1.length();

        int[][] arr = new int[first+1][second+1];
        /*
         to store maxLength results...
         arr[i][j] = subStringLength
           ending indices are: i-1 for first string, j-1 for second string

           we can get starting index using subStringLength & ending index
        * */


        int maxLength=0;
        int endIndex=-1;

        for(int i=1; i<=first; i++){
            for( int j=1; j<=second; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    arr[i][j]= arr[i-1][j-1]+1;

                    if(arr[i][j]>maxLength){
                        maxLength = arr[i][j];
                        endIndex = i-1;
                    }
                }
                else {
                    arr[i][j] = 0; // Reset if characters don't match
                }
            }
        }
        if (maxLength > 0) {
            return str1.substring(endIndex - maxLength + 1, endIndex + 1);
        }
        return "";
    }

}

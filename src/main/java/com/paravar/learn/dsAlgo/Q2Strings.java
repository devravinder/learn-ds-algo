package com.paravar.learn.dsAlgo;

public class Q2Strings {
    public static void main(String[] args) {

        permutations("ABC"); // ***
    }
    public static void permutations(String str){
        /*
        * Steps:
        - Use recursion to generate permutations by swapping characters.
        - At each recursive call:
            Swap each character with the current position.
            Recursively generate permutations for the rest of the string.
            Backtrack by swapping the characters back to their original positions.

            *
            🔹 Step 4: Dry Run Example (for clarity)
            Start: "ABC"
            Swap positions (0,0) → "ABC" → recurse
            Swap (1,1) → "ABC" ✅
            Swap (1,2) → "ACB" ✅
            Swap positions (0,1) → "BAC" → recurse
            Swap (1,1) → "BAC" ✅
            Swap (1,2) → "BCA" ✅
            Swap positions (0,2) → "CBA" → recurse
            Swap (1,1) → "CBA" ✅
            Swap (1,2) → "CAB" ✅

            Result = ABC, ACB, BAC, BCA, CBA, CAB.
            *
            *  Further in Foor loop
                permute("ABC", 0, 2)
                 ├─ swap(0,0) → "ABC" → permute("ABC", 1, 2)
                 │   ├─ swap(1,1) → "ABC" → permute("ABC", 2, 2) → PRINT "ABC"
                 │   └─ swap(1,2) → "ACB" → permute("ACB", 2, 2) → PRINT "ACB"  ✅ (this case)

        * */
        System.out.println("============="+str);
        char[] input = str.toCharArray();
        printPermutations(input, 0, input.length - 1);
    }
    // Method to print all permutations of a character array
    public static void printPermutations(char[] array, int left, int right) {
        // Base case: if left equals right, print the array
        if (left == right) {
            System.out.println(String.valueOf(array));
        } else {
            for (int i = left; i <= right; i++) {
                // Swap characters at position 'left' and 'i'
                swap(array, left, i);

                // Recur for the next position
                printPermutations(array, left + 1, right);

                // Backtrack to restore the original configuration
                swap(array, left, i);
            }
        }
    }

    public static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

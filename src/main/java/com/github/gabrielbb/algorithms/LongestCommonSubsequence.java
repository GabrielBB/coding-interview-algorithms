package com.github.gabrielbb.algorithms;

public class LongestCommonSubsequence {

    public static int getLength(String s1, String s2) {

        int[][] tabulation = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            tabulation[i][0] = 0;
        }

        for (int i = 0; i < s2.length(); i++) {
            tabulation[0][i] = 0;
        }

        int max = 0;

        for (int i = 1; i <= s1.length(); i++) {

            for (int x = 1; x <= s2.length(); x++) {

                if (s1.charAt(i-1) == s2.charAt(x-1)) {
                    tabulation[i][x] = 1 + tabulation[i - 1][x - 1];
                } else {
                    tabulation[i][x] = Math.max(tabulation[i - 1][x], tabulation[i][x - 1]);
                }

                if (tabulation[i][x] > max) {
                    max = tabulation[i][x];
                }
            }
        }

        return max;
    }
}
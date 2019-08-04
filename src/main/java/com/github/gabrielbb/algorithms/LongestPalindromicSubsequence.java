package com.github.gabrielbb.algorithms;

public class LongestPalindromicSubsequence {

    public static int getLength(String x, int i, int j) {

        if (i >= j)
            return 1;

        if (x.charAt(i) == x.charAt(j))
            return 2 + getLength(x, i + 1, j - 1);
        else
            return Math.max(getLength(x, i + 1, j), getLength(x, i, j - 1));
    }

    public static String getString(String x, int i, int j) {

        if (i == j)
            return x.substring(i, i+1);
        
        if(i > j)
            return "";

        if (x.charAt(i) == x.charAt(j))
            return x.charAt(i) + getString(x, i + 1, j - 1) + x.charAt(j);
        else {
            String s1 = getString(x, i + 1, j);
            String s2 = getString(x, i, j - 1);

            return s1.length() > s2.length() ? s1 : s2;
        }
    }
}
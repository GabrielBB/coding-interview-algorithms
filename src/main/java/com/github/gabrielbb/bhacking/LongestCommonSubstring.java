package com.github.gabrielbb.bhacking;

public class LongestCommonSubstring {

    public static String getLongestCommonSubstringNaive(String a, String b) {

        String result = "";

        for (int i = 0; i < a.length(); i++) {

            for (int z = 0; z < b.length(); z++) {

                if (a.charAt(i) == b.charAt(z)) {

                    int i2 = i;
                    int z2 = z;

                    while (i2 < a.length() && z2 < b.length() && a.charAt(i2) == b.charAt(z2)) {
                        i2++;
                        z2++;
                    }

                    if (i2 - i > result.length())
                        result = a.substring(i, i2);
                }
            }
        }

        return result;
    }

    public static int getLongestCommonSubstringLength(String a, String b) {

        int max = 0;
        int[][] tabulation = new int[a.length()][b.length()];

        for (int i = 0; i < a.length(); i++) {

            for (int x = 0; x < b.length(); x++) {

                if (a.charAt(i) == b.charAt(x)) {
                    tabulation[i][x] = tabulation[Math.max(0, i - 1)][Math.max(0, x - 1)] + 1;

                    if (tabulation[i][x] > max) {
                        max = tabulation[i][x];
                    }
                }
            }
        }

        return max;
    }
}
package com.github.gabrielbb.bhacking;

public class LongestCommonSubstring {

    public static String getLongestCommonSubstring(String a, String b) {

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
}
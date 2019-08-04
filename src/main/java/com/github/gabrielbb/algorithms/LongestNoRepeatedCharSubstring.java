package com.github.gabrielbb.algorithms;

public class LongestNoRepeatedCharSubstring {

    // 0(n)
    public static int find(String s) {

        int max = 0;
        Integer[] chars = new Integer[256];

        chars[s.charAt(0)] = 0;
        int currentCount = 1;

        for (int i = 1; i < s.length(); i++) {
            int c = s.charAt(i);

            if (chars[c] != null && chars[c] >= i - currentCount) {
                if (currentCount > max) {
                    max = currentCount;
                }

                currentCount = i - (chars[c] + 1);
            } else {
                currentCount++;
            }

            chars[c] = i;
        }

        return max;
    }

    public static void main(String args[]) {
        System.out.println(find("GEEKSFORGEEKS"));
        System.out.println(find("ABDEFGABEF"));
        System.out.println(find("BBBB"));
    }
}
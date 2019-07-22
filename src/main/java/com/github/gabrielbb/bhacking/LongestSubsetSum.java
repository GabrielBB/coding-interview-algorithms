package com.github.gabrielbb.bhacking;

public class LongestSubsetSum {

    public static int find(int[] arr, int k) {

        int max = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        max = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
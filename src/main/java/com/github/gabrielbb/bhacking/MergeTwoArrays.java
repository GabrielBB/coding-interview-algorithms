package com.github.gabrielbb.bhacking;

public class MergeTwoArrays {

    public static int[] merge(int[] a, int[] b) {

        int[] merged = new int[a.length + b.length];

        int l = 0;
        int r = 0;
        int m = 0;

        while (l < a.length && r < b.length) {
            if (a[l] < b[r]) {
                merged[m++] = a[l++];
            } else {
                merged[m++] = b[r++];
            }
        }

        while (l < a.length) {
            merged[m++] = a[l++];
        }

        while (r < b.length) {
            merged[m++] = b[r++];
        }

        return merged;
    }
}
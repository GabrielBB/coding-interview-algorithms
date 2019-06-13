package com.github.gabrielbb.bhacking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MergeSort {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int[] array = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            mergeSort(array, 0, array.length - 1);
            System.out.println(Arrays.toString(array));
        }
    }

    private static void mergeSort(int[] array, int left, int right) {

        if (left >= right)
            return;

        // Keep dividing array in halves 0(log n)
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);

        // Time to sort both halves 0(n)
        int[] temp = new int[(right - left) + 1];
        int l = left;
        int r = middle + 1;
        int k = 0;

        while(k < temp.length) {
            if(r > right || array[l] <= array[r]) {
                temp[k++] = array[l++];
            } else {
                temp[k++] = array[r++];
            }
        }

        // Copying sorted temp to original array
        while(k > 0) {
            array[right--] = temp[--k];
        }
    }
}
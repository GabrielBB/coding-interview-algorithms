package com.github.gabrielbb.bhacking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class QuickSort {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int[] array = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            quickSort(array, 0, array.length - 1);
            System.out.println(Arrays.toString(array));
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = right;
        int l = left;
        int r = right;

        while (l < r) {

            while (array[l] <= array[pivot] && l < r) {
                l++;
            }

            while (array[r] > array[pivot]) {
                r--;
            }

            if (l < r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }

        /*int temp = array[pivot];
        array[pivot] = array[r];
        array[r] = temp; */

        quickSort(array, left, r - 1);
        quickSort(array, r + 1, right);
    }
}
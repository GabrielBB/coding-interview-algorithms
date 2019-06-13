package com.github.gabrielbb.bhacking;

import java.util.Scanner;
import java.util.stream.Stream;

public class MergeSort {

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            int[] array = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            mergeSort(array, 0, array.length - 1);
         }
    }

    private static void mergeSort(int[] array, int left, int right) {
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle, right);
    }
}
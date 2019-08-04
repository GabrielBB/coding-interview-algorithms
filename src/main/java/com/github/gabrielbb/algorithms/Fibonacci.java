package com.github.gabrielbb.algorithms;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {
            int k = s.nextInt();
            s.nextLine();
            String type = s.nextLine();

            if (type.equals("recursive")) {
                recursive(1, k, 0, 1);
            } else if (type.equals("loop")) {
                loop(k);
            } else if (type.equals("sum")) {
                System.out.println(sum(k));
            } else {
                throw new UnsupportedOperationException(type);
            }
        }
    }

    private static void loop(int k) {
        long prePrevious = 0;
        long previous = 1;

        for (int i = 1; i <= k; i++) {
            long current = prePrevious + previous;
            System.out.println(current);
            prePrevious = previous;
            previous = current;
        }
    }

    private static void recursive(int actual, int k, long prePrevious, long previous) {
        if (actual == k)
            return;

        long current = prePrevious + previous;
        System.out.println(current);
        recursive(actual + 1, k, previous, current);
    }

    private static int sum(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return sum(n - 1) + sum(n - 2);
    }
}
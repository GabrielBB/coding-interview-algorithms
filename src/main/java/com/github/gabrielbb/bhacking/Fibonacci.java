package com.github.gabrielbb.bhacking;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {
            int k = s.nextInt();
            s.nextLine();
            String type = s.nextLine();

            if(type.equals("recursive")) {
                recursiveFibonacci(1, k, 0, 1);
            } else if (type.equals("loop")) {
                fibonacciLoop(k);
            } else {
                throw new UnsupportedOperationException(type);
            }
        }
    }

    private static void fibonacciLoop(int k) {
        long prePrevious = 0;
        long previous = 1;

        for (int i = 1; i <= k; i++) {
            long current = prePrevious + previous;
            System.out.println(current);
            prePrevious = previous;
            previous = current;
        }
    }

    private static void recursiveFibonacci(int actual, int k, long prePrevious, long previous) {
        if(actual == k)
            return;
        
        long current = prePrevious + previous;
        System.out.println(current);
        recursiveFibonacci(actual+1, k, previous, current);
    }
}
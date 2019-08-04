package com.github.gabrielbb.algorithms;

public class NthFibonacci {

    public static long get(int n) {

        long last = 0;
        long current = 1;

        while(n > 1) {
            long newValue = current + last;
            last = current;
            current = newValue;
            
            n--;
        }

        return current;
    }
}
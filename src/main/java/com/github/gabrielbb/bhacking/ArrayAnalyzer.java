package com.github.gabrielbb.bhacking;

import java.util.*;

public class ArrayAnalyzer {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            int n = s.nextInt();
            int count = s.nextInt();
            boolean[] array = new boolean[n];

            while (count-- > 0) {
                int curr = s.nextInt();

                if (curr <= n) {
                    if (array[n - curr]) {
                        System.out.println("1");
                        return;
                    }

                    array[curr] = true;
                }

            }

            System.out.println("0");
        }
    }
}
package com.github.gabrielbb.bhacking;

import java.util.*;

public class DeltaEncoding {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int count = scanner.nextInt();
            scanner.nextLine();

            if(count == 0)
                return;

            int previous = scanner.nextInt();

            System.out.print(previous);

            if (count == 1)
                return;

            while(--count > 0) {
                int current = scanner.nextInt();
                int difference = current - previous;

                System.out.print(" ");

                if(difference < -127 || difference > 127) {
                    System.out.print(-128 + " ");
                }

                System.out.print(difference);

                previous = current;
            }

        }
    }
}
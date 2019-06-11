package com.github.gabrielbb.bhacking;

import java.util.*;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public final class Polygons {

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int squares = 0;
            int rectangles = 0;
            int other = 0;

            int lines = scanner.nextInt();
            scanner.nextLine();

            while (lines > 0) {
                int[] values = Stream.of(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

                if (values[0] == values[1] && values[1] == values[2] && values[2] == values[3]) {
                    squares++;
                } else if (values[0] == values[2] && values[1] == values[3]) {
                    rectangles++;
                } else {
                    other++;
                }

                lines--;
            }

            System.out.println(squares + " " + rectangles + " " + other);
        }
    }
}

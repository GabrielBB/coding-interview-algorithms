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

            int[][] polygons = new int[scanner.nextInt()][];
            scanner.nextLine();

            for (int i = 0; i < polygons.length; i++) {
                polygons[i] = Stream.of(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            printPolygons(polygons);
        }
    }

    private static void printPolygons(int[][] polygons) {
        int squares = 0;
        int rectangles = 0;
        int other = 0;

        for (int[] polygon : polygons) {
            if (polygon[0] == polygon[1] && polygon[1] == polygon[2] && polygon[2] == polygon[3]) {
                squares++;
            } else if (polygon[0] == polygon[2] && polygon[1] == polygon[3]) {
                rectangles++;
            } else {
                other++;
            }
        }

        System.out.println(squares + " " + rectangles + " " + other);
    }
}

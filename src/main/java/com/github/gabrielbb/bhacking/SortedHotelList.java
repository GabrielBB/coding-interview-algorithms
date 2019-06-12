package com.github.gabrielbb.bhacking;

import java.util.*;
import java.util.stream.*;

public class SortedHotelList {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            String words = s.nextLine();
            Set<String> keys = new HashSet<>();
            Stream.of(words.split(" ")).forEach(keys::add);

            int numberOfReviews = s.nextInt();

            while (numberOfReviews-- > 0) {

                int id = s.nextInt();
                String review = s.nextLine();

                String[] wordsToSearch = review.split("(?=[,.])|\\s+");
                int keysPerReview = 0;

                for (String word : wordsToSearch) {

                    if (!word.equals(".") && !word.equals(",") && !word.equals(" ")) {
                        if (keys.contains(word)) {
                            keysPerReview++;
                        }
                    }
                }

                
            }
        }
    }
}
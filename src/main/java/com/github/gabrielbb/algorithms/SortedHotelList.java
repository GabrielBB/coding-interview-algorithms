package com.github.gabrielbb.algorithms;

import java.util.*;
import java.util.stream.*;

public class SortedHotelList {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            String words = s.nextLine();
            Set<String> keys = new HashSet<>();
            Stream.of(words.split(" ")).forEach(keys::add);

            int numberOfReviews = s.nextInt();
            s.nextLine();

            Map<Integer, Integer> reviewsPerId = new HashMap<>();

            while (numberOfReviews-- > 0) {

                int id = s.nextInt();
                s.nextLine();
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

                Integer previousReviews = reviewsPerId.get(id);
                reviewsPerId.put(id, previousReviews == null ? keysPerReview : previousReviews + keysPerReview);
            }

            System.out.println(
                    reviewsPerId.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                            .map(e -> e.getKey().toString()).collect(Collectors.joining(" ")));
        }
    }
}
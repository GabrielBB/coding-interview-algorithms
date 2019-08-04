package com.github.gabrielbb.algorithms;

import java.util.*;

public class MutualAnagramsDetector {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int count = scanner.nextInt();

            if (count == 0)
                return;

            Map<String, Set<String>> map = new HashMap<>();

            while (count-- > 0) {
                String word = scanner.nextLine();
                String sortedWord = sortString(word).trim();

                Set<String> anagrams = map.get(sortedWord);

                if (anagrams == null) {
                    anagrams = new TreeSet<>();
                    map.put(sortedWord, anagrams);
                }

                anagrams.add(word);
            }

            Set<String> result = new TreeSet<>();
            map.values().forEach(a -> result.add(String.join(",", a)));
            result.forEach(System.out::println);
        }
    }

    private static String sortString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
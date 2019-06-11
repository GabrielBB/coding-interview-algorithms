package com.github.gabrielbb.bhacking;

import java.util.*;

public class MutualAnagramsDetector {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int count = scanner.nextInt();
            scanner.nextLine();

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

            Set<String> listOfAnagrams = new TreeSet<>();

            for (Set<String> anagrams : map.values()) {

                Iterator<String> iterator = anagrams.iterator();
                StringBuilder finalString = new StringBuilder();

                while (iterator.hasNext()) {
                    finalString.append(iterator.next());

                    if (iterator.hasNext()) {
                        finalString.append(',');
                    }
                }

                listOfAnagrams.add(finalString.toString());
            }

            for (String anagrams : listOfAnagrams) {
                System.out.println(anagrams);
            }
        }
    }

    private static String sortString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
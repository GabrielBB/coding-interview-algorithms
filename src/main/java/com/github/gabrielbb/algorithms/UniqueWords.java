package com.github.gabrielbb.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueWords {

    public static String[] getUniqueWords(String text) {

        String[] words = text.split("\\s|\\.|,");
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            if (!s.trim().isEmpty()) {
                Integer i = map.get(s);
                map.put(s, i == null ? 1 : i + 1);
            }
        }

        return map.entrySet().stream().filter(e -> e.getValue() == 1).map(Entry::getKey).toArray(String[]::new);
    }
}
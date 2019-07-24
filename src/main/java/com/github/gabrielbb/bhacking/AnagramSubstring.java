package com.github.gabrielbb.bhacking;

import java.util.Arrays;

public class AnagramSubstring {

    // Return index of the first anagram of $query in $s
    // 0(n)
    public static int get(String query, String s) {

        if (s.isEmpty() || query.isEmpty() || s.length() < query.length())
            return -1;

        var sChars = new int[26];
        var queryChars = new int[26];

        int i = 0;
        for (; i < query.length(); i++) {
            queryChars[query.charAt(i) - 'a']++;
            sChars[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sChars, queryChars))
            return 0;

        for (; i < s.length(); i++) {

            sChars[s.charAt(i - query.length()) - 'a']--;
            sChars[s.charAt(i) - 'a']++;

            if (Arrays.equals(sChars, queryChars))
                return i - (query.length() - 1);
        }

        return -1;
    }
}
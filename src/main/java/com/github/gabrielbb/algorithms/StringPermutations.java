package com.github.gabrielbb.algorithms;

public class StringPermutations {

    public static void main(String[] args) {
        printPermutations("abb", "");
        printPermutations("abb", 0);
    }

    // O(n! x n2)
    private static void printPermutations(String s, String res) {

        if (s.isEmpty())
            System.out.println(res);

        for (int i = 0; i < s.length(); i++) {
            printPermutations(s.substring(0, i) + s.substring(i + 1), res + s.charAt(i));
        }
    }

    // O(n! x n)
    private static void printPermutations(String s, int l) {

        if (l == s.length()) {
            System.out.println(s);
            return;
        }

        for (int i = l; i < s.length(); i++) {
            s = swap(s, l, i);
            printPermutations(s, l + 1);
            s = swap(s, l, i);
        }
    }

    private static String swap(String s, int i, int j) {

        char[] array = s.toCharArray();

        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return new String(array);
    }
}
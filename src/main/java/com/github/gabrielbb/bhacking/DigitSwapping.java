package com.github.gabrielbb.bhacking;

public class DigitSwapping {

    public static int swap(int num) {

        StringBuilder s = new StringBuilder(String.valueOf(num));

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char ic = s.charAt(i);
            char jc = s.charAt(j);

            if (jc > ic) {
                s.setCharAt(i, jc);
                s.setCharAt(j, ic);
                break;
            }

            j--;
        }

        return Integer.parseInt(s.toString());
    }
}
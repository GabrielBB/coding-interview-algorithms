package com.github.gabrielbb.bhacking;

import java.math.BigInteger;
import java.util.Scanner;

public class SeparateTheNumbers {

    private static void separateNumbers(String s) {

        if (s.length() <= 1 || s.startsWith("0") || !isValid(s, -1, 0, true)) {
            System.out.println("NO");
        }
    }

    private static boolean isValid(String s, int from, int to, boolean start) {

        BigInteger prefixN = to == 0 ? BigInteger.ZERO : new BigInteger(s.substring(from, to));

        for (int i = to; i < s.length(); i++) {

            if (i < s.length() - 1 && s.charAt(i + 1) == '0')
                continue;

            BigInteger newNum = new BigInteger(s.substring(to, i + 1));

            if (start || newNum.subtract(prefixN).intValue() == 1) {
                if(!start && i + 1 == s.length())
                    return true;
                
                if (isValid(s, to, i + 1, false)) {
                    if (start) {
                        System.out.println("YES " + String.valueOf(newNum));
                    }

                    return true;
                }
            } else if (newNum.compareTo(prefixN) > 0) {
                break;
            }
        }

        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}

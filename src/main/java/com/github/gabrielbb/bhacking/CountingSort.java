package com.github.gabrielbb.bhacking;

import java.io.IOException;
import java.util.Scanner;

public class CountingSort {

    static int activityNotifications(int[] expenditure, int d) {

        int notifications = 0;
        int[] spendingData = new int[200];

        for (int i = 0; i < expenditure.length; i++) {

            if (i >= d) {
                double median = getMedian(spendingData, d);
                // System.out.println(median);
                if (expenditure[i] >= median * 2) {
                    notifications++;
                }

                spendingData[expenditure[i - d]]--;
            }

            spendingData[expenditure[i]]++;
        }

        return notifications;
    }

    private static double getMedian(int[] spendings, int d) {
        double lastNumber = 0;
        int count = 0;

        for (int i = 0; i < spendings.length; i++) {

            for (int x = 1; x <= spendings[i]; x++) {
                count++;

                if (count == d / 2 + 1) {
                    return d % 2 == 0 ? ((x > 1 ? i : lastNumber) + i) / 2 : i;
                }

                lastNumber = i;
            }
        }

        return -1;
    }

    private static final Scanner scanner = new Scanner(
            CountingSort.class.getClassLoader().getResourceAsStream("input01.txt"));

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println("Result = " + result);

        scanner.close();
    }
}

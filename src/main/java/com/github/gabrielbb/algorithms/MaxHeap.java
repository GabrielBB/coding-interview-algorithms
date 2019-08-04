package com.github.gabrielbb.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(2);
        queue.add(1);
        queue.add(-10);
        queue.add(45);
        queue.add(30);

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
package com.github.gabrielbb.bhacking;

import java.util.*;

public class MergeKSortedArrays {

    public static int[] merge(int[][] arrays) {

        int mergeLength = 0;

        for (int[] array : arrays) {
            mergeLength += array.length;
        }

        int[] merged = new int[mergeLength];
		int m = 0;
		int k = 0;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue();
		boolean added = true;
		
		while(added) {
			for(int[] array : arrays) {
				if(k < array.length)
					minHeap.add(array[k]);
			}
			
			
			
			k++;
		}
		
        return merged;
    }
}
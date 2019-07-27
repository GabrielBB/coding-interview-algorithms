package com.github.gabrielbb.bhacking;

public class FindSubstring {

	// Worst Case O(n2)
	public static int findSubstring(String sub, String s) {

		int subIndex = 0;
		int nextSearch = -1;

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == sub.charAt(subIndex)) {

				if (subIndex > 0 && nextSearch == -1 && s.charAt(i) == sub.charAt(0)) {
					nextSearch = i;
				}

				if (++subIndex == sub.length()) {
					return i - (sub.length() - 1);
				}
			} else if (subIndex > 0) {
				i = (nextSearch == -1 ? i : nextSearch);
				
				nextSearch = -1;
				subIndex = 0;
			}
		}

		return -1;
	}
}
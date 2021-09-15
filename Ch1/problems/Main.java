package problems;

import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
//		System.out.println(isUnique("EricThomaseh"));
//		System.out.println(isPermutation("AfSDsFAeSDf", "SDFDAASeffs"));
		System.out.println(urlify("Mr John Smith       ", 14));
	}
	
	/*
	 * Problem 1.1
	 * Write an algorithm to determine if a string has all unique characters
	 */
	static boolean isUnique(String s) {
		boolean[] characters = new boolean[128]; // ASCII
		for (int c : s.toCharArray()) {
			if (characters[c]) {
				return false;
			}
			characters[c] = true;
		}
		return true;
	}
	
	/*
	 * Problem 1.2
	 * Check to see if 2 strings are permutations of each other
	 */
	static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character, Integer> h = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (h.containsKey(c)) {
				int count = h.get(c);
				h.put(c, count + 1);
			} else {
				h.put(c, 1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (!h.containsKey(c)) {
				return false;
			} else {
				int count = h.get(c);
				if (count == 0) {
					return false;
				}
				h.put(c, count - 1);
			}
		}
		for (int i : h.values()) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Problem 1.3
	 * Write a method to replace all spaces in a string with $%20. You may assume
	 * string has sufficient space at the end to hold the additional characters and you are
	 * given the true length of the string.
	 */
	static String urlify(String s, int l) {
		char[] c = new char[s.length()];
		int newIndex = 0;
		for (int i = 0; i < l; i++) {
			if (s.charAt(i) != ' ') {
				c[newIndex] = s.charAt(i);
				newIndex++;
			} else { // space
				c[newIndex] = '%';
				c[newIndex + 1] = '2';
				c[newIndex + 2] = '0';
				newIndex += 3;
			}
		}
		return new String(c);
	}

}

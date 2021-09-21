package problems;

import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
//		System.out.println(isUnique("EricThomaseh"));
//		System.out.println(isPermutation("AfSDsFAeSDf", "SDFDAASeffs"));
//		System.out.println(urlify("Mr John Smith       ", 14));
//		System.out.println(isPermOfPalindrome("TAct 234634 Co32a"));
		System.out.println(oneOrLessEdits("pale", "ple"));
		System.out.println(oneOrLessEdits("pales", "pale"));
		System.out.println(oneOrLessEdits("pale", "bale"));
		System.out.println(oneOrLessEdits("pale", "bake"));
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
	
	/*
	 * Problem 1.4
	 * Write a method to determine if a given string is a permutation of
	 * a palindrome. Ignore casing and non-letters
	 * 
	 */
	
	static boolean isPermOfPalindrome(String s) {
		HashMap<Character, Integer> h = new HashMap<>();
		s = s.toLowerCase();
		int countOfCharacters = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				if (h.containsKey(c)) {
					int count = h.get(c);
					h.put(c, count + 1);
				} else {
					h.put(c, 1);
				}
				countOfCharacters++;
			}

		}
		
		if (countOfCharacters % 2 == 0) {
			for (int i : h.values()) {
				if (i % 2 != 0) {
					return false;
				}
			}
		} else {
			int countOfOdd = 0;
			for (int i : h.values()) {
				if (i % 2 != 0) {
					if (countOfOdd < 1) {
						countOfOdd = 1;
					} else {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	/*
	 * Problem 1.5
	 * There are 3 types of edits that can be performed on strings: insert a character,
	 * remove a character, or replace a character. given two strings, write a function to check if they are one edit (or zero edits) away
	 */
	
	static boolean oneOrLessEdits(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1) {
			return false;
		}
		HashMap<Character, Integer> sh = populateCharCount(s);
		HashMap<Character, Integer> th = populateCharCount(t);
		int differenceOfOne = 0; // We can have at most 2 of these and still be 1 edit away
		for (char c : sh.keySet()) {
			int difference = Math.abs(sh.getOrDefault(c, 0) - th.getOrDefault(c, 0));
			if (difference > 1) {
				return false;
			} else if (difference == 1) {
				if (differenceOfOne == 2) {
					return false;
				}
				differenceOfOne++;
			}
		}
		for (char c : th.keySet()) {
			int difference = Math.abs(sh.getOrDefault(c, 0) - th.getOrDefault(c, 0));
			if (difference > 1) {
				return false;
			} else if (difference == 1) {
				if (differenceOfOne == 2) {
					return false;
				}
				differenceOfOne++;
			}
		}
		return true;
	}
	
	static HashMap<Character, Integer> populateCharCount(String s){
		HashMap<Character, Integer> h = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (h.containsKey(c)) {
				int count = h.get(c);
				h.put(c, count + 1);
			} else {
				h.put(c, 1);
			}
		}
		return h;
	}

}

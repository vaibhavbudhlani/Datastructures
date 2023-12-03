package com.gs.practice;

public class DistBetweenTwoWords {

	// Input two words returns the shortest distance between their two midpoints in
	// number of characters
	// Words can appear multiple times in any order and should be case insensitive.

	// E.g. for the document="Example we just made up"
	// shortestDistance( document, "we", "just" ) == 4

	public static double shortestDistance(String document, String word1, String word2) {
		document = document.toLowerCase();
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();

		int sDist = Integer.MAX_VALUE;
//		String words[] = document.split("\\s+");
		String words[] = document.split("[[ ]*|[,]*|[\\.]*]");

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				System.out.println(words[i]);
				for (int j = 0; j < words.length; j++) {
					if (words[j].equals(word2)) {
						System.out.println(words[j]);

						int start = Math.min(i, j);
						int end = Math.max(i, j);
						int dist = end - start;
						dist += (word1.length() + word2.length()) / 2;
						for (int k = start + 1; k < end; k++) {
							dist += words[k].length();
						}
						sDist = Math.min(sDist, dist);
					}
				}
			}
		}
		System.out.println(sDist);

		return sDist;
	}

	public static boolean pass() {
		return shortestDistanceNew(document, "and", "graphic") == 6d &&
				shortestDistanceNew(document, "transfer", "it") == 14d
				&& shortestDistanceNew(document, "Design", "filler") == 25d;
	}

	public static double shortestDistanceNew(final String document, String word1, String word2) {
		final String[] words = document.split("[,. ]");

		int wordCount = 0;
		double wordOneCount = 0;
		double wordTwoCount = 0;
		double shortestDistance = Double.MAX_VALUE;
		for (String word : words) {
			if (word.equalsIgnoreCase(word1)) wordOneCount = wordCount + (word.length() / 2d);
			else if (word.equalsIgnoreCase(word2)) wordTwoCount = wordCount + (word.length() / 2d);

			if (wordOneCount > 0 && wordTwoCount > 0) {
				shortestDistance = Math.min(shortestDistance, Math.abs(wordTwoCount - wordOneCount));
			}

			wordCount += word.length() + 1;
		}

		System.out.printf("Word1 : %s, word2: %s, distance: %s%n", word1, word2, shortestDistance);

		return shortestDistance;
	}

	public static void main(String[] args) {
		if (pass()) {
			System.out.println("Pass");
		} else {
			System.out.println("Some Fail");
		}
	}

	private static final String document;
	static {
		StringBuffer sb = new StringBuffer();
		sb.append(
				"In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
		sb.append(
				" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
		sb.append(
				" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

		document = sb.toString();
	}
}

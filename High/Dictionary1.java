package com.gs.practice;// Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}

import java.util.*;

class Dictionary {
  private String[] entries;

  public Dictionary(String[] entries) {
    this.entries = entries;
  }

  public boolean contains(String word) {
    return Arrays.asList(entries).contains(word);
  }
}

public class Dictionary1 {

	public static HashMap<Character, Integer> getLetterCount(String s) {
		HashMap<Character, Integer> letterCount = new HashMap<>();
		for(Character c : s.toCharArray()) {
			if(letterCount.containsKey(c)) {
				letterCount.replace(c, letterCount.get(c) + 1);
			}
			else {
				letterCount.put(c, 1);
			}

		}
		return letterCount;
	}
  public static Set<String> longestWord(String letters, Dictionary dict) {
	HashMap<Character, Integer> letterCount = getLetterCount(letters);

	Set<String> result = new HashSet<String>();
	int maxLen = 0;
//    	for(String s : dict.entries) {
//		if(s.length() >= maxLen) {
//			if(isContains(getLetterCount(s), letterCount)) {
//				if(maxLen < s.length()) {
//					maxLen = s.length();
//					//empty the result
//				}
//				result.
//			}
//		}
//	}
    return result;
  }


    public static List<String> findLargestWords(String[] dict, String input) {
        List<String> dictionary = Arrays.asList(dict);
        Map<Character, Integer> inputFreqMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            inputFreqMap.put(c, inputFreqMap.getOrDefault(c, 0) + 1);
        }

        List<String> largestWords = new ArrayList<>();
        int maxLength = 0;

        for (String word : dictionary) {
            Map<Character, Integer> wordFreqMap = new HashMap<>();
            boolean canFormWord = true;

            for (char c : word.toCharArray()) {
                int inputCount = inputFreqMap.getOrDefault(c, 0);
                int wordCount = wordFreqMap.getOrDefault(c, 0);
                if (wordCount + 1 > inputCount) {
                    canFormWord = false;
                    break;
                }
                wordFreqMap.put(c, wordCount + 1);
            }

            if (canFormWord && word.length() >= maxLength) {
                if (word.length() > maxLength) {
                    largestWords.clear();
                }
                largestWords.add(word);
                maxLength = word.length();
            }
        }

        return largestWords;
    }


  public static boolean pass() {
//    Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});
//    boolean r = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
      System.out.println(findLargestWords(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana","elephant"},"ogtdes"));
    return true;
  }

  public static void main(String[] args) {
    if(pass()) {
      System.out.println("Pass");
    } else {
      System.err.println("Fails");
    }
  }
}
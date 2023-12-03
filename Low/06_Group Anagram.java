import java.util.*;
import java.util.stream.Collectors;

/*
 * This program prints set of anagrams together in given string 
 * 
 * eg. 
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

class GroupAnagram {
  
  static String input = "cat dog tac sat tas god dog";
  
  static void setOfAnagrams(String inputString){ 
    
    //your code goes here
	HashMap<String, ArrayList<String>>  ana = new HashMap<String, ArrayList<String>>();
	String[] words = inputString.split(" ");
	for(String w : words) {
		char[] wArr = w.toCharArray();
		Arrays.sort(wArr);
		String wSorted = new String(wArr);
		if(ana.containsKey(wSorted)) {
		}
		else {
			ana.put(wSorted, new ArrayList<>());
		}
		ana.get(wSorted).add(w);
	}
	for(String s: ana.keySet()) {
		if(ana.get(s).size() > 1) {
			for(String word: ana.get(s)) {
				System.out.print(word + " ");
			}
		}
	} 
  }




  public static void setOfAnagramsNew(String s){
	  Map<String, ArrayList<String>> hm = new HashMap<>();
	  //Stream.of(s.toCharArray()).filter(x-> x)

	  String[] words = s.split(" ");
	  for(String w:words){
		  char c[] = w.toCharArray();
		  Arrays.sort(c);
		  hm.computeIfAbsent(Arrays.toString(c), s1 -> new ArrayList<>()).add(w);
	  }
	  StringBuilder ans = new StringBuilder();
	  for(Map.Entry<String,ArrayList<String>> e : hm.entrySet()){
            for(String w:e.getValue()){
				ans.append(w).append(" ");
			}
	  }
	  System.out.println(ans.toString());



  }
  
  
  public static void main(String[] args) {
    
    String input = "cat dog tac sat tas god dog";
    //setOfAnagrams(input);
	  setOfAnagramsNew(input);

  }
}
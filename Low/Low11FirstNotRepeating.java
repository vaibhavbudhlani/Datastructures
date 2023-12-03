

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Low11FirstNotRepeating {

	  /**
	  * Finds the first character that does not repeat anywhere in the input string
	  * Given "apple", the answer is "a"
	  * Given "racecars", the answer is "e"
	  **/        
	  public static char findFirst(String input)

	  {
		  LinkedHashMap<Character, Boolean> linkedHashMap = input.chars().mapToObj(value -> (char) value).
				  collect(Collectors.toMap(character -> character, character -> true,
				  (aBoolean, aBoolean2) -> false, LinkedHashMap::new));
		 char vb=  linkedHashMap.entrySet().stream().filter(Map.Entry::getValue).
				 map(Map.Entry::getKey).findFirst().orElse('0');
		  System.out.println(vb);


		  HashMap <Character, Boolean> charMap = new HashMap<Character, Boolean>();
		for(int i = 0; i < input.length(); i++) {
			if(charMap.containsKey(input.charAt(i))) {
				charMap.replace(input.charAt(i), false);
			}
			else {
				charMap.put(input.charAt(i), true);
			}
		}
		for(int i = 0; i < input.length(); i++) {
			if(charMap.get(input.charAt(i))) {
				return input.charAt(i);
			}
			
		}
		return '0';
	  }

	  public static void main(String args[])
	  {

	    String[] inputs = {"apple","racecars", "ababdc","aaaa"};
	    char[] outputs = {'a', 'e', 'd','0' };

	    boolean result = true;
	    for(int i = 0; i < inputs.length; i++ )
	    {
	      result = result && findFirst(inputs[i]) == outputs[i];
	      if(!result)
	        System.out.println("Test failed for: " + inputs[i]);
	      else
	        System.out.println("Test passed for: " + inputs[i]);
	    }
	  }

	}


public class ATOI
{
  
   // Takes a string str and returns the int value represented by
    // the string. 
	//For example, atoi("42") returns 42.
  // abc43D  -- > 43 use characters.numeric
   
  public static int atoi(String str)
  {
  int result = 0;
  int strLength = str.length();

  for(int i = 0; i < strLength; i++)
  {

      char ch = str.charAt(i);

        int numericValue = Character.getNumericValue(ch);
    if(numericValue >= 1 && numericValue <=9) {
//        System.out.println(numericValue);
       result = result*10 + numericValue;
      }

  }

  return result;
  };

  public static boolean pass()
  {
  boolean result = true;
  result = result && (3 == 3);
  result = result && (1 != 2);

  return result;
  };

  public static void main(String[] args)
  {
    System.out.println(atoi("ab67c43"));
//  if(pass())
//  {
//    System.out.println("Pass");
//  }
//  else
//  {
//    System.out.println("Some fail");
//  }
  }
}
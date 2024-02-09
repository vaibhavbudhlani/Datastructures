// Count length of Cycle
public class M16CountLengthOfCyclevb {

  /**
   *
   * You have an integer array.
   * Starting from arr[startIndex], follow each element to the index it points to. 
   * Continue to do this until you find a cycle. 
   * Return the length of the cycle. If no cycle is found return -1
   *
  */
	
	public static int findCount(int[] arr, int slow) {
		int loopLength = 1;
		int index = arr[slow];
		while(index != slow) {
			index = arr[index];
			loopLength++;
		}
		return loopLength;
	}
	
  public static int countLengthOfCycle( int[] arr, int startIndex ) {
	int slow = startIndex, fast = startIndex;
	int index = 0;
	while(index < arr.length) {
		index++;
		slow = arr[slow];
		fast = arr[arr[fast]];
		if(slow == fast) {
			return findCount(arr, slow);
		}
	} 	
  
  return -1;
  }


  public static void main( String[] args ) {

 boolean testsPassed = true;
  
  testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
  testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;
	  System.out.println(findCircle(new int[]{1, 0}, 0));
	  System.out.println(findCircle(new int[]{1, 2,0}, 0));
	  System.out.println(findCircle(new int[]{1, 4,0}, 0));
	  System.out.println(findCircle(new int[]{7}, 0));
	  System.out.println(findCircle(new int[]{0}, 0));
  if(testsPassed) {
    System.out.println( "Test passed." );
    //return true;
  } else {
    System.out.println( "Test failed." );
    //return false;
  }


  }

	public static int getLength(int[] arr, int startIndex) {
		if (arr == null || arr.length == 0)
			return -1;
		int count = 0;
		int fast = arr[arr[startIndex]];
		int slow = arr[startIndex];
		while (fast != slow) {
			if (fast >= arr.length)
				return -1;
			count++;
			fast = arr[arr[fast]];
			slow = arr[slow];
		}
		return count;
	}

	private static int findCircle(int[] nums, int start) {

		for(int i:nums){
			//System.out.println(i);
			if(i>nums.length){
				return -1;
			}
		}
		int s = nums[start];
		int f = nums[nums[start]];
		int sSoFar = 1;
		if(s == f)
			return -1;
		while(s!=f) {
			s = nums[s];
			sSoFar++;
			f = nums[nums[f]];
		}
		return sSoFar;
	}
}
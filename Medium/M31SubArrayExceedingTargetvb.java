// Continuos Subarray
// Subaaray sum should be less than target
public class M31SubArrayExceedingTargetvb
{
  public static int subArrayExceedsSum(int arr[], int target )
  {
  	int count = 0;
	int sum = 0;
	int n = arr.length;
	//ask if only +ve int
	if(arr.length == 0) { return -1;}
	int p = 0;
	int q = 1;
	sum = arr[p];
	while(q <= arr.length) {
		if(sum > target) {
			count = count + n - q + 1;
			if(p == 0) {count--;}
			sum -= arr[p];
			p++;
		} 
		else {
			if(q < arr.length) {
			sum += arr[q];
			}
			q++;
		}
	}
	if(count == 0) {
		return -1;
	}
	return count;
	
  }

  /**
   * Execution entry point.
  */
  public static void main(String[] args)
  {
   boolean result = true; 
  int[] arr = { 1, 2, 3, 4 };
  int n = arr.length;

  result = result && minSubArrayLen( arr, 6 ) == 2;
  result = result && minSubArrayLen( arr, 12 ) == -1;

	  System.out.println(minSubArrayLen( arr, 6 ));


  if( result )
  {
    System.out.println("All tests pass\n");
  }
  else
  {
    System.out.println("There are test failures\n");
  }
  }

	public static long kmin(int arr[],int n,int k)
	{
		int start = 0, end = 0, sum = arr[0], count = 0;
		while(start<n && end<n)
		{
			if(sum<=k)
			{
				end++;
				if(end>=start)
					count += end-start;
				if(end<n)
					sum += arr[end];
			}
			else
			{
				sum -= arr[start];
				start++;
			}
		}
		return count;
	}

	public static  int minSubArrayLen( int[] nums, int target) {
		int minLength = Integer.MAX_VALUE;
		int windowSum = 0;
		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
			windowSum += nums[windowEnd];

			while (windowSum >= target) {
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				windowSum -= nums[windowStart];
				windowStart++;
			}
		}

		return minLength != Integer.MAX_VALUE ? minLength : -1;
	}
};

// find the median of the two sorted arrays.
 // ex. {1, 3} and {2} is 2


public class MedianofSortedArrays
{

	public static int checkIfMedian(int n, int index) {
		if(index == (n-1)/2) {
			return 1;
		}
		if(n%2 == 0 && index == n/2) {
			return 1;
		}
		return -1;
	}

  public static double logic(int[] A, int[] B) {
  	int lenA = A.length;
	int lenB = B.length;
	int n = lenA + lenB;
	int indexA = 0;
 	int indexB = 0;
	int index = 0;
	int val;
	double median = -1;
	while(indexA < lenA && indexB < lenB) {
		if(A[indexA] < B[indexB]) {
			val = A[indexA];
			index++;
			indexA++;
		}
		else {
			val = B[indexB];
			index++;
			indexB++;
		}
		int temp = checkIfMedian(n, index-1);
		if(temp != -1) {
			median = (double) val;
			if(n%2 != 0) {
				return median;
			}
		}
	}

      return 1;
  }

  public static boolean pass()
  {
  boolean result = true;
  result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
  return result;
  };

	private static int medianOfSortedArrays(int a[], int b[]) {

		int n = a.length;
		int m = b.length;

		if (n > m) {
			medianOfSortedArrays(b, a);
		}
		int start = 0;
		int end = n;
		int tcount = m + n;
		int mid = (start + end + 1) / 2;

		while (start <= end) {
			int l = mid;
			int lb = n - mid;

			int l1 = l <= 0 ? Integer.MIN_VALUE : a[l - 1];
			int l2 = lb <= 0 ? Integer.MIN_VALUE : b[lb - 1];
			int r1 = l >= n - 1 ? Integer.MAX_VALUE : a[l + 1];
			int r2 = lb >= m - 1 ? Integer.MAX_VALUE : b[lb + 1];

			if (l1 < r2 && l2 < r2) {
				if (tcount % 2 == 1) {
					return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
				} else {
					return Math.max(l1, l2);
				}
			} else if (l1 > r2) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return 0;
	}

	static int Median(int[] A, int[] B)
	{
		int n = A.length;
		int m = B.length;
		if (n > m)
			return Median(B,
					A); // Swapping to make A smaller

		int start = 0;
		int end = n;
		int realmidinmergedarray = (n + m + 1) / 2;

		while (start <= end) {
			int mid = (start + end) / 2;
			int leftAsize = mid;
			int leftBsize = realmidinmergedarray - mid;
			int leftA
					= (leftAsize > 0)
					? A[leftAsize - 1]
					: Integer
					.MIN_VALUE; // checking overflow
			// of indices
			int leftB = (leftBsize > 0) ? B[leftBsize - 1]
					: Integer.MIN_VALUE;
			int rightA = (leftAsize < n)
					? A[leftAsize]
					: Integer.MAX_VALUE;
			int rightB = (leftBsize < m)
					? B[leftBsize]
					: Integer.MAX_VALUE;

			// if correct partition is done
			if (leftA <= rightB && leftB <= rightA) {
				if ((m + n) % 2 == 0)
					return (Math.max(leftA, leftB)
							+ Math.min(rightA, rightB))
							/ 2;
				return Math.max(leftA, leftB);
			}
			else if (leftA > rightB) {
				end = mid - 1;
			}
			else
				start = mid + 1;
		}
		return 0;
	}

	private void GetAnswerVaibhav(){
		int a[] = {1,3,5};
		int b[] = {-4,-3,8};

		int n = a.length;
		int m = b.length;
		int l=0;
		int r=0;
		int mid = 0;
		int mid1 = 0;
		int tlength = n + m;
		int count = (n+m)/2;


		if(tlength % 2 == 1){
			for(int i=0;i<=count;i++){
				if(l<n && r<m){
					mid = a[l] < b[r] ? a[l++] : b[r++];
				}
				else if(l<n){
					mid = a[l++];
				}
				else if(r<m){
					mid = b[r++];
				}
			}
		}

		if(tlength % 2 == 0){

			for(int i=0;i<=count;i++){
				mid1 = mid;
				if(l<n && r<m){
					mid = a[l] < b[r] ? a[l++] : b[r++];
				}
				else if(l<n){
					mid = a[l++];
				}
				else if(r<m){
					mid = b[r++];
				}
			}
			System.out.println("Mid is "+mid+" and mid1 is "+mid1);
			mid =  (mid + mid1) / 2;
		}
		System.out.println(mid);

	}



  public static void main(String[] args)
  {
	  //System.out.println(medianOfSortedArrays(new int[]{1,3},new int[]{2}));
	  System.out.println(Median(new int[]{1,3},new int[]{2}));
  }
}
import java.util.Arrays;
import java.util.List;

public class ThreeNumbersGreaterThanThreshhold {

    // a < b < c
    // a + b + c > t

    public static void main(String[] args) {
        List<Integer> ls = List.of(1,2,3,4,5);
        int a[] = {1,2,3,4,5};
        // 1 2 5
        // 1 3 4
        // 1 3 5
        // 1 4 5
        // 2 3 4
        // 2 3 5
        // 2 4 5
        // 3 4 5
        int t = 8;

        //System.out.println(calculateAns(ls,t,ls.size()-1));
        //System.out.println(countTriplets(ls,t,ls.size()-1));
        System.out.println(countTripletsfinal(a,t));

    }

    private static int calculateAns(List<Integer> ls, int t,int n) {
        int count = 0;

          for (int i=0;i<n-1;i++){
              int a = i;
              if(ls.get(a) > t){
                  return 0;
              }
              int b = i+1;
              int c= n;
              while(b < c){
                  // 1 2 3 4 5
                  if((ls.get(a) +  ls.get(b) + ls.get(c)) >= t){
                      count++;
                      System.out.println("A is "+ls.get(a)+" B is "+ls.get(b)+" C is "+ls.get(c));
                      b++;
                  }
                  else{
                      c--;
                  }
              }
          }


          return count;
    }

    public static long countTriplets(List<Integer> numbers, int threshold, int n) {
        return numbers.stream()
                .sorted() // Sort the stream
                .mapToLong(a -> numbers.stream() // Inner stream for b
                        .skip(numbers.indexOf(a) + 1) // Skip elements before a
                        .filter(b -> a + b <= threshold) // Filter based on threshold
                        .count()) // Count valid triplets with current a
                .sum(); // Sum the count from each element
    }

    public static int countTriplets(int[] numbers, int threshold) {
        Arrays.sort(numbers); // Sort the list for efficient comparison
        int count = 0;
        for (int i = 0; i < numbers.length - 2; i++) {
            int a = numbers[i];
            if (a > threshold) { // Skip if a itself is greater than threshold
                continue;
            }
            int b = i + 1;
            int c = numbers.length - 1;
            while (b < c) {
                int sum = a + numbers[b] + numbers[c];
                if (sum > threshold) {
                    count++;
                    c--; // Decrement c to explore other triplets with current a and b
                } else {
                    b++; // Increment b to explore larger values for b
                }
            }
        }
        return count;
    }

    public static int countTripletsfinal(int[] arr, int threshold) {
        int n = arr.length;
        int count = 0;

        // Sort the array
        Arrays.sort(arr);

        // Iterate through the array to fix the first element
        for (int i = 0; i < n - 2; i++) {
            int a = arr[i];

            // Use two pointers to find valid b and c
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int b = arr[left];
                int c = arr[right];

                // Check if a < b < c and a + b + c >= threshold
                if (a + b + c >= threshold) {
                    // All combinations of (i, left, right) with right fixed are valid
                    count += (right - left);
                    right--; // Decrease the right pointer
                } else {
                    left++; // Increase the left pointer
                }
            }
        }

        return count;
    }


}

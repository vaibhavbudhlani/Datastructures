package SelfPractice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumbers {
    public static List<Integer> findMissingNumbers(int[] arr, int mean, int missing) {
        int totalSum = mean * (arr.length + missing); // Calculate the total sum based on mean

        int currentSum = 0;
        for (int num : arr) {
            currentSum += num;
        }

        int x = totalSum - currentSum;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < missing; i++) {
            if (x - i >= i) {
                numbers.add(x);
                x -= i;
            }
        }



//        List<Integer> numbers = Arrays.stream(new int[missing])
//                .boxed()
//                .filter(i -> i + 1 <= x)
//                .map(i -> i + 1)
//                .collect(Collectors.toList());




        return numbers;
    }

    private static boolean contains(int[] arr, int num) {
        for (int n : arr) {
            if (n == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 3}; // Example array
        int mean = 4; // Example mean
        int missingCount = 2; // Example missing count

        List<Integer> missingNumbers = findMissingNumbers(arr, mean, missingCount);

        System.out.println("Missing numbers:");
        for (int num : missingNumbers) {
            System.out.println(num);
        }
    }
}


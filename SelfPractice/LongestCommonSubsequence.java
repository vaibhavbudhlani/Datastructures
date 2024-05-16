package SelfPractice;

import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        List<String> ls = Arrays.asList("I","Am","Vaibhav","Budlani");
        List<Integer> ls1 = Arrays.asList(1,2,34,5);
        ls.sort(String::compareToIgnoreCase);
       // ls.stream().sorted((o1, o2) -> o1.compareToIgnoreCase(o2)).forEach(System.out::println);

        int[] subjects = {4, 1, 2};
        int[] students = {5, 3};
        Arrays.sort(subjects);
        System.out.println(Arrays.binarySearch(subjects,3));

        int pairs = countPairsNew(subjects, students);
        System.out.println("Number of pairs of students and subjects: " + pairs);
        int[][] dp = new int[s1.length()][s2.length()];

        for(int[] row :dp){
            Arrays.fill(row,-1);
        }

      //  System.out.println(lcs(s1,s2,s1.length(),s2.length(),dp));
    }

    public static int lcs(String s1, String s2,int n,int m,int[][] dp){
        if(n==0  || m == 0){
            return 0;
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){

            return dp[n][m] =  1 + lcs(s1,s2,n-1,m-1,dp);
        }
        else{
            return Math.max(lcs(s1,s2,n-1,m,dp),lcs(s1,s2,n,m-1,dp));
        }

    }

    public static int countPairs(int[] subjects, int[] students) {
        Arrays.sort(subjects);
        Arrays.sort(students);
        int pairs = 0;
        int subjectIndex = 0;

        for (int i=0;i< students.length;i++) {

            while (subjectIndex < subjects.length && subjects[subjectIndex] <= students[i]) {
                pairs++; // Increment pairs for each subject the student can select
                subjectIndex++;
            }
            if(i != students.length-1){
                pairs *= (i + 2);
            }

        }

        return pairs;
    }

    public static int countPairsNew(int[] subjects, int[] students) {
        // Sort the subjects and students in ascending order
       // subjects.sort(Integer::compareTo);
        Arrays.sort(subjects);
        Arrays.sort(students);
      //  students.sort(Integer::compareTo);

        // Initialize the count of pairs
        int count = 0;

        // Iterate over the students
        for (int student : students) {
            // Find the index of the first subject that the student cannot take
            int index = Arrays.binarySearch(subjects, student+1 );

            // If the index is negative, then the student can take all the subjects
            if (index < 0) {
                //index *= -1;
                count += subjects.length;
            } else {
                // The student can take all the subjects up to the index
                count += index;
            }

        }

        return count;
    }
}

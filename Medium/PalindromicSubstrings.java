import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {

    public static Set<String> findAllPalindromicSubstrings(String s) {
        Set<String> palindromes = new HashSet<>();

        // Expand around center technique of Manacher's Algorithm
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome with center i
            expandPalindrome(s, i, i, palindromes);
            // Even length palindrome with center i and i+1
            expandPalindrome(s, i, i + 1, palindromes);
        }

        return palindromes;
    }

    private static void expandPalindrome(String s, int left, int right, Set<String> palindromes) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindromes.add(s.substring(left, right + 1));
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String str = "abcbad";
        Set<String> palindromes = findAllPalindromicSubstrings(str);
        System.out.println("Distinct palindromic substrings:");
        for (String palindrome : palindromes) {
            System.out.println(palindrome);
        }
    }
}

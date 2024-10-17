package school.faang.streamapithree;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumbersFinder {

    public static List<Integer> findPalindromesInRange(int start, int end) {
        List<Integer> palindromes = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (isPalindrome(i)) {
                palindromes.add(i);
            }
        }
        return palindromes;
    }

    private static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}


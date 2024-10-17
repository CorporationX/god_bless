package school.faang.streamapithree;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubstringFinder {

    public static List<String> findPalindromicSubstrings(String input) {
        List<String> palindromicSubstrings = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            findPalindromes(input, i, i, palindromicSubstrings);
            findPalindromes(input, i, i + 1, palindromicSubstrings);
        }

        return palindromicSubstrings;
    }

    private static void findPalindromes(String str, int left, int right, List<String> result) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            result.add(str.substring(left, right + 1));
            left--;
            right++;
        }
    }
}

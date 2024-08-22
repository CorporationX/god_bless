package faang.school.godbless;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromeSubstrings {
    public static List<String> findPalindromesSubstrings(String stringPol) {
        return IntStream.range(0, stringPol.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, stringPol.length() + 1)
                .mapToObj(j -> stringPol.substring(i, j)))
                .filter(PalindromeSubstrings::isPalindrome)
                .distinct()
                .collect(Collectors.toList());
    }
    private static boolean isPalindrome(String s) {
        return IntStream.range(0, s.length() / 2)
                .allMatch(i -> s.charAt(i) == s.charAt(s.length() - i - 1));
    }
}
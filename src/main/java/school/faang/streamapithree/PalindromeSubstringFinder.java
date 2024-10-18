package school.faang.streamapithree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PalindromeSubstringFinder {

    public static List<String> findPalindromicSubstrings(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(i -> Stream.concat(
                        findPalindromes(input, i, i).stream(),
                        findPalindromes(input, i, i + 1).stream()
                ))
                .collect(Collectors.toList());
    }

    private static List<String> findPalindromes(String str, int left, int right) {
        List<String> result = new ArrayList<>();
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            result.add(str.substring(left, right + 1));
            left--;
            right++;
        }
        return result;
    }
}
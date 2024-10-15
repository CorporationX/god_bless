package school.faang.palindromes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class PalindromeService {
    public static List<Integer> getPalindromicNumbers(int fromNumber, int toNumber) {
        List<Integer> numbers = IntStream.range(fromNumber, toNumber)
                .boxed()
                .toList();
        return numbers.stream()
                .map(String::valueOf)
                .filter(num -> num.equals(revertString(num)))
                .map(Integer::parseInt)
                .toList();
    }

    public static Set<String> getPalindromicStrings(String phrase) {
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < phrase.length(); i++) {
            for (int j = i + 1; j <= phrase.length(); j++) {
                String substring = phrase.substring(i, j);
                if (substring.equals(revertString(substring))) {
                    strings.add(substring);
                }
            }
        }
        return strings;
    }

    private static String revertString(String string) {
        return string.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
    }
}

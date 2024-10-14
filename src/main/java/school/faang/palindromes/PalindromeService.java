package school.faang.palindromes;

import java.util.List;
import java.util.stream.IntStream;

public class PalindromeService {
    private static String revertString(String string) {
        return string.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s,c) -> c+s, (s1, s2) -> s2+s1);
    }

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

//    public static List<String> getPalindromicStrings(String phrase) {
//
//    }
}

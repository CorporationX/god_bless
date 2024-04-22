package faang.school.godbless.StreameAPI_2;

import java.util.List;
import java.util.stream.IntStream;

public class Palindrome {
    public static List<Integer> findPalindrome(int startOfRange, int endOfRange) {
        return IntStream.range(startOfRange, endOfRange)
                .filter(num -> String.valueOf(num).contentEquals(new StringBuilder(String.valueOf(num)).reverse()))
                .boxed()
                .toList();
    }
}

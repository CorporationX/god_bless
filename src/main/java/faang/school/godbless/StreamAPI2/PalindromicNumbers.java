package faang.school.godbless.StreamAPI2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromicNumbers {
    public static List<Integer> findPalindromicNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(PalindromicNumbers::isPalindrome)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}

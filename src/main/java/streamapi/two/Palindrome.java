package streamapi.two;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Palindrome {

    public static boolean isPalindrome(int x) {
        String numberStr = Integer.toString(x);
        return numberStr.equals(new StringBuilder(numberStr).reverse().toString());
    }

    public static List<Integer> findPalindromeInRange(int start, int end) {

        return IntStream.range(start, end).filter(Palindrome::isPalindrome).boxed()
                .collect(Collectors.toList());
    }
}

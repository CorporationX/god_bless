package faang.school.godbless;

import java.util.List;
import java.util.stream.Stream;

public class Palindrome {
    public static void main(String[] args) {
        List<Integer> palindrom = allPalindromes(10, 10000);
        palindrom.forEach(System.out::println);
    }
    public static List<Integer> allPalindromes(int lowerBand, int upperBand) {
        return Stream.iterate(lowerBand, n -> n+ 1).limit(upperBand-lowerBand)
                .filter(value -> isPalindrome(value))
                .toList();
    }
    private static boolean isPalindrome(int value) {
        int reverse = 0;
        int number = value;
        if (number < 0) return false;
        while (number > 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number = number / 10;
        }
        return value == reverse;
    }
}

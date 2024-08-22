package faang.school.godbless;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Palindrome {
    public static List<Integer> findPolindromes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> {
                    String str = Integer.toString(number);
                    String reversedStr = new StringBuilder(str).reverse().toString();
                    return str.equals(reversedStr);
                })
                .boxed()
                .collect(Collectors.toList());
    }
}
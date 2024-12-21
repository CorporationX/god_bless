package school.faang.bjs246781;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Operations {

    public List<String> findPalindromNumbers(int startNum, int endNum) {

        return IntStream.rangeClosed(startNum, endNum)
                .mapToObj(String::valueOf)
                .filter(str -> str.contentEquals(new StringBuilder(str).reverse()))
                .toList();
    }

    public List<String> findPalindromSubstrings(String str) {

        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(start -> IntStream.rangeClosed(start + 1, str.length())
                        .mapToObj(end -> str.substring(start, end)))
                .filter(substring -> substring.contentEquals(new StringBuilder(substring).reverse()))
                .distinct()
                .toList();
    }


    public List<Integer> findPerfectNumbers(int startNum, int endNum) {

        return IntStream.rangeClosed(startNum, endNum)
                .filter(num -> Objects.equals(num,
                        IntStream.range(1, num)
                                .filter(div -> num % div == 0)
                                .sum())).boxed()
                .toList();
    }
}
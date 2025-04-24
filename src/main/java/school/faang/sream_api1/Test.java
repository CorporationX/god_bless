package school.faang.sream_api1;

import java.util.List;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        List<Integer> nums = IntStream.rangeClosed(1, 15).boxed().toList();
        System.out.println("Сумма чётных: " +
                StreamMethods.evenNumberSum(nums));

        System.out.println("Максимум: " +
                StreamMethods.foundMaxNumber(nums));

        System.out.println("Среднее: " +
                StreamMethods.foundMediumNumber(List.of(1, 2, 3)));

        List<String> words = List.of("apple", "banana", "orange");
        System.out.println("Строк на 'a': " +
                StreamMethods.stringNumber(words, 'a'));
    }
}

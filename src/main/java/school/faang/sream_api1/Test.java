package school.faang.sream_api1;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.println("Сумма чётных (1,2,3,4): " +
                StreamMethods.evenNumberSum(nums));

        System.out.println("Максимум (1,2,3,4): " +
                StreamMethods.foundMaxNumber(nums));

        System.out.println("Среднее (1,2,3): " +
                StreamMethods.foundMediumNumber(List.of(1, 2, 3)));

        List<String> words = List.of("apple", "banana", "orange");
        System.out.println("Строк на 'a': " +
                StreamMethods.stringNumber(words, 'a'));
    }
}

package school.faang.StreamAPI;

import java.util.List;

public class ListOperations {
    /*1*/
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        chekNumbers(numbers);
        return numbers.stream()
                .filter(y -> y % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /*2*/
    public static int maxNumbers(List<Integer> numbers) {
        chekNumbers(numbers);
        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    /*3*/
    public static double findAverage(List<Integer> numbers) {
        chekNumbers(numbers);
        return numbers.stream()
                .mapToDouble((i -> i))
                .average()
                .orElse(0.0);
    }

    /*4*/
    public static long countStringsStartingWith(List<String> strings, char А) {
        return strings.stream()
                .filter(s -> !s.isEmpty()
                        && ((s.charAt(0) >= '\u0410' && s.charAt(0) <= '\u042F')
                        || ((s.charAt(0) >= '\u0430' && s.charAt(0) <= '\u044F'))))
                .count();
    }
    /*5*/


    public static void chekNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым или null");
        }
    }
}
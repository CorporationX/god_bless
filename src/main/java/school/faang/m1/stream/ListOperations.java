package school.faang.m1.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
    public static Integer sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static Optional<Integer> sumOfEvenNumbersOptional(List<Integer> numbers) {
        return numbers.stream().reduce(Integer::sum);
    }

    public static Integer findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElse(0);
    }

    public static Double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    private static String countStringsStartingWith(List<String> strings, char a) {
        return strings.stream().filter(s -> s.charAt(0) == a).count() + " strings starting with " + a;
    }

    private static String filterStringsContainingSubstring(List<String> strings, String an) {
        return strings.stream().filter(s -> s.contains(an)).count() + " strings containing " + an + " substring";
    }

    private static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    private static String allMatchCondition(List<Integer> numbers, Predicate<Integer> a) {
        return numbers.stream().allMatch(a) ? "yes" : "no";
    }

    private static Integer findMinGreaterThan(List<Integer> numbers, int i) {
        return numbers.stream().filter(n -> n > i).min(Integer::compareTo).orElse(0);
    }

    private static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Сумма четных чисел: Optional" + ListOperations.sumOfEvenNumbersOptional(numbers));
        System.out.println("Максимум: " + ListOperations.findMax(numbers));
        System.out.println("Среднее: " + ListOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? "
                + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }

}
package school.faang_sprint_2.training_stream_api_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.findMax(numbers));
        System.out.println("Среднее: " + ListOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }

    private static class ListOperations {

        public static int sumOfEvenNumbers(List<Integer> numbers) {
            return numbers.stream()
                    .reduce(0, Integer::sum);
        }

        public static int findMax(List<Integer> numbers) {
            return numbers.stream()
                    .max(Integer::compareTo).orElseThrow();
        }

        public static double findAverage(List<Integer> numbers) {
            return (double) numbers.stream()
                    .reduce(0, Integer::sum) / numbers.size();
        }

        public static int countStringsStartingWith(List<String> strings, char a) {
            return (int) strings.stream()
                    .filter(string -> string.startsWith(String.valueOf(a))).count();
        }

        public static List<String> filterStringsContainingSubstring(List<String> strings, String an) {
            return strings.stream()
                    .filter(string -> string.contains(an)).toList();
        }

        public static List<String> sortByLength(List<String> strings) {
            return strings.stream()
                    .sorted(Comparator.comparing(String::length)).toList();
        }

        public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
            return numbers.stream()
                    .allMatch(predicate);
        }

        public static int findMinGreaterThan(List<Integer> numbers, int givenNumber) {
            return numbers.stream()
                    .filter(number -> number > givenNumber)
                    .min(Integer::compareTo)
                    .orElseThrow();
        }

        public static List<Integer> convertToLengths(List<String> strings) {
            return strings.stream()
                    .map(String::length)
                    .toList();
        }
    }
}

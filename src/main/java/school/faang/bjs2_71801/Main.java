package school.faang.bjs2_71801;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<String> strings = List.of("44444", "3432", "444", "05");
        List<Integer> numbers = Operations.transform(strings);
        System.out.println(numbers);
        System.out.println(Operations.evenSum(numbers));
        System.out.println(Operations.max(numbers));
        System.out.println(Operations.average(numbers));
        System.out.println(Operations.startsWithLetter(strings, '0'));
        System.out.println(Operations.containString(strings, "4444"));
        System.out.println(Operations.sortByLength(strings));
        System.out.println(Operations.findLowest(numbers, 4));
    }

    public static class Operations {
        public static int evenSum(List<Integer> numbers) {
            return numbers.stream()
                    .filter(a -> a % 2 == 0)
                    .reduce(Integer::sum)
                    .orElseThrow(() -> new NoSuchElementException("Не найден подходящий элемент"));
        }

        public static int max(List<Integer> numbers) {
            return numbers.stream()
                    .max(Comparator.naturalOrder())
                    .orElseThrow(() -> new NoSuchElementException("Не найден подходящий элемент"));
        }

        public static double average(List<Integer> numbers) {
            return numbers.stream()
                    .mapToInt(a -> a)
                    .average()
                    .orElseThrow(() -> new NoSuchElementException("Не найдены подходящие элементы"));
        }

        public static long startsWithLetter(List<String> strings, char firstLetter) {
            return strings.stream()
                    .filter(s -> s.startsWith(String.valueOf(firstLetter)))
                    .toArray().length;
        }

        public static List<String> containString(List<String> strings, String subString) {
            return strings.stream()
                    .filter(s -> s.contains(subString))
                    .toList();
        }

        public static List<String> sortByLength(List<String> strings) {
            return strings.stream()
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toList();
        }

        public static int findLowest(List<Integer> numbers, int min) {
            return numbers.stream()
                    .filter(a -> a > min)
                    .min(Comparator.naturalOrder())
                    .orElseThrow(() -> new NoSuchElementException("Не найден подходящий элемент"));
        }

        public static List<Integer> transform(List<String> strings) {
            return strings.stream()
                    .map(String::length)
                    .toList();
        }
    }
}

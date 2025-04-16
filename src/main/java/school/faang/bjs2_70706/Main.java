package school.faang.bjs2_70706;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6);
        List<Integer> emptyList = new ArrayList<>();
        List<String> stringsWithNull = Arrays.asList(
            "apple", "banana", "cherry", "date", "", "animal", "island", "angle", null, "  "
        );
        List<String> strings = Arrays.asList(
            "apple", "banana", "cherry", "date", "", "animal", "island", "angle", "  "
        );

        // Пример использования методов:
        System.out.printf("Сумма четных чисел: %s\n", ListOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Максимум: %d\n", ListOperations.findMax(numbers));
        System.out.printf("Среднее: %s\n", ListOperations.findAverage(numbers));
        System.out.printf("Количество строк, начинающихся на 'a': %s\n",
            ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.printf("Строки, содержащие 'an': %s\n",
            ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.printf("Отсортированные по длине строки: %s\n", ListOperations.sortByLength(strings));
        System.out.printf("Все ли числа чётные? %s\n", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.printf("Все ли числа чётные? %s\n", ListOperations.allMatchCondition(evenNumbers, n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 4: %s\n", ListOperations.findMinGreaterThan(numbers, 4));
        System.out.printf("Длины строк: %s\n", ListOperations.convertToLengths(strings));
    }

    public static class ListOperations {

        private static boolean wordIsEmpty(String word) {
            return word == null || word.isBlank();
        }

        /**
         * Метод принимает список чисел и возвращает сумму всех чётных чисел.
         */
        public static int sumOfEvenNumbers(List<Integer> intList) {
            return intList.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
        }

        /**
         * Метод принимает список чисел и возвращать максимальное значение.
         */
        public static int findMax(List<Integer> intList) {
            return intList.stream()
                .max((o1, o2) -> o1 - o2)
                .orElseThrow(() -> new NoSuchElementException("Input list is empty"));
        }

        /**
         * Метод принимает список чисел и возвращать среднее арифметическое.
         */
        public static double findAverage(List<Integer> intList) {
            return intList.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);
        }

        /**
         * Метод принимает список строк и символ, возвращает количество строк, которые начинаются с символа,
         * указанного в параметре "startChar.
         */
        public static long countStringsStartingWith(List<String> words, char startChar) {
            return words.stream()
                .filter(word -> !wordIsEmpty(word) && word.charAt(0) == startChar)
                .count();
        }

        /**
         * Метод должен принимать список строк и подстроку, возвращать список строк, которые содержат подстроку,
         * указанную в параметре "searchString".
         */
        public static List<String> filterStringsContainingSubstring(List<String> words, String searchString) {
            return words.stream()
                .filter(word -> !wordIsEmpty(word) && word.contains(searchString))
                .toList();
        }

        /**
         * Метод должен принимать список строк и возвращать его отсортированным по длине строк.
         */
        public static List<String> sortByLength(List<String> words) {
            return words.stream()
                .sorted(Comparator.comparingInt(word -> {
                    if (word == null) {
                        return -1;
                    } else {
                        return word.length();
                    }
                }))
                .toList();
        }

        /**
         * Метод должен принимать список чисел и предикат, возвращать true, если все элементы
         * списка удовлетворяют условию.
         */
        public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> match) {
            return numbers.stream().allMatch(match);
        }

        /**
         * Метод должен принимать список чисел и значение, возвращать минимальное число из списка,
         * которое больше этого значения.
         * Например, для списка [10, 5, 20, 15, 3, 7] и порога 6, наименьший элемент, который больше 6, — это 7.
         */
        public static int findMinGreaterThan(List<Integer> numbers, int limit) {
            return numbers.stream()
                .filter(number -> number > limit)
                .min(Comparator.comparingInt(number -> number))
                .orElseThrow(
                    () -> new NoSuchElementException("there are no numbers that are greater than %d".formatted(limit))
                );
        }

        /**
         * Метод должен принимать список строк и возвращать список целых чисел, представляющих длину каждой строки.
         * Если внутри списка есть NULL, то поднимается NoSuchElementException
         */
        public static List<Integer> convertToLengths(List<String> words) {
            return words.stream()
                .peek(word -> {
                    if (word == null) {
                        throw new NoSuchElementException("list contains \"NULL\" string");
                    }
                })
                .map(String::length)
                .toList();
        }

    }

}

package faang.school.godbless.train_stream_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        System.out.println("Сумма чётных чисел: " + calculateSumOfEvenNumbers(numbers));

        System.out.println("Наибольшее число в списке: " + findMaxNumber(numbers));

        System.out.println("Среднее значение: " + calculateAverage(numbers));

        List<String> strings = Arrays.asList("Onboarding", "Stream", "Java", "Sql", "System", "Swimming");
        System.out.println("Слов на букву S: " + countWordsStartingWithS(strings));

        Predicate<String> containsIng = s -> s.contains("ing");
        System.out.println("Слова заканчивающиеся на ing: " + filterWordsEndingWith(strings, containsIng));

        System.out.println("Список слов по длине: " + sortWordsByLength(strings));

        System.out.println("Все ли слова начинаются на букву J: " + checkIfAllWordsStartWith(strings, "J"));
        List<String> names = Arrays.asList("Mark", "Mick", "Molly");
        System.out.println("Все ли имена начинаются на букву M: " + checkIfAllWordsStartWith(names,"M"));

        System.out.println("Минимальное число больше чем 8: " + findMinNumberGreaterThan(numbers, 8));

        System.out.println("Длины строк: " + getLengthsOfStrings(strings));
    }

    private static int calculateSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static Optional<Integer> findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare);
    }

    private static OptionalDouble calculateAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    private static long countWordsStartingWithS(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("S"))
                .count();
    }

    private static List<String> filterWordsEndingWith(List<String> strings, Predicate<String> predicate) {
        return strings.stream()
                .filter(predicate)
                .toList();
    }

    private static List<String> sortWordsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static boolean checkIfAllWordsStartWith(List<String> strings, String prefix) {
        return strings.stream()
                .allMatch(s -> s.startsWith(prefix));
    }

    private static OptionalInt findMinNumberGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold).
                mapToInt(Integer::intValue)
                .min();
    }

    private static List<Integer> getLengthsOfStrings(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}


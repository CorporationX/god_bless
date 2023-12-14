package faang.school.godbless.StreamAPI_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ManyMethods {
    public static int sumEvenNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

    }

    public static Integer maxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);

    }

    public static double averageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::intValue)
                .average()
                .orElse(0.0);

    }

    public static long quantityStringsWithSpecificCharacter(List<String> strings, char specificCharacter) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(specificCharacter)))
                .count();     //тут я сначала выбрал тип возвр. значения int, но потом узнал,что count() возвращает long
        // Не знаю, стоило ли для нашего примера приводить это дело к int,поэтому оставил так

    }

    public static List<String> stringsFilter(List<String> strings, String specialSubstring) {
        return strings.stream()
                .filter(string -> string.contains(specialSubstring))
                .collect(Collectors.toList());

    }

    public static List<String> stringsSorterByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static <T> boolean checkCondition(List<T> strings, Predicate<T> predicate) {
        return strings.stream()
                .allMatch(predicate);

    }

    public static int minThatBiggerThanSpecifiedNumber(List<Integer> numbers, Integer specialValue) {
        return numbers.stream()
                .filter(number -> number > specialValue)
                .min(Integer::compare)
                .orElse(0);

    }

    public static List<Integer> lengthsOfStrings(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());

    }
}

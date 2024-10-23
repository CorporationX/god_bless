package school.faang.bjs2_35668;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MathOperation {

    public static int processNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List cannot be empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List cannot be empty"));
    }

    public static int numbersOfCharacters(List<String> strings, char characters) {
        return (int) strings.stream()
                .filter(s -> s.charAt(0) == characters)
                .count();
   }

    public static List<String> filterList(List<String> strings, String subString) {


        return strings.stream()
                .filter(s -> s.toLowerCase().contains(subString.toLowerCase().trim()))
                .collect(Collectors.toList());

    }

    public static List<String> sortedList(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
    }

    public static boolean meetAllRequirements(List<Integer> requirements1, Predicate<Integer> requirements2) {
        return requirements1.stream().allMatch(requirements2);
    }

    public static int findMinNumber(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(n->n>value)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List cannot be empty"));
    }

    public static List<Integer> listLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

}

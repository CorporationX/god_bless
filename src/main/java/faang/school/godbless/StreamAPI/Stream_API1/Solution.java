package faang.school.godbless.StreamAPI.Stream_API1;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static int outputSumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int outputMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static double outputAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static long countLineStartingWith(List<String> strings, char prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(prefix)))
                .count();
    }

    public static List<String> filterStringWithValue (List<String> strings, String line) {
        return strings.stream()
                .filter(s -> s.contains(line))
                .collect(Collectors.toList());
    }

    public static List<String> sortLineLength (List<String> strings){
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .toList();
    }

    public static boolean checkingAllElementsForCondition (List<String> elements, char prefix){
        return elements.stream()
                .allMatch(element -> element.startsWith(String.valueOf(prefix)));
    }

    public static int findSmallNumberMoreN (List<Integer> listInt, Integer N){
        return listInt.stream()
                .filter(element -> element > N)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow();
    }

    public static List<Integer> stringToListLength (List<String> strings){
        return strings.stream()
                .map(String::length)
                .toList();
    }
}

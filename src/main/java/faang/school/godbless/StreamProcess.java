package faang.school.godbless;

import java.util.List;

public class StreamProcess {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static long countStringWithPrefix(List<String> strings, char prefix) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(prefix))).count();
    }

    public static List<String> filterStringBySubstring(List<String> strings, String subString) {
        return strings.stream().filter(s -> s.contains(subString)).toList();
    }

    public static List<String> sortStringByLength(List<String> strings) {
        return strings.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static boolean allElementsPredicate(List<Integer> numbers, int condition){
        return numbers.stream().allMatch(n -> n % 2 == 0);
    }

    public static int findSmallerNumber(List<Integer> numbers, int target){
        return numbers.stream().filter(n->n>target).min(Integer::compareTo).orElse(0);
    }

    public static List<Integer> convertStringsToLength(List<String> strings){
        return strings.stream().map(String::length).toList();
    }



}

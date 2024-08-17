package faang.school.godbless.stream1;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Stream1 {
    public static int getEvenSum(List<Integer> numbers){
        return numbers.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
    }
    public static Optional<Integer> getMax(List<Integer> numbers){
        return numbers.stream().max(Integer::compareTo);
    }
    public static int getMean(List<Integer> numbers){
        if (numbers.isEmpty()) throw new IllegalArgumentException();
        return numbers.stream().mapToInt(Integer::intValue).sum() / numbers.size();
    }
    public static long countStartsWith(List<String> strings, char character){
        return strings.stream().filter(str -> str.startsWith(String.valueOf(character))).count();
    }
    public static List<String> filterBySubstring
            (List<String> strings, String substring){
        return strings.stream().filter(str -> str.contains(substring)).toList();
    }
    public static List<String> sortByLength(List<String> strings){
        return strings.stream().sorted((s1,s2) -> s1.length() - s2.length()).toList();
    }
    public static <T> boolean allComply(List<T> items, Predicate<T> rule){
        return items.stream().allMatch(rule);
    }
    public static OptionalInt getSmallestBiggerThan(List<Integer> numbers, int than){
        return numbers.stream().filter(n -> n > than).mapToInt(Integer::intValue).min();
    }
    public static List<Integer> getLengths(List<String> strings){
        return strings.stream().map(String::length).toList();
    }
}

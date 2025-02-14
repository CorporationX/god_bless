package school.faang.practice_streamapi_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final String NULL_ERROR = "The argument cannot be null.";

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 5, 20, 15, 3, 7);
        List<String> stringList = Arrays.asList("Alice", "Bob", "David", "Anton", "Alex", "Boris", "Tom", "Alexey");
        logger.info("The list of number = {}", (intList));
        logger.info("The summa of number = {}", summList(intList));
        logger.info("The max of number = {}", maxInList(intList));
        logger.info("The average of number = {}", avgInList(intList));
        char symbol = 'A';
        logger.info("The count strings begin at char '{}' = {}", symbol, findCount(stringList, symbol));
        String substring = "Alex";
        logger.info("The list of strings that include a substring '{}': {}", substring,
                includeSubstring(stringList, substring));
        logger.info("The sorted list order by length: {}", lengthSortedList(stringList));
        logger.info("Do all the items in the list {} satisfy a certain condition? - {}",
                intList, isAllMatch(intList, i -> i > 5));
        logger.info("Min of numbers {} after filter: {}",
                intList, minOfFilterNumbers(intList, 6));
        logger.info("The list of Strings {} to list of Length: {}", stringList, mapStringList(stringList));
    }

    public static int summList(List<Integer> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().reduce(0, Integer::sum);
    }

    public static int maxInList(List<Integer> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("List required!"));
    }

    public static double avgInList(List<Integer> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().mapToInt(Integer::intValue).average().orElseThrow();
    }

    public static long findCount(List<String> list, char c) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().filter(i -> i.charAt(0) == c).count();
    }

    public static List<String> includeSubstring(List<String> list, String substring) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().filter(s -> s.indexOf(substring) >= 0).toList();
    }

    public static List<String> lengthSortedList(List<String> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static Boolean isAllMatch(List<Integer> list, Predicate<Integer> predicate) {
        Objects.requireNonNull(list, NULL_ERROR);
        Objects.requireNonNull(predicate, NULL_ERROR);
        return list.stream().allMatch(predicate);
    }

    public static int minOfFilterNumbers(List<Integer> list, int min) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().mapToInt(Integer::intValue).filter(i -> i > min).min().orElseThrow();
    }

    public static List<Integer> mapStringList(List<String> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().map(String::length).toList();
    }
}

package bjs2_2655;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        String[] cities = {"Таганрог", "Новороссийск", "Курск", "Тамбов", "Красноярск", "Новосибирск", "Новокузнецк", "Курган", "Екатеринбург", "Норильск", "Краснодар"};

        System.out.println(sumNumbers(numbers));
        System.out.println(maxNumber(numbers));
        System.out.println(averageNumber(numbers));
        System.out.println(countStringsWithStartingCharacter(cities, 'н'));
        System.out.println(filterStringsContainingSubstring(cities, "но"));
        System.out.println(sortLength(cities));
        System.out.println(checkAllElements(numbers, Objects::nonNull));
        Arrays.stream(sortLength(cities)).forEach(System.out::println);
        System.out.println(findSmallestElementGreaterThan(5, numbers));
        System.out.println(convertStringsToLengths(cities));
    }

    public static int sumNumbers(List<Integer> numbers) {
        return numbers.stream().filter(i -> i%2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static Integer maxNumber(List<Integer> numbers) {
        return numbers == null ? null : numbers.stream().max(Integer::compareTo).get();
    }

    public static Double averageNumber(List<Integer> numbers) {
        return numbers == null ? null : numbers.stream().mapToInt(e -> e).average().getAsDouble();
    }

    public static long countStringsWithStartingCharacter(String[] strings, char character) {
        return Arrays.stream(strings).filter(c -> c.toUpperCase().startsWith(String.valueOf(character).toUpperCase())).count();
    }

    public static List<String> filterStringsContainingSubstring(String[] strings, String substring) {
        return Arrays.stream(strings).filter(s -> s.toUpperCase().contains(substring.toUpperCase())).toList();
    }

    public static String[] sortLength(String[] cities) {
        Arrays.sort(cities, Comparator.comparingInt(String::length));
        return cities;
    }

    public static <T> boolean checkAllElements(List<T> list, Predicate<T> condition) {
        return list.stream().allMatch(condition);
    }

    public static Integer findSmallestElementGreaterThan(int number, List<Integer> numbers) {
        return numbers.stream().filter(n -> n > number)
                .min(Comparator.comparingInt(Integer::intValue))
                .orElse(null);
    }

    public static List<Integer> convertStringsToLengths(String[] strings) {
        return Arrays.stream(strings).map(s -> s.length()).toList();
    }
}

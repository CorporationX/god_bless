package faang.school.godbless;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 5, 6, 7, 2, 9);
        List<String> strings = Arrays.asList("Banana", "apple", "Blueberry", "cherry", "blackberry");

        int sumOfEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("The sum of even numbers is: " + sumOfEvenNumbers);

        Integer maxValue = numbers.stream()
                .max(Integer::compare)
                .orElse(null);
        System.out.println("The max value is: " + maxValue);

        double averageOfNumbers = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("The average of numbers is: " + averageOfNumbers);

        long stringsWithCommonLetter = strings.stream()
                .map(String::toLowerCase)
                .filter(str -> str.startsWith(String.valueOf('b')))
                .count();

        System.out.println(stringsWithCommonLetter);

        List<String> sorted = strings.stream()
                .filter(str -> str.contains("er"))
                .toList();

        System.out.println(sorted);

        List<String> sortedByLength = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println(sortedByLength);

        List<String> newList = strings.stream()
                .filter(str -> str.length() > 6)
                .toList();

        List<String> newList2 = strings.stream()
                .map(str -> str.replaceAll("r", "R"))
                .toList();

        System.out.println(newList);
        System.out.println(newList2);

        Integer minOfFour = numbers.stream()
                .filter(num -> num > 4)
                .min(Integer::compare)
                .orElseThrow();

        System.out.println("The min element of four is: " + minOfFour);

        List<Integer> list = strings.stream()
                .map(String::length)
                .toList();

        System.out.println(list);

    }

}

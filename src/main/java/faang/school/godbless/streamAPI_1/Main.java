package faang.school.godbless.streamAPI_1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 5, 7, 3, 7, 4, 5, 8, 12);
        List<String> strings = List.of("something else", "snow melted", "likely", "do not offend", "else");

        System.out.println("Summ of even numbers: " + sumOfEven(numbers));
        if (maxElement(numbers).isPresent()) {
            System.out.println("Max element: " + maxElement(numbers).get());
        }
        System.out.println("Average: " + average(numbers));
        System.out.println("Average (ver.2): " + average2(numbers));
        System.out.println("Amount string with `s`: " + countStringStartBy("s", strings));
        System.out.println("List of string with same word:");
        stringsWith("else", strings).forEach(System.out::println);
        System.out.println("List of string by length:");
        sortByLength(strings).forEach(System.out::println);
        System.out.println("All strings has sumbol 'e' - " + ifSymbolInAllString("e", strings));
        System.out.println(minButMoreThan(5, numbers));
        stringToLength(strings).forEach(s -> System.out.print(" " + s));
    }

    private static List<Integer> stringToLength(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }

    private static int minButMoreThan(int number, List<Integer> numbers) {
        return numbers.stream().sorted().filter(s -> s > number).findFirst().orElse(0);
    }

    private static Boolean ifSymbolInAllString(String symbol, List<String> strings) {
        return strings.stream().filter(s -> s.contains(symbol)).count() == strings.size();
    }

    private static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    private static List<String> stringsWith(String word, List<String> strings) {
        return strings.stream().filter(s -> s.contains(word)).toList();
    }

    private static long countStringStartBy(String symbol, List<String> strings) {
        return strings.stream().filter(s -> s.startsWith(symbol)).count();
    }

    private static double average(List<Integer> nums) {
        return (double) nums.stream().reduce(0, (sum, number) -> sum + number) / nums.size();
    }

    private static double average2(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    private static Optional<Integer> maxElement(List<Integer> nums) {
        return nums.stream().max(Comparator.naturalOrder());
    }

    private static int sumOfEven(List<Integer> nums) {
        return nums.stream().filter(number -> number % 2 == 0).reduce(0, (sum, number) -> sum + number);
    }
}

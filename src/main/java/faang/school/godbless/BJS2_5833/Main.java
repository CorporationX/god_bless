package faang.school.godbless.BJS2_5833;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("sumNumbers, exp 30");
        System.out.println(sumNumbers(numbers) + "\n");
        System.out.println("MaxNumber, exp 10");
        System.out.println(searchMaxNumber(numbers) + "\n");
        System.out.println("Average, exp 5.5");
        System.out.println(searchAverageNumber(numbers) + "\n");

        List<String> strings = List.of("weut", "weuijnioa", "qe", "weurttttq");
        System.out.println("countStringByPrefix, exp 3)");
        System.out.println(countFilterStringByPrefix(strings, "weu") + "\n");
        System.out.println("filterStringBySubstring, exp qwe, qwr (qw)");

        filterStringsBySubstring(strings, "weu").forEach(System.out::println);
        System.out.println();
        System.out.println("sortStringByLength, exp: qe, aweut, ijnioaweu, weurttttq");
        System.out.println(sortStringsByLength(strings));

        List<Integer> evenNumbers = List.of(2, 4, 6);
        List<Integer> nonEvenNumbers = List.of(1, 3, 5);
        System.out.println("predicateEvenNumbers, exp true");
        System.out.println(predicateNumbers(evenNumbers, i -> i % 2 == 0));
        System.out.println("predicateEvenNumbers, exp false");
        System.out.println(predicateNumbers(nonEvenNumbers, i -> i % 2 == 0));

        System.out.println("LowestElement, exp 8 (7)");
        System.out.println(findLowestElement(numbers, 7));

        System.out.println("stringToLength Test, exp 5 9 2 9");
        System.out.println(stringToLength(strings));
    }

    public static int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int searchMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public static double searchAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countFilterStringByPrefix(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(prefix))
                .count();
    }

    public static List<String> filterStringsBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean predicateNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findLowestElement(List<Integer> numbers, int minNumber) {
        return numbers.stream()
                .filter(n -> n > minNumber)
                .min(Integer::compare)
                .orElse(0);
    }

    public static List<Integer> stringToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}

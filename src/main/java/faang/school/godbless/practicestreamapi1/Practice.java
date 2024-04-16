package faang.school.godbless.practicestreamapi1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Practice {
    private static Optional<Integer> getSumOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter((n) -> n % 2 != 0)
                .reduce(Integer::sum);
    }

    private static Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo);
    }

    private static OptionalDouble getAvg(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    private static long countStringsBeginWith(List<String> strings, String prefix) {
        return strings.stream()
                .filter(str -> str.startsWith(prefix))
                .count();
    }

    private static List<String> getStringsBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    private static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static boolean isAllStringsLengthGreaterThanTwo(List<String> strings, Predicate<String> predicate) {
        return strings.stream()
                .allMatch(predicate);
    }

    private static Optional<Integer> findMinElementWhichGreaterThanPivot(List<Integer> numbers, int pivot) {
        return numbers.stream()
                .filter(n -> n > pivot)
                .min(Integer::compareTo);
    }

    private static List<Integer> mapStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

    public static void testNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        List<Integer> oddNumbers = List.of(1, 3, 5, 7, 9, 11, 13);
        List<Integer> evenNumbers = List.of(2, 4, 6, 8, 10, 12);
        List<Integer> emptyList = Collections.emptyList();
        // Test "getSumOfOddNumbers" -----------------------------------------------------------------------------------
        String message = "There no odd numbers";
        System.out.println("numbers ---------------------------------------------------------------------------------");
        getSumOfOddNumbers(numbers).ifPresentOrElse(System.out::println, () -> System.out.println(message));
        System.out.println("oddNumbers ------------------------------------------------------------------------------");
        getSumOfOddNumbers(oddNumbers).ifPresentOrElse(System.out::println, () -> System.out.println(message));
        System.out.println("evenNumbers -----------------------------------------------------------------------------");
        getSumOfOddNumbers(evenNumbers).ifPresentOrElse(System.out::println, () -> System.out.println(message));
        System.out.println("emptyList -------------------------------------------------------------------------------");
        getSumOfOddNumbers(emptyList).ifPresentOrElse(System.out::println, () -> System.out.println(message));

        // Test "findMax" ----------------------------------------------------------------------------------------------
        String messageForFindMax = "There no max";
        System.out.println("numbers ---------------------------------------------------------------------------------");
        findMax(numbers).ifPresentOrElse(System.out::println, () -> System.out.println(messageForFindMax));
        System.out.println("oddNumbers ------------------------------------------------------------------------------");
        findMax(oddNumbers).ifPresentOrElse(System.out::println, () -> System.out.println(messageForFindMax));
        System.out.println("evenNumbers -----------------------------------------------------------------------------");
        findMax(evenNumbers).ifPresentOrElse(System.out::println, () -> System.out.println(messageForFindMax));
        System.out.println("emptyList -------------------------------------------------------------------------------");
        getSumOfOddNumbers(emptyList).ifPresentOrElse(System.out::println, () -> System.out.println(messageForFindMax));

        // Test "getAvg" ----------------------------------------------------------------------------------------------

        String messageForGetAvg = "There no average";
        List<Integer> numbersForAvg = List.of(1, 1, 1, 1, 1, 1, 1, 100, 100, 100, 100, 100, 100);
        System.out.println("numbers ---------------------------------------------------------------------------------");
        getAvg(numbers).ifPresentOrElse(System.out::println, () -> System.out.println(messageForGetAvg));
        System.out.println("oddNumbers ------------------------------------------------------------------------------");
        getAvg(oddNumbers).ifPresentOrElse(System.out::println, () -> System.out.println(messageForGetAvg));
        System.out.println("evenNumbers -----------------------------------------------------------------------------");
        getAvg(evenNumbers).ifPresentOrElse(System.out::println, () -> System.out.println(messageForGetAvg));
        System.out.println("emptyList -------------------------------------------------------------------------------");
        getAvg(emptyList).ifPresentOrElse(System.out::println, () -> System.out.println(messageForGetAvg));
        System.out.println("numbersForAvg ---------------------------------------------------------------------------");
        getAvg(numbersForAvg).ifPresentOrElse(System.out::println, () -> System.out.println(messageForGetAvg));
    }

    public static void testStrings() {
        List<String> strings = List.of("abcdefg", "ab", "efg", "cba", "abc123");
        List<String> emptyList = Collections.emptyList();
        // Test "getSumOfOddNumbers" -----------------------------------------------------------------------------------
        System.out.println("strings ---------------------------------------------------------------------------------");
        System.out.println(countStringsBeginWith(strings, "ab"));
        System.out.println(countStringsBeginWith(strings, "cba"));
        System.out.println(countStringsBeginWith(strings, "abcdef"));
        System.out.println("emptyList -------------------------------------------------------------------------------");
        System.out.println(countStringsBeginWith(emptyList, "ab"));

        // Test "getStringsBySubstring" --------------------------------------------------------------------------------
        List<String> strings1 = List.of("abcdefg", "a______CD____b", "efgCD", "CDcba", "abCD123");
        List<String> emptyList1 = Collections.emptyList();

        List<String> result1 = getStringsBySubstring(strings1, "CD");
        List<String> result2 = getStringsBySubstring(emptyList1, "CD");
        System.out.println("strings1 --------------------------------------------------------------------------------");
        System.out.println(result1);
        System.out.println("emptyList -------------------------------------------------------------------------------");
        System.out.println(result2);
    }

    public static void testSortStringsByLength() {
        List<String> strings = List.of("123", "", "12345", "12", "123456", "1", "1234");
        // Test "sortStringsByLength" ----------------------------------------------------------------------------------
        System.out.println("strings ---------------------------------------------------------------------------------");
        System.out.println(sortStringsByLength(strings));
    }

    public static void testIsAllStringsLengthGreaterThanTwo() {
        List<String> strings = List.of("123", "123", "123", "123", "123");
        List<String> strings1 = List.of("12", "123", "12", "12", "12");
        List<String> strings2 = List.of("12", "123", "12", "123", "12");
        List<String> strings3 = List.of("12345", "123", "12345", "123456", "12");
        Predicate<String> lambda = str -> str.length() > 2;

        // Test "isAllStringsLengthGreaterThanTwo" ---------------------------------------------------------------------
        System.out.println("strings ---------------------------------------------------------------------------------");
        System.out.println(isAllStringsLengthGreaterThanTwo(strings, lambda));
        System.out.println("strings1 --------------------------------------------------------------------------------");
        System.out.println(isAllStringsLengthGreaterThanTwo(strings1, lambda));
        System.out.println("strings2 --------------------------------------------------------------------------------");
        System.out.println(isAllStringsLengthGreaterThanTwo(strings2, lambda));
        System.out.println("strings3 --------------------------------------------------------------------------------");
        System.out.println(isAllStringsLengthGreaterThanTwo(strings3, lambda));
    }

    public static void testFindMinElementWhichGreaterThanPivot() {
        List<Integer> numbers = List.of(15, 20, 43, 33, 99, 9);
        List<Integer> numbers1 = List.of(1, 1, 4, 94, 43, 43, 32);


        // Test "findMinElementWhichGreaterThanK" ----------------------------------------------------------------------
        String message = "There is no element greater than k";
        System.out.println("numbers ---------------------------------------------------------------------------------");
        findMinElementWhichGreaterThanPivot(numbers, 21).ifPresentOrElse(System.out::println,
                () -> System.out.println(message));
        System.out.println("numbers1 --------------------------------------------------------------------------------");
        findMinElementWhichGreaterThanPivot(numbers1, 140).ifPresentOrElse(System.out::println,
                () -> System.out.println(message));
    }

    public static void testMapStringsToLengths() {
        // Test "mapStringsToLengths" ----------------------------------------------------------------------------------
        List<String> strings1 = List.of("abcdefg", "a______CD____b", "efgCD", "CDcba", "abCD123");
        List<String> emptyList1 = Collections.emptyList();

        List<Integer> result1 = mapStringsToLengths(strings1);
        List<Integer> result2 = mapStringsToLengths(emptyList1);
        System.out.println("strings1 --------------------------------------------------------------------------------");
        System.out.println(result1);
        System.out.println("emptyList -------------------------------------------------------------------------------");
        System.out.println(result2);
    }


    public static void main(String[] args) {
        testNumbers();
        testStrings();
        testSortStringsByLength();
        testIsAllStringsLengthGreaterThanTwo();
        testFindMinElementWhichGreaterThanPivot();
        testMapStringsToLengths();
    }
}

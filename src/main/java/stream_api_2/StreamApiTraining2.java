package stream_api_2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiTraining2 {
    public static Map<Integer, Integer> findPairs(List<Integer> numbers, int target) {
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        Set<Integer> distinctSet = new HashSet<>(distinctNumbers);
        return distinctNumbers.stream()
                .filter(num -> distinctSet.contains(target - num))
                .collect(Collectors.toMap(num -> num, num -> target - num));
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortString(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // Task 4: Find pairs of people who are not friends but have friends in common.


    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.averagingDouble(Employee::salary)));
    }

    public static List<String> alphabetContains(List<String> list, String alphabet) {
        return list.stream()
                .filter(str -> Set.of(alphabet.split("")).containsAll(List.of(str.replaceAll(" ", "").split(""))))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromicNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(isPalindromeNumber())
                .boxed()
                .toList();
    }


    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(StreamApiTraining2::isPerfectNumber)
                .boxed()
                .toList();
    }

    private static boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    private static IntPredicate isPalindromeNumber() {
        return i -> String.valueOf(i).equals(new StringBuilder(String.valueOf(i)).reverse().toString());
    }
}

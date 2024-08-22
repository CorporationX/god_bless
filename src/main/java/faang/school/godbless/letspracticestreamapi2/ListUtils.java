package faang.school.godbless.letspracticestreamapi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListUtils {
    public static Set<List<Integer>> findPairsWithSum(List<Integer> numbers, int targetSum) {
        return numbers.stream()
                .filter(i -> numbers.contains(targetSum - i) && (targetSum - i != i))
                .map(i -> Arrays.asList(i, targetSum - i))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Set<List<String>> findNonFriendsWithCommonFriends(Map<String, List<String>> friendsMap) {
        return friendsMap.keySet().stream()
                .flatMap(person1 -> friendsMap.keySet().stream()
                        .filter(person2 -> !person1.equals(person2))
                        .filter(person2 -> !friendsMap.get(person1).contains(person2))
                        .filter(person2 -> friendsMap.get(person1).stream()
                                .anyMatch(friend -> friendsMap.get(person2).contains(friend)))
                        .map(person2 -> Stream.of(person1, person2).sorted().toList())
                )
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> calculateAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, Set<Character> alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(ch -> alphabet.contains((char) ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromesInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> isPalindrome(Integer.toString(num)))
                .boxed()
                .toList();
    }

    public static List<String> findPalindromeSubstrings(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, input.length() + 1)
                        .mapToObj(j -> input.substring(i, j))
                        .filter(ListUtils::isPalindrome))
                .distinct()
                .toList();
    }

    public static List<Integer> findPerfectNumbersInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(ListUtils::isPerfectNumber)
                .boxed()
                .toList();
    }

    private static boolean isPerfectNumber(int num) {
        int sum = IntStream.rangeClosed(1, num / 2)
                .filter(i -> num % i == 0)
                .sum();
        return sum == num;
    }

    private static boolean isPalindrome(String s) {
        return s.contentEquals(new StringBuilder(s).reverse());
    }
}
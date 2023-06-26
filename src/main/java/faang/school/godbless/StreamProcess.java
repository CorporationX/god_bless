package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamProcess {
    public static List<List<Integer>> findPairsWithSum(List<Integer> numbers, int targetSum) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return numbers.stream()
                .flatMap(num -> {
                    int diff = targetSum - num;
                    return uniqueNumbers.contains(diff) ? Stream.of(Arrays.asList(num, diff)) : Stream.empty();
                })
                .map(pair -> {
                    Collections.sort(pair);
                    return pair;
                })
                .collect(Collectors.toList());
    }

    public static List<String> sortCapitalByCountry(Map<String, String> capitals) {
        List<String> sortedCapitals = new ArrayList<>();

        capitals.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry -> sortedCapitals.add(entry.getValue()));
        return sortedCapitals;
    }

    public static List<String> filterAndSortStringsByChar(List<String> strings, char prefix) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(prefix)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> findNonFriendPairs(Map<String, List<String>> friendships) {
        List<String> people = new ArrayList<>(friendships.keySet());

        return people.stream()
                .flatMap(person1 -> people.stream()
                        .filter(person2 -> !person1.equals(person2))
                        .filter(person2 -> !friendships.get(person1).contains(person2))
                        .filter(person2 -> haveCommonFriends(person1, person2, friendships))
                        .map(person2 -> Arrays.asList(person1, person2).stream().sorted().collect(Collectors.toList())))
                .distinct()
                .collect(Collectors.toList());
    }

    private static boolean haveCommonFriends(String person1, String person2, Map<String, List<String>> friendships) {
        List<String> person1Friends = friendships.get(person1);
        List<String> person2Friends = friendships.get(person2);
        return person1Friends.stream().anyMatch(person2Friends::contains);
    }

    public static Map<String, Double> calculateAverageWageByDepartment(List<Employee> employees) {
        Map<String, List<Double>> departmentWageMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getWage, Collectors.toList())));

        Map<String, Double> averageWageMap = departmentWageMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));

        return averageWageMap;
    }

    public static List<String> filterAndSortAlphabeticStrings(List<String> strings, String alphabet) {
        return strings.stream().filter(s -> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> convertToBinaryList(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findPalindromeInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(StreamProcess::isPalindrome)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(int number) {
        int reversed = 0;
        int temp = number;

        while (temp != 0) {
            int remainder = temp % 10;
            reversed = reversed * 10 + remainder;
            temp /= 10;
        }

        return number == reversed;
    }

}

package faang.school.godbless.secondSprint.StreamAPI2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static Set<List<Integer>> findPairs(List<Integer> nums, int sum) {
        Set<Integer> numbers = new HashSet<>(nums);
        Set<List<Integer>> uniquePairs = new HashSet<>();

        Set<Integer> rightNumbers = numbers.stream()
                .map(num -> sum - num)
                .collect(Collectors.toSet());

        numbers.stream()
                .filter(num -> rightNumbers.contains(num) && (sum - num) > num)
                .forEach(num -> uniquePairs.add(List.of(num, sum - num)));

        return uniquePairs;
    }

    public static List<String> findCapitals(Map<String, String> countryCapitals) {
        return countryCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStringByChar(List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.charAt(0) == letter)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> findFamiliarPeople(Map<String, List<String>> friends) {
        List<List<String>> pairs = new ArrayList<>();

        friends.forEach((key, value) -> {
            friends.keySet().stream()
                    .filter(name -> !name.equals(key) && !value.contains(name) && friends.get(name).stream()
                            .anyMatch(value::contains))
                    .forEach(name -> {
                        if (!pairs.contains(List.of(name, key))) {
                            pairs.add(List.of(key, name));
                        }
                    });
        });
        return pairs;
    }

    public static Map<String, Double> findAvgSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterStringByAlphabet(List<String> strings, List<Character> alphabet) {
        return strings.stream()
                .filter(str-> str.matches("[a-zA-Z]+") && str.matches("["+alphabet+"]+"))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertNumsToStrings(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromeNums(int first, int last) {
        return IntStream.range(first, last)
                .filter(num -> {
                    String str = String.valueOf(num);
                    int left = 0;
                    int right = str.length() - 1;
                    while (left < right) {
                        if (str.charAt(left) != str.charAt(right)) {
                            return false;
                        }
                        left++;
                        right--;
                    }
                    return true;
                }).boxed()
                .toList();
    }
}

package faang.school.godbless.secondSprint.StreamAPI2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(findPairs(nums, 10));
        Map<String, String> capital = Map.of("B", "1", "A", "2");
        System.out.println(findCapitals(capital));
        Map<String, List<String>> friends = Map.of(
                "1", List.of("2", "3", "4"),
                "2", List.of("1"),
                "3", List.of("1"),
                "4", List.of("1")
        );
        System.out.println(findFamiliarPeople(friends));
    }

    public static List<List<Integer>> findPairs(List<Integer> nums, int sum) {
        List<List<Integer>> uniquePairs = new ArrayList<>();

        nums.forEach(num -> {
            int goodNumber = sum - num;
            if (nums.contains(goodNumber) && goodNumber < num) {
                uniquePairs.add(List.of(goodNumber, num));
            }
        });
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
                .filter(string -> {
                    for (int i = 0; i < string.length(); i++) {
                        if (!alphabet.contains(string.charAt(i))) {
                            return false;
                        }
                    }
                    return true;
                }).sorted(Comparator.comparing(String::length))
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
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(num).reverse();
                    return stringBuilder.toString().equals(String.valueOf(num));
                }).boxed()
                .toList();
    }
}

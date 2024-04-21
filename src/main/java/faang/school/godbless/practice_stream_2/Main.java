package faang.school.godbless.practice_stream_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
    }

    public static Set<List<Integer>> findUniquePairsEqualsK(List<Integer> nums, int k) {
        Set<List<Integer>> pairs = new HashSet<>();
        IntStream.range(0, nums.size())
                .forEach(i -> IntStream.range(0, nums.size())
                        .filter(j -> i != j && nums.get(i) + nums.get(j) == k)
                        .forEach(j -> pairs.add(
                                List.of(
                                        Math.max(nums.get(i), nums.get(j)),
                                        Math.min(nums.get(i), nums.get(j))
                                )
                        ))
                );
        return pairs;
    }

    public static List<String> findCapitalsBySortedCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> findStringsStartsWith(List<String> strings, char startWith) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startWith)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Set<List<String>> findPeopleByMutualFriends(Map<String, List<String>> people) {
        Set<List<String>> pairs = new HashSet<>();
        people.forEach((key1, value1) -> people.entrySet().stream()
                .filter(entry -> !people.get(key1).contains(entry.getKey()))
                .filter(entry  -> !people.get(entry.getKey()).contains(key1))
                .filter(entry -> !key1.equals(entry.getKey()))
                .filter(entry -> !Collections.disjoint(value1, entry.getValue()))
                .forEach(entry -> {
                    if (key1.compareTo(entry.getKey()) > 0) {
                        pairs.add(List.of(key1, entry.getKey()));
                    } else {
                        pairs.add(List.of(entry.getKey(), key1));
                    }
                }));
        return pairs;
    }

    public static Map<String, Double> findAvgSalaryInDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> findStringsContainsOnlyThisAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> Arrays.stream(s.split(""))
                        .allMatch(alphabet::contains))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertIntegerListToStringList(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findAllPalindromesInIntRange(int start, int end) {
        return IntStream.range(start, end)
                .filter(num -> String.valueOf(num).contentEquals(new StringBuilder(String.valueOf(num)).reverse()))
                .boxed()
                .toList();
    }

    public static Set<String> findAllPalindromesInString(String string) {
        Set<String> result = new HashSet<>();
        IntStream.range(0, string.length() + 1)
                .forEach(i -> IntStream.range(i + 1, string.length() + 1)
                        .filter(j -> string.substring(i, j).contentEquals(new StringBuilder(string.substring(i, j)).reverse()))
                        .forEach(j -> result.add(string.substring(i, j)))
                );
        return result;
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(i -> IntStream.range(1, i + 1).filter(j -> i % j == 0).sum() == i * 2)
                .boxed()
                .toList();
    }
}
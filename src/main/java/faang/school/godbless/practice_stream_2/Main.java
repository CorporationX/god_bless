package faang.school.godbless.practice_stream_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(findUniquePairsEqualsK(List.of(1, 9, 3, 6, 4, 5), 10));
        System.out.println(findCapitalsBySortedCountries(Map.of("Russia", "Moscow", "UK", "London")));
        System.out.println(findStringsStartsWith(List.of("text", "monkey", "micro", "delete", "numbers", "mouse"), 'm'));
        System.out.println(findPeopleByMutualFriends(Map.of(
                "Dima", List.of("Masha", "Danya"),
                "Andrew", List.of("Masha"),
                "Danya", List.of("Masha"),
                "Masha", List.of("Dima")
        )));
        System.out.println(findAvgSalaryInDepartments(List.of(
                new Employee("Dima", 20.0, "IT"),
                new Employee("Lena", 20.0, "Managers"),
                new Employee("Andrew", 12.0, "IT")
        )));
        System.out.println(findStringsContainsOnlyThisAlphabet(List.of("text", "monkey", "micro", "delete", "numbers", "mouse"), "txetmonkyicr"));
        System.out.println(convertIntegerListToStringList(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(findAllPalindromesInIntRange(1, 100));
        System.out.println(findAllPalindromesInString("toot"));
        System.out.println(findPerfectNumbers(1, 100));
    }

    public static Set<Pair<Integer>> findUniquePairsEqualsK(List<Integer> nums, int k) {
        Set<Pair<Integer>> pairs = new HashSet<>();
        IntStream.range(0, nums.size())
                .forEach(i -> IntStream.range(0, nums.size())
                        .filter(j -> i != j && nums.get(i) + nums.get(j) == k)
                        .forEach(j -> pairs.add(
                                new Pair<>(
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

    public static List<Pair<String>> findPeopleByMutualFriends(Map<String, List<String>> people) {
        List<Pair<String>> pairs = new ArrayList<>();
        people.forEach((key1, value1) -> people.entrySet().stream()
                .filter(entry -> !people.get(key1).contains(entry.getKey())
                        && !people.get(entry.getKey()).contains(key1)
                        && !people.get(key1).equals(people.get(entry.getKey())))
                .forEach(entry -> entry.getValue().stream()
                        .filter(value1::contains)
                        .forEach(e -> pairs.add(new Pair<>(key1, entry.getKey())))
                )
        );
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
                        .peek(j -> result.add(string.substring(i, j)))
                        .toArray()
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
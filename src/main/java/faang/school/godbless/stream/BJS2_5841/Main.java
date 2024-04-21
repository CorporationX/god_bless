package faang.school.godbless.stream.BJS2_5841;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unique number pairs with sum equals 6 = " + sumEquals(List.of(1, 2, 3, 4, 5, 6, 7), 6));

        Map<String, String> capitals = new HashMap<>();
        capitals.put("Ukraine", "Kiev");
        capitals.put("Washington", "USA");
        capitals.put("Nicosia", "Cyprus");
        capitals.put("London", "GB");
        System.out.println("Get Capitals By Sorted Countries = " + getCapitalsBySortedCountries(capitals));

        List<String> rows = List.of("one", "two", "three", "four", "something");
        System.out.println("Filter by starting letter t and sort: " + filterSortRowsByLength(rows, 't'));

        Map<String, List<String>> friendships = new HashMap<>();
        friendships.put("Vlad", List.of("Ross"));
        friendships.put("Ivan", List.of("Inna", "Alice"));
        friendships.put("Inna", List.of("Alice", "Eric"));
        friendships.put("Pavel", List.of("Vlad"));
        System.out.println("All Friend Of Friends = " + getAllFriendOfFriends(friendships));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Vladimir", 40000, "transport"));
        employees.add(new Employee("Pavel", 20000, "transport"));
        employees.add(new Employee("Maria", 60000, "economy"));
        employees.add(new Employee("Inna", 70000, "economy"));
        System.out.println(getAverageSalary(employees));

        List<String> words = List.of("apple", "banana", "123", "dog", "cat");
        System.out.println("Word Contains Letters:" + wordContainLetters(words, "abcdefghijklmnopqrstuvwxyz"));

        System.out.println(toBinaryString(List.of(5, 4, 3, 2, 1)));
        System.out.println(findPalindrome(List.of(353, 564, 999)));
    }

    public static Map<Integer, Integer> sumEquals(List<Integer> numbers, Integer sum) {
        Map<Integer, Integer> result = new HashMap<>();

        IntStream.range(0, numbers.size())
                .forEach(
                        range1 -> IntStream.range(range1 + 1, numbers.size()).
                                filter(range2 -> numbers.get(range2) + numbers.get(range1) == sum).
                                forEach(i -> result.put(numbers.get(i), numbers.get(range1)))
                );
        return result;
    }

    public static List<String> getCapitalsBySortedCountries(Map<String, String> capitals) {
        return capitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(String::compareTo))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterSortRowsByLength(List<String> rows, char letter) {
        return rows.stream()
                .filter(s -> s.startsWith(Character.toString(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static HashMap<String, String> getAllFriendOfFriends(Map<String, List<String>> friends) {
        HashMap<String, String> pairs = new HashMap<>();
        friends.forEach((key, value) ->
                friends.entrySet().stream() // Create first stream from the map
                        .filter(entry -> !key.equals(entry.getKey()) && !value.contains(entry.getKey())) // Filter stream to not have current name in another list
                        .forEach(
                                entry -> entry.getValue().stream() // Create stream from list of current name
                                .filter(value::contains) // Current list contains name from current stream
                                .forEach(friend -> pairs.put(key, entry.getKey())) // From filtered stream add connected friends
                        )
        );
        return pairs;
    }

    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream().collect(
                Collectors.groupingBy(Employee::getDivision, Collectors.averagingDouble(Employee::getSalary))
        );
    }

    public static List<String> wordContainLetters(List<String> words, String letters) {
        return words.stream()
                .filter(word -> Arrays.stream(letters.split("")).anyMatch(word::contains))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> toBinaryString(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findPalindrome(List<Integer> nums) {
        return nums.stream()
                .filter(
                        n -> new StringBuilder(n.toString())
                                .compareTo(new StringBuilder(n.toString()).reverse()) == 0
                )
                .toList();
    }
}

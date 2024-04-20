package BJS2_5544;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 1
        System.out.println(findUniquePairsSumTarget(List.of(1, 2, 3, 4, 5, 6, 7), 9));
        // 2
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("USA", "Washington");
        countriesAndCapitals.put("UK", "London");
        countriesAndCapitals.put("France", "Paris");
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("Italy", "Rome");
        System.out.println(sortedCountryByAlphabet(countriesAndCapitals));
        // 3
        System.out.println(filterStringWithCharAndFilterLength(List.of("ad", "bsd", "aewe", "ass"), 'a'));
        // 4
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Ilya", List.of("Sasha", "Yasha", "Nikita"));
        friends.put("Yasha", List.of("Ilya", "Danila"));
        friends.put("Dima", List.of("Ilya"));
        friends.put("Sasha", List.of("Maksim", "Denis", "Ilya"));
        findPeopleWhoHaveSimilarFriend(friends).forEach(System.out::println);
        // 5
        System.out.println(findAvgSalaryInUnit(List.of(
                new Employee("Oleg", 20000, "First"),
                new Employee("Dasha", 15000, "Second"),
                new Employee("Dima", 30000, "First"),
                new Employee("Maksim", 25000, "Third"),
                new Employee("Aleksander", 40000, "Second")
        )));
        // 6
        System.out.println(filterStringWithAlphabet(List.of("apple", "banana", "123", "dog", "cat"), "abcdefghijklmnopqrstuvwxyz".toCharArray()));
        // 7
        System.out.println(convertNumToBinaryString(List.of(1, 2, 3, 4, 5)));
        // 8
        System.out.println(palindromeInNumberRange(1, 100));
        // 10
        System.out.println(findPerfectNumbersInRange(1, 1000));
    }

    public static List<List<Integer>> findUniquePairsSumTarget(List<Integer> nums, int target) {
        List<List<Integer>> numbers = new ArrayList<>();
        IntStream.range(0, nums.size())
                .forEach(i -> IntStream.range(i + 1, nums.size())
                        .filter(j -> nums.get(i) + nums.get(j) == target)
                        .forEach(j -> numbers.add(List.of(nums.get(i), nums.get(j))))
                );
        return numbers;
    }

    public static List<String> sortedCountryByAlphabet(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStringWithCharAndFilterLength(List<String> strings, char ch) {
        return strings.stream()
                .filter(str -> str.startsWith(Character.toString(ch)))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static Set<List<String>> findPeopleWhoHaveSimilarFriend(Map<String, List<String>> friends) {
        Set<List<String>> similarFriend = new HashSet<>();
        friends.forEach(
                (key, val) -> friends.entrySet().stream()
                        .filter(friend -> !val.contains(friend.getKey()) && !key.equals(friend.getKey()))
                        .forEach(friend -> friend.getValue().stream()
                                .filter(val::contains)
                                .forEach(name -> {
                                    if (key.compareTo(friend.getKey()) > 0) {
                                        similarFriend.add(List.of(key, friend.getKey()));
                                    } else {
                                        similarFriend.add(List.of(friend.getKey(), key));
                                    }
                                }))
        );
        return similarFriend;
    }

    public static Map<String, Double> findAvgSalaryInUnit(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getUnit, Collectors.averagingInt(Employee::getSalary)));
    }

    public static List<String> filterStringWithAlphabet(List<String> strings, char[] alphabet) {
        return strings.stream()
                .filter(str -> str.chars().allMatch(c -> Arrays.binarySearch(alphabet, (char) c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertNumToBinaryString(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> palindromeInNumberRange(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(String::valueOf)
                .filter(num -> new StringBuilder(num).reverse().toString().equals(num))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPerfectNumbersInRange(int start, int end) {
        return IntStream.range(start, end)
                .filter(num -> IntStream.range(1, num)
                        .filter(div -> num % div == 0)
                        .sum() == num)
                .boxed()
                .collect(Collectors.toList());
    }
}

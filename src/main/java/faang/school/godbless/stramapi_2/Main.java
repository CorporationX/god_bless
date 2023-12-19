package faang.school.godbless.stramapi_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    // 1
    public static Map<Integer, Integer> getPairNumbers(List<Integer> nums, int sum) {
        Map<Integer, Integer> pairs = new HashMap<>();
        nums.stream().filter(num -> num < sum).forEach((x) -> {
            nums.stream().filter(y -> y == sum - x).forEach(pairNum -> {
                if (x != pairNum) {
                    pairs.put(x, pairNum);
                }
            });
        });
        return pairs;
    }

    // 2
    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).
                collect(Collectors.toList());
    }

    // 3
    public static List<String> filterAndSortString(List<String> strings, char a) {
        return strings.stream().filter(str -> str.startsWith(String.valueOf(a))).
                sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    }

    // 4
    public static Set<List<String>> getFriends(Map<String, List<String>> friends) {
        return friends.entrySet().stream().flatMap(f1 -> friends.entrySet().stream().
                filter(f2 -> !f1.getKey().equals(f2.getKey()) && !f1.getKey().contains(f2.getKey())).
                filter(f2 -> f2.getValue().stream().anyMatch(f1.getValue()::contains)).
                map(f2 -> List.of(f1.getKey(), f2.getKey()))).collect(Collectors.toSet());
    }

    // 5
    public static Map<String, Double> averageSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
    }

    // 6
    private static List<String> sortStringsByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.chars().allMatch(character -> alphabet.contains(String.valueOf((char) character))))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    // 7
    public static List<String> intToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    // 8
    public static int[] getPalindromes(int a, int b) {
        return IntStream.rangeClosed(a, b).
                filter(n -> n > 9).
                filter(x -> (String.valueOf(x).
                        contentEquals(new StringBuilder(String.valueOf(x)).reverse()))).toArray();
    }

    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 5, 2, 4, 6, 7, 10, 8);
        List<String> strings2 = new ArrayList<>();
        strings2.add("cat");
        strings2.add("orange");
        strings2.add("cow");

        Map<String, String> countries = new HashMap<>();
        countries.put("UK", "London");
        countries.put("Russia", "Moscow");
        countries.put("Germany", "Berlin");

        List<Employee> employees = List.of(new Employee("Steve", 1000, "Backend"),
                new Employee("John", 2000, "Backend"),
                new Employee("Garry", 10, "Frontend"),
                new Employee("Bob", 20, "Frontend"));

        // 1
        System.out.println("Task 1!");
        Map<Integer, Integer> pairNumbers = getPairNumbers(nums, 8);
        for (Map.Entry<Integer, Integer> entry : pairNumbers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // 2
        System.out.println("Task2!");
        System.out.println(sortCountries(countries));

        // 3
        System.out.println("Task 3!");
        List<String> strings = List.of("Smooth", "See", "Ant", "Milk");
        System.out.println(filterAndSortString(strings, 'S'));

        //4
        System.out.println("Task 4!");
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Oleg", Arrays.asList("Evgen", "Dima", "Artem"));
        friends.put("Artem", Arrays.asList("Oleg", "Olya"));
        friends.put("Evgen", Arrays.asList("Oleg", "Dasha", "David"));
        friends.put("Dasha", Arrays.asList("Oleg", "Gena"));
        System.out.println(getFriends(friends));

        //5
        System.out.println("Task 5!");
        for (Map.Entry<String, Double> entry : averageSalary(employees).entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // 6
        System.out.println("Task 6!");
        for (String s : sortStringsByLength(strings2, "abcdefghijklmnopqrstuvwxyz")) {
            System.out.println(s);
        }

        //7
        System.out.println("Task 7!");
        System.out.println(intToBinary(nums));

        //8
        System.out.println("Task 8!");
        System.out.println(Arrays.toString(getPalindromes(1, 10000)));
    }

}

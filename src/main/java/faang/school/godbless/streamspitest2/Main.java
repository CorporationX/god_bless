package faang.school.godbless.streamspitest2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("printSortedCountries test, exp yer - wer - mos");
        Map<String, String> countries = Map.of("Russia", "Moscow", "Poland ", "Warszawa", "Armenia", "Yerevan");
        printCapitals(countries);

        System.out.println("sortStringByLength test, exp leg lens length");
        List<String> strings = List.of("length", "lens", "leg", "qwe");
        System.out.println(sortStringLength(strings, 'l'));

        System.out.println("findAverageSalaryOfDepartment test exp 150 85");
        List<Employee> employees = List.of(
                new Employee("1", "IT", 120000),
                new Employee("2", "IT", 150000),
                new Employee("3", "IT", 180000),
                new Employee("4", "manager", 80000),
                new Employee("5", "manager", 90000)
        );
        Map<String, Double> averageSalary = findAverageSalaryOfDepartment(employees);
        for (Map.Entry<String, Double> entry : averageSalary.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("replaceToBinary test");
        System.out.println(replaceToBinary(List.of(1, 2, 3, 10, 24)));

        System.out.println("findPalindrome TEST, exp 101 111 121 131 141");
        System.out.println(findPalindrome(100, 150));

        System.out.println("findUniquePairs TEST, exp 1,5 2,4");
        findUniquePairs(List.of(1, 2, 3, 4, 5), 6);

        System.out.println("findPairPeopleWithMutualFriends TEST");
        Map<String, List<String>> friends = Map.of(
                "1", List.of("2", "3"),
                "2", List.of("1", "4"),
                "3", List.of("1"),
                "4", List.of("2")
        );
        findPairPeopleWithMutualFriends(friends);

        System.out.println("filterAndSortStrings TEST");
        List<String> strings2 = List.of("apple", "banana", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        filterAndSortStrings(strings2, alphabet).forEach(System.out::println);
    }

    public static void findUniquePairs(List<Integer> nums, int target) {
        IntStream.range(0, nums.size())
                .forEach(elem1 -> IntStream.range(0, nums.size())
                        .filter(elem2 -> elem1 != elem2 && nums.get(elem1) + nums.get(elem2) == target)
                        .forEach(elem2 -> System.out.println(nums.get(elem2) + ", " + nums.get(elem1)))
                );
    }

    public static void printCapitals(Map<String, String> countries) {
        countries.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println(entry.getValue()));
    }

    public static List<String> sortStringLength(List<String> strings, char prefix) {
        return strings.stream()
                .filter(str -> str.charAt(0) == prefix)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static void findPairPeopleWithMutualFriends(Map<String, List<String>> friends) {
        friends.forEach(
                (key, value) -> friends.entrySet().stream()
                        .filter(entry -> !value.contains(entry.getKey()) && !key.equals(entry.getKey()))
                        .forEach(
                                entry -> entry.getValue().stream()
                                        .filter(value::contains)
                                        .forEach(name -> System.out.println(key + " - " + entry.getKey()))
                        )
        );
    }

    public static Map<String, Double> findAverageSalaryOfDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)
                        )
                );
    }

    public static List<String> filterAndSortStrings(List<String> strings, String alphabet) {
        List<String> letters = List.of(alphabet.split(""));
        return strings.stream()
                .filter(
                        word -> Arrays.stream(word.split(""))
                                .allMatch(letters::contains)
                ).sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> replaceToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindrome(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> {
                    int palindrome = num;
                    int reverse = 0;
                    while (palindrome > 0) {
                        int remainder = palindrome % 10;
                        reverse = reverse * 10 + remainder;
                        palindrome /= 10;
                    }
                    return num == reverse;
                }).boxed().toList();
    }
}

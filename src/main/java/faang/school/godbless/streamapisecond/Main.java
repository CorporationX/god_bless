package faang.school.godbless.streamapisecond;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println(sortedCapital(Map.of("Russia", "Moscow", "France", "Paris", "Qu", "woghnerjioghioe")));
        System.out.println(startsWith(List.of("erklgjererthjrthjrtjrt", "knlfgh", "eglnlehflgjhlfk", "egsldfj", "dfnkl"), 'e'));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int target = 10;
        System.out.println(targetSum(numbers, target));
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Alice", Arrays.asList("Bob", "Charlie", "David"));
        friends.put("Bob", Arrays.asList("Alice", "Eve"));
        friends.put("Charlie", Arrays.asList("Alice", "David"));
        friends.put("David", Arrays.asList("Alice", "Charlie"));
        friends.put("Eve", Arrays.asList("Bob"));

        List<List<String>> pairs = findPair(friends);
        System.out.println("Common friends: " + pairs);

        List<String> strings = Arrays.asList("apple", "banana", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> result = filterByAlphabet(strings, alphabet);
        System.out.println("Result: " + result);

        List<Integer> nums = Arrays.asList(10, 15, 5, 7, 20);
        List<String> binaryStrings = toBinaryString(nums);

        System.out.println("Binary Strings: " + binaryStrings);

        int startPos = 100;
        int endPos = 200;

        List<Integer> palindromes = findPalindromeInRange(startPos, endPos);

        System.out.println("Palindromes in range [" + startPos + ", " + endPos + "]: " + palindromes);

        String input = "racecar";
        List<String> palindroms = findPalindrome(input);

        System.out.println("Palindromes in \"" + input + "\": " + palindroms);

        int from = 1;
        int to = 10000;

        List<Integer> perfectNumbers = findPerfectNums(from, to);

        System.out.println("Perfect numbers in the range [" + from + ", " + to + "]: " + perfectNumbers);
    }

    public static Set<List<Integer>> targetSum(List<Integer> nums, int target) {
        return nums.stream()
                .filter(num -> nums.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCapital(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> startsWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> findPair(Map<String, List<String>> friends) {
        return friends.entrySet().stream()
                .flatMap(outerEntry -> friends.entrySet().stream()
                        .filter(innerEntry -> !outerEntry.getKey().equals(innerEntry.getKey()))
                        .filter(innerEntry -> !outerEntry.getValue().contains(innerEntry.getKey()))
                        .filter(innerEntry -> outerEntry.getValue().stream().anyMatch(friend -> innerEntry.getValue().contains(friend)))
                        .map(innerEntry -> Stream.of(outerEntry.getKey(), innerEntry.getKey()).sorted().toList()))
                .distinct()
                .toList();
    }

    public static Map<String, Double> avgSalaryByDep(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> {
                    for (int i = 0; i < string.length(); i++) {
                        if (!alphabet.contains(String.valueOf(string.charAt(i)))) {
                            return false;
                        }
                    }
                    return true;
                })
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinaryString(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromeInRange(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(num -> {
                    StringBuilder reversed = new StringBuilder(String.valueOf(num)).reverse();
                    return String.valueOf(num).contentEquals(reversed);
                })
                .boxed()
                .toList();
    }

    public static List<String> findPalindrome(String string) {
        return IntStream.rangeClosed(0, string.length())
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, string.length())
                        .mapToObj(j -> string.substring(i, j)))
                .filter(substring -> {
                    StringBuilder reversed = new StringBuilder(substring).reverse();
                    return substring.contentEquals(reversed);
                })
                .distinct()
                .toList();
    }

    public static List<Integer> findPerfectNums(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(num -> {
                    int sum = IntStream.range(1, num)
                            .filter(innerNum -> num % innerNum == 0)
                            .sum();
                    return num == sum;
                })
                .boxed()
                .toList();
    }
}
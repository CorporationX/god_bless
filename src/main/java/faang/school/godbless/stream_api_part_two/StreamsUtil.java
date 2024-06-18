package faang.school.godbless.stream_api_part_two;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsUtil {

    public static List<List<Integer>> findUniquePairs(List<Integer> numbers, int sum) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Numbers shouldn't be empty");
        }
        return numbers.stream().filter(num -> num < sum)
                .flatMap(numOne -> numbers.stream()
                        .filter(numTwo -> numOne + numTwo == sum)
                        .map(numTwo -> List.of(numOne, numTwo).stream().sorted().toList()))
                .distinct().collect(Collectors.toList());
    }

    public static List<String> sortedMapAndShowCapitals(Map<String, String> countries) {
        if (countries.isEmpty()) {
            throw new IllegalArgumentException("Countries shouldn't be empty");
        }
        return countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> filteredStringSortedStringByChar(List<String> strings, char checkChar) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("Strings shouldn't be empty");
        }
        return strings.stream().filter(str -> str.charAt(0) == checkChar).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<List<String>> findPeopleNonFriends(Map<String, List<String>> personFriends) {
        if (personFriends.isEmpty()) {
            throw new IllegalArgumentException("userFriends shouldn't be empty");
        }
        return personFriends.entrySet().stream()
                .flatMap(entryOne -> personFriends.entrySet().stream()
                        .filter(entryTwo -> !entryTwo.getKey().equals(entryOne.getKey()) && !entryOne.getValue().contains(entryTwo.getKey()))
                        .filter(entryTwo -> entryTwo.getValue().stream().anyMatch(name -> entryOne.getValue().contains(name)))
                        .map((person) -> List.of(entryOne.getKey(), person.getKey()).stream().sorted().toList())).distinct().toList();
    }

    public static Map<String, Double> getDepartmentAverageSalary(List<Employee> employees) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("employees shouldn't be empty");
        }
        return employees.stream().collect(Collectors.groupingBy(
                Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    public static List<String> filterAndSortStringsByAlphabet(List<String> strings, char[] alphabet) {
        if (strings.isEmpty() || alphabet.length == 0) {
            throw new IllegalArgumentException("arguments shouldn't be empty");
        }
        return strings.stream().filter(str -> str.chars().allMatch(character ->
                        containsCharacter(character, alphabet)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    private static boolean containsCharacter(int numChar, char[] chars) {
        if (chars.length == 0) {
            new IllegalArgumentException("chars shouldn't be empty");
        }
        for (char checkChar : chars) {
            if (numChar == checkChar) {
                return true;
            }
        }
        return false;
    }

    public static List<String> numsToBinaryStrings(List<Integer> nums) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("nums shouldn't be empty");
        }
        return nums.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.range(start, end).boxed()
                .filter(num -> num / 10 != 0)
                .filter(num -> checkNumberIsPalindromes(num)).toList();
    }

    private static boolean checkNumberIsPalindromes(int num) {
        String currentNum = String.valueOf(num);
        String reverseNum = new StringBuffer(currentNum).reverse().toString();
        return currentNum.equals(reverseNum);
    }
}


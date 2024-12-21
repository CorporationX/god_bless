package school.faang.sprint2.task47055.service;

import school.faang.sprint2.task47055.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFunc {

    public static List<List<String>> getFriendsOfFriends(Map<String, List<String>> friends) {

        return friends.keySet().stream()
                .flatMap(friend1 -> friends.keySet().stream()
                        .filter(friend2 -> isFriends(friends, friend1, friend2))
                        .map(result -> Arrays.asList(friend1, result))
                )
                .map(list -> list.stream()
                        .sorted()
                        .toList())
                .distinct()
                .toList();
    }

    private static boolean isFriends(Map<String, List<String>> friends, String friend1, String friend2) {
            if (friend1.equals(friend2) || friends.get(friend1).contains(friend2)) {
                return false;
            } else {
                return friends.get(friend1).stream().anyMatch(friends.get(friend2)::contains);
            }
    }

    public static Map<String, Double> getAverageSale(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

    }

    public static List<String> getAllPalindromes(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .mapToObj(String::valueOf)
                .filter(StreamFunc::isPalindrome)
                .sorted()
                .peek(System.out::println)
                .toList();
    }

    private static boolean isPalindrome(String numberAsString) {
        int numberLength = numberAsString.length();
        for (int i = 0; i < (numberLength / 2) + 1; i++) {
            if (numberAsString.charAt(i) != numberAsString.charAt(numberLength - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static List<String> getSubstringPalindromes(String string) {
        Set<String> strings = new HashSet<>();
        int strLength = string.length();
        for (int i = 0; i < strLength; i++) {
            for (int j = i + 1; j < strLength + 1; j++) {
                strings.add(string.substring(i, j));
            }
        }

        return strings.stream()
                .filter(substring -> new StringBuilder(String
                        .valueOf(substring))
                        .reverse()
                        .toString()
                        .equals(substring))
                .toList();
    }

    public static List<Integer> getPerfectNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(i -> Objects.equals(i, IntStream.range(1, i).filter(j -> isDivided(i, j)).sum()))
                .boxed()
                .toList();
    }

    private static boolean isDivided(int i, int j) {
        return i % j == 0;
    }
}

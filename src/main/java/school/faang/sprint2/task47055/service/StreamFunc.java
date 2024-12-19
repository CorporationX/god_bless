package school.faang.sprint2.task47055.service;

import school.faang.sprint2.task47055.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFunc {

    public static List<List<String>> getFriendsOfFriends(Map<String, List<String>> friends) {

        return friends.keySet().stream()
                .flatMap(friend1 -> friends.keySet().stream()
                        .filter(friend2 -> {
                            if (friend1.equals(friend2)) {
                                return false;
                            }

                            if (friends.get(friend1).contains(friend2)) {
                                return false;
                            }

                            return friends.get(friend1).stream().anyMatch(friends.get(friend2)::contains);
                        })
                        .map(result -> Arrays.asList(friend1, result))
                )
                .map(list -> list.stream()
                        .sorted()
                        .toList())
                .distinct()
                .toList();
    }

    public static Map<String, Double> getAverageSale(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

    }

    public static List<String> getAllPalindromes(int from, int to) {
        List<String> numbers = new ArrayList<>();

        for (int i = from; i <= to; i++) {
            numbers.add(String.valueOf(i));
        }

        return numbers.stream()
                .filter(number -> {
                    int numberLength = number.length();
                    for (int i = 0; i < (numberLength / 2) + 1; i++) {
                        if (number.charAt(i) != number.charAt(numberLength - (i + 1))) {
                            return false;
                        }
                    }
                    return true;
                })
                .sorted()
                .peek(System.out::println)
                .toList();
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
                .filter(substring -> new StringBuilder(String.valueOf(substring)).reverse().toString().equals(substring))
                .toList();
    }

    public static List<Integer> getPerfectNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(i -> Objects.equals(i, IntStream.range(1, i).filter(j -> i % j == 0).sum()))
                .boxed()
                .toList();
    }

}

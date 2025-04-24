package school.faang.streamoperations;

import school.faang.streamoperations.entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Operations {

    public static Set<List<String>> findPairNotFriends(Map<String, List<String>> friends) {
        return friends.keySet().stream()
                .flatMap(firstFriend -> friends.keySet().stream()
                        .filter(secondFriend -> !firstFriend.equals(secondFriend)
                                && !friends.get(firstFriend).contains(secondFriend))
                        .filter(secondFriend -> {
                            List<String> firstFriends = new ArrayList<>(friends.get(firstFriend));
                            firstFriends.retainAll(friends.get(secondFriend));
                            return !firstFriends.isEmpty();
                        })
                        .map(secondFriend -> {
                            List<String> pair = Arrays.asList(secondFriend, firstFriend);
                            Collections.sort(pair);
                            return pair;
                        })
                )
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<Integer> findPalindromicNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .map(Integer::parseInt)
                .toList();
    }

    public static List<String> findPalindromicSubstrings(List<String> words) {
        return words.stream()
                .flatMap(word -> IntStream.range(0, word.length())
                        .boxed()
                        .flatMap(i -> IntStream.rangeClosed(i + 1, word.length())
                                .mapToObj(j -> word.substring(i, j))))
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .distinct()
                .toList();
    }

    public static List<Integer> findPerfectNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 1
                        && IntStream.range(1, number)
                        .filter(i -> number % i == 0)
                        .sum() == number
                )
                .toList();
    }
}
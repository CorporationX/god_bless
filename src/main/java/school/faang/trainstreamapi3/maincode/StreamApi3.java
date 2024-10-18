package school.faang.trainstreamapi3.maincode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi3 {
    public static Set<Set<String>> findMutualFriends(Map<String, List<String>> friendsMap) {
        Set<Set<String>> pairs = new HashSet<>();

        friendsMap.keySet().forEach(person -> {
            List<String> friends = friendsMap.get(person);

            friends.forEach(friend -> {
                List<String> potencialFriends = friendsMap.get(friend).stream()
                        .filter(potencialFriend -> !potencialFriend.equals(person)
                        && !friends.contains(potencialFriend))
                        .toList();

                potencialFriends.forEach(potencialFriend -> {
                    Set<String> pair = new HashSet<>(Arrays.asList(person, potencialFriend));
                    pairs.add(pair);
                });
            });
        });
        return pairs;
    }

    public static Map<String, Double> findAverageSalaryForDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<Integer> findPalindrome(int leftBorder, int rightBorder) {
        return IntStream.rangeClosed(leftBorder, rightBorder)
                .filter(number -> String.valueOf(number)
                        .equals(new StringBuilder(String.valueOf(number)).reverse().toString()))
                .boxed()
                .toList();
    }

    public static Set<String> substringPalindromes(String word) {
        Set<String> strings = new HashSet<>();

        IntStream.range(0, word.length())
                .forEach(i -> IntStream.range(i + 1, word.length() + 1)
                        .mapToObj(j -> word.substring(i, j))
                        .filter(x -> isPalindrome(x))
                        .forEach(x -> strings.add(x)));
        return strings;
    }

    public static List<Integer> findPerfectNumbers(int leftBorder, int rigthBorder) {
        return IntStream.rangeClosed(leftBorder, rigthBorder)
                .filter(number ->
                        number == IntStream.rangeClosed(1, number / 2)
                                .filter(i -> number % i == 0)
                                .sum())
                .boxed()
                .toList();
    }

    private static boolean isPalindrome(String word) {
        if (word.equals(new StringBuilder(word).reverse().toString())) {
            return true;
        }
        return false;
    }
}

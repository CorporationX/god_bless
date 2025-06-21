package school.faang.stream3;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Boolean.TRUE;

/**
 * @author Danil Pudovkin
 * @since 19.06.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Operations {

    public static Set<Set<String>> findPeopleWithMutualFriends(Map<String, Set<String>> friendsMap) {
        var peopleWithMutualFriends = new HashSet<Set<String>>();
        friendsMap.forEach((friendA, friendsOfA) ->
                friendsOfA.forEach(friendB -> {
                    var friendsOfB = new HashSet<>(friendsMap.get(friendB));
                    friendsOfB.remove(friendA);
                    friendsOfB.forEach(mutualFriend -> peopleWithMutualFriends.add(Set.of(friendA, mutualFriend)));
                }));
        return peopleWithMutualFriends;
    }

    public static Map<String, Double> findAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary))
                );
    }

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.range(start, end + 1)
                .filter(num -> {
                    var number = String.valueOf(num);
                    return IntStream.range(0, number.length() / 2 + 1)
                            .mapToObj(i -> number.charAt(i) == number.charAt(number.length() - 1 - i))
                            .allMatch(TRUE::equals);
                })
                .boxed()
                .toList();
    }

    public static Set<String> findSubstringPalindromes(String string) {
        var palindromes = new HashSet<String>();
        IntStream.range(0, string.length() + 1).forEach(i ->
                IntStream.range(i + 1, string.length() + 1).forEach(j -> {
                    var substring = string.substring(i, j);
                    var isPalindrome = IntStream.range(0, substring.length() / 2 + 1)
                            .mapToObj(i2 -> substring.charAt(i2) == substring.charAt(substring.length() - 1 - i2))
                            .allMatch(TRUE::equals);
                    if (isPalindrome) {
                        palindromes.add(substring);
                    }
                }));
        return palindromes;
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        var perfectNumbers = new ArrayList<Integer>();
        IntStream.range(start, end + 1).forEach(number -> {
            var perfectNumber = IntStream.range(1, number)
                    .filter(divider -> number % divider == 0)
                    .sum();
            if (number == perfectNumber) {
                perfectNumbers.add(number);
            }
        });
        return perfectNumbers;
    }
}

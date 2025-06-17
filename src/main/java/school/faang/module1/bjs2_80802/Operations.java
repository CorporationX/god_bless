package school.faang.module1.bjs2_80802;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Operations {

    public static List<List<String>> findPeopleWithCommonFriends(Map<String, List<String>> friendsMap) {
        List<String> people = new ArrayList<>(friendsMap.keySet());
        return people.stream()
                .flatMap(person1 -> people.stream()
                        .filter(person2 -> !person1.equals(person2))
                        .filter(person2 -> person1.compareTo(person2) < 0)
                        .filter(person2 -> {
                            List<String> person1Friends = friendsMap.getOrDefault(person1, List.of());
                            List<String> person2Friends = friendsMap.getOrDefault(person2, List.of());
                            boolean notFriends = !person1Friends.contains(person2) && !person2Friends.contains(person1);
                            boolean hasCommonFriend = person1Friends.stream()
                                    .anyMatch(person2Friends::contains);
                            return notFriends && hasCommonFriend;
                        })
                        .map(person2 -> List.of(person1, person2))
                )
                .toList();
    }

    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<Integer> findPalindromes(int start, int end) {

        return IntStream.rangeClosed(start, end)
                .boxed()
                .filter(Operations::isNumberPalindrome)
                .toList();
    }

    private static boolean isNumberPalindrome(int number) {
        String str = String.valueOf(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static List<String> findPalindromicSubstrings(String string) {
        return IntStream.rangeClosed(0, string.length())
                .boxed()
                .flatMap(start -> IntStream.rangeClosed(start + 1, string.length())
                        .mapToObj(end -> string.substring(start, end)))
                .filter(Operations::isStringPalindrome)
                .distinct()
                .toList();
    }

    private static boolean isStringPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(Operations::isPerfect)
                .boxed()
                .toList();
    }

    private static boolean isPerfect(int number) {
        if (number <= 1) {
            return false;
        }
        int sumOfDividers = IntStream.rangeClosed(1, number / 2)
                .filter(divider -> number % divider == 0)
                .sum();
        return sumOfDividers == number;
    }
}
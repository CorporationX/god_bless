package school.faang.task47220;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task {
    private static void validateStartEnd(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("start can`t be more than end");
        }
    }

    public static Set<List<String>> coupleCommonFriends(Map<String, List<String>> friends) {
        if (friends == null) {
            throw new IllegalArgumentException("friend can't be null");
        }

        return IntStream.range(0, friends.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, friends.size())
                        .mapToObj(j -> {
                            List<String> namesList = friends.keySet().stream().toList();

                            String friend1 = namesList.get(i);
                            String friend2 = namesList.get(j);

                            Set<String> friendsSet = new HashSet<>(friends.get(friend1));

                            if (!friendsSet.contains(friend2)) {

                                List<String> commonFriends = friends.get(friend1).stream()
                                        .filter(friends.get(friend2)::contains)
                                        .toList();

                                if (!commonFriends.isEmpty()) {
                                    return new ArrayList<>(List.of(friend1, friend2));
                                }
                            }
                            return null;
                        }).filter(Objects::nonNull)
                ).collect(Collectors.toSet());
    }

    public static Map<Department, Double> averageSalary(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("employees can`t be null");
        }

        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    public static List<String> palindromeNumbers(int start, int end) {
        validateStartEnd(start, end);

        StringBuilder reverseString = new StringBuilder();

        return IntStream.rangeClosed(start, end)
                .mapToObj(String::valueOf)
                .filter(string -> string.contentEquals(reverseString.append(string).reverse()))
                .peek(string -> reverseString.setLength(0))
                .toList();
    }

    public static List<String> palindromeSubstring(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("string can`t be null");
        }

        StringBuilder reverseString = new StringBuilder();

        return IntStream.rangeClosed(0, string.length())
                .boxed().toList().stream()
                .flatMap(i -> IntStream.rangeClosed(i + 1, string.length())
                        .mapToObj(j -> {
                            String substring = string.substring(i, j);
                            reverseString.append(substring).reverse();

                            if (substring.contentEquals(reverseString)) {
                                return substring;
                            }

                            reverseString.setLength(0);

                            return null;
                        })).filter(Objects::nonNull).distinct()
                .toList();
    }

    public static List<Integer> perfectNumbers(int start, int end) {
        validateStartEnd(start, end);

        return IntStream.rangeClosed(start, end)
                .filter(number -> IntStream.range(start, number).filter(i -> number % i == 0).sum() == number)
                .boxed().toList();
    }
}

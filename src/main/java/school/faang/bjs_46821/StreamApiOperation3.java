package school.faang.bjs_46821;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiOperation3 {
    public static List<List<String>> noFriendsPair(Map<String, List<String>> users) {
        Map<String, List<String>> friends = users.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .flatMap(friend -> users.get(friend).stream())
                        .filter(friendFriends -> !Objects.equals(entry.getKey(), friendFriends))
                        .filter(friendFriends -> !entry.getValue().contains(friendFriends))
                        .distinct()
                        .collect(Collectors.toList())
                ));


        return friends.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(value -> Map.entry(entry.getKey(), value))
                )
                .map(entry -> Stream.of(entry.getKey(), entry.getValue())
                        .sorted()
                        .toList())
                .distinct()
                .toList();
    }

    public static Map<String, Double> avgSalary(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

    }

    public static List<Integer> palindromeNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(Palindrome::isPalindrome)
                .boxed()
                .collect(Collectors.toList());
    }

    public static Set<String> palindromeSubStrings(String s) {
        Set<String> palindromeSubStrings = getAllSubstrings(s);

        return palindromeSubStrings.stream()
                .filter(Palindrome::isPalindrome)
                .collect(Collectors.toSet());
    }

    public static Set<Integer> perfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(PerfectNumber::isPerfect)
                .boxed()
                .collect(Collectors.toSet());
    }


    private static Set<String> getAllSubstrings(String s) {
        return IntStream.rangeClosed(0, s.length() - 1)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, s.length())
                        .boxed()
                        .map(j -> s.substring(i, j)))
                .collect(Collectors.toSet());
    }


}

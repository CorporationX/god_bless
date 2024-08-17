package faang.school.godbless.train_streams2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsComputer {

    // 1 - READ ABOUT FLAT MAP AND mapToObj
    public static List<List<Integer>> pairsAddingToTarget(List<Integer> numbers, int target) {
        return IntStream
                .range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream
                        .range(i + 1, numbers.size())
                        .mapToObj(n -> List.of(numbers.get(i), numbers.get(n))))
                .filter(l -> l.get(0) + l.get(1) == target)
                .toList();
    }

    // 2
    public static void sortedCountriesCapitals(Map<String, String> countriesCapitals) {
        List<String> capitals = countriesCapitals.keySet().stream()
                .sorted()
                .map(countriesCapitals::get)
                .toList();
        capitals.forEach(System.out::println);
    }

    // 3
    public static List<String> startWithCharLengthSorted(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.startsWith(Character.toString(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // 4
    public static List<List<String>> notFriendsWithCommonFriends(Map<String, List<String>> friendsByUser) {
        List<String> users = new ArrayList<>(friendsByUser.keySet());

        return users.stream()
                .flatMap(user1 -> users.stream()
                        .filter(user2 -> !user1.equals(user2) && !friendsByUser.get(user1).contains(user2))
                        .filter(user2 -> {
                            Set<String> commonFriends = new HashSet<>(friendsByUser.get(user1));
                            commonFriends.retainAll(friendsByUser.get(user2));
                            return !commonFriends.isEmpty();
                        })
                        .map(user2 -> Stream.of(user1, user2).sorted().toList())
                )
                .distinct()
                .toList();
    }

    // 5
    public static Map<String, Double> departmentAverageSalaries(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary))
                );
    }

    // 6
    public static List<String> fromAlphabetLengthSorted(List<String> strings, char[] alphabet) {
        List<Integer> ints = String.valueOf(alphabet)
                .chars()
                .boxed()
                .toList();

        return strings.stream()
                .filter(str ->  str.chars().allMatch(ints::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // 7
    public static List<String> intToBinaryString(List<Integer> numbers) {
        return numbers.stream()
                 .map(Integer::toBinaryString)
                .toList();
    }

    // 8
    public static List<Integer> allPalindromesInRange(int begin, int end) {
        return IntStream.range(begin, end).boxed()
                .filter(i -> i.toString().length() > 1)
                .filter(i -> i.toString().contentEquals((new StringBuilder(i.toString())).reverse()))
                .toList();
    }
}

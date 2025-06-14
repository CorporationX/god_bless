package school.faang.bjs2_80734;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    public static List<Pair<String, String>> findPeopleWithCommonFriends(Map<String, List<String>> friendships) {
        List<Pair<String, String>> result = new ArrayList<>();

        friendships.keySet().stream()
                .flatMap(person -> friendships.keySet().stream()
                        .filter(friend -> person.compareTo(friend) < 0)
                        .filter(friend -> !friendships.get(person).contains(friend))
                        .filter(friend -> {
                            List<String> friends1 = friendships.get(person);
                            List<String> friends2 = friendships.get(friend);
                            return friends1.stream().anyMatch(friends2::contains);
                        })
                        .map(friend -> new Pair<>(person, friend)))
                .forEach(result::add);

        return result;
    }

    public static Map<String, Double> findAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

    }

    public static List<Integer> findPalindromeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> {
                    String numStr = String.valueOf(num);
                    return numStr.contentEquals(new StringBuilder(numStr).reverse());
                })
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> findPalindromeSubstrings(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(start -> IntStream.rangeClosed(start + 1, input.length())
                        .mapToObj(end -> input.substring(start, end)))
                .filter(substring -> substring.contentEquals(new StringBuilder(substring).reverse()))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> {
                    int sum = IntStream.rangeClosed(1, num / 2)
                            .filter(i -> num % i == 0)
                            .sum();
                    return sum == num;
                })
                .boxed()
                .collect(Collectors.toList());
    }
}

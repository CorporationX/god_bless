package school.faang.сollection__stream_api__optional.bjs2_89292;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperationWithStream {
    public static Set<List<String>> findPeopleWithCommonFriends(Map<String, List<String>> friendships) {
        Set<List<String>> result = new HashSet<>();

        for (Map.Entry<String, List<String>> entry : friendships.entrySet()) {
            String person = entry.getKey();
            List<String> friends = entry.getValue();
            friendships.keySet().stream()
                    .filter(other -> !other.equals(person) && !friends.contains(other))
                    .forEach(other -> {
                        List<String> commonFriends = friends.stream()
                                .filter(friendships.getOrDefault(other, List.of())::contains)
                                .toList();

                        if (!commonFriends.isEmpty()) {
                            List<String> pair = Arrays.asList(person, other);
                            pair.sort(String::compareTo); // Уникальность пар
                            result.add(pair);
                        }
                    });
        }

        return result;
    }

    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    public static List<Integer> numbersPalindromes(int startNumber, int endNumber) {
        return IntStream.rangeClosed(startNumber, endNumber)
                .filter(num -> {
                    String numStr = Integer.toString(num);
                    return numStr.contentEquals((new StringBuilder(numStr)).reverse().toString());
                })
                .boxed()
                .toList();
    }

    public static List<String> palindromeSubstrings(String inputString) {
        return IntStream.rangeClosed(0, inputString.length())
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, inputString.length())
                        .mapToObj(j -> inputString.substring(i, j))
                        .filter(str -> str.contentEquals(new StringBuilder(str).reverse())))
                .distinct()
                .toList();
    }

    public static List<Integer> findPerfectNumbers(int startNumber, int endNumber) {
        return IntStream.rangeClosed(startNumber, endNumber)
                .filter(num -> IntStream.rangeClosed(1, num / 2)
                        .filter(i -> num % i == 0)
                        .sum() == num
                )
                .boxed()
                .toList();
    }
}

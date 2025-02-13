package streamapi3;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;

@UtilityClass
public class StreamOperations3 {

    private static final String ERR_NULL_EMPLOYEES_LIST = "Employees list must not be null";
    private static final String ERR_NULL_INPUT_STRING = "Input string must not be null";

    public static Set<List<String>> findPeopleWithCommonFriends(@NonNull Map<String, List<String>> friendships) {
        Set<List<String>> result = new HashSet<>();
        friendships.forEach((person, friends) ->
                friendships.keySet().stream()
                        .filter(other -> !other.equals(person) && !friends.contains(other))
                        .forEach(other -> {
                            List<String> commonFriends = friends.stream()
                                    .filter(friendships.getOrDefault(other, List.of())::contains)
                                    .collect(Collectors.toList());
                            if (!commonFriends.isEmpty()) {
                                List<String> pair = Arrays.asList(person, other);
                                pair.sort(String::compareTo);
                                result.add(pair);
                            }
                        })
        );
        return result;
    }
    public Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException(ERR_NULL_EMPLOYEES_LIST);
        }
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    public List<Integer> findPalindromicNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(StreamOperations3::isPalindrome)
                .boxed()
                .toList();
    }

    public List<String> findPalindromicSubstrings(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERR_NULL_INPUT_STRING);
        }
        int n = input.length();
        return IntStream.range(0, n)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, n)
                        .mapToObj(j -> input.substring(i, j)))
                .filter(s -> s.length() > 0 && isPalindrome(s))
                .distinct()
                .toList();
    }

    private boolean isPalindrome(int number) {
        String s = Integer.toString(number);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public List<Integer> findPerfectNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(StreamOperations3::isPerfect)
                .boxed()
                .toList();
    }

    private boolean isPerfect(int number) {
        if (number < 2) {
            return false;
        }
        int sum = IntStream.range(1, number)
                .filter(i -> number % i == 0)
                .sum();
        return sum == number;
    }
}

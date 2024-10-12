package school.faang.task224.Service;

import school.faang.task224.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPIService {
    public static List<List<String>> findPeopleWithMutualFriends(Map<String, List<String>> friendsList) {
        return friendsList.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(f -> (!friendsList.get(f.get(0)).contains(f.get(1))))
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getAVGSalaryAtDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
    }

    public static int[] findPalindromeNumbersBetween(int start, int end) {
        return IntStream.range(start, end + 1)
                .filter(number -> new StringBuilder(String.valueOf(number)).reverse().toString().equals(String.valueOf(number)))
                .toArray();
    }

    public static List<String> findAllSubstringThatPalindrome(String string) {
        List<String> result = new ArrayList<>();
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, string.length())
                        .mapToObj(j -> string.substring(i, j)))
                .filter(str -> str.equals(new StringBuilder(str).reverse().toString()))
                .distinct()
                .collect(Collectors.toList());

    }

    public static List<Integer> findAllPerfectNumberBetween(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .flatMap(i -> IntStream.of(IntStream.rangeClosed(1, i / 2)
                                .filter(j -> i % j == 0)
                                .reduce(0, Integer::sum))
                                .filter(z -> i == z))
                .boxed()
                .collect(Collectors.toList());
    }
}

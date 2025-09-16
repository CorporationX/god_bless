package school.faang.сollection__stream_api__optional.bjs2_89292;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperationWithStream {
    public static Map<String, String> findPeopleWithMutualFriends(Map<String, List<String>> people) {
        Map<String, String> result = new HashMap<>();
//        people.entrySet().stream()
//                .collect(Collectors.toMap(
//                        entry -> entry.getKey(),
//                        entry-> entry.getValue().stream()
//                ))
        return result;
    }

    public static Map<String, Long> averageSalaryByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
        return employeesByDepartment.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().stream().mapToLong(Employee::getSalary).sum()
                ));
    }

    public static ArrayList<Integer> numbersPalindromes(int startNumber, int endNumber) {
        return IntStream.rangeClosed(startNumber, endNumber)
                .filter(num -> {
                    String numStr = Integer.toString(num);
                    String reversed = new StringBuilder(numStr).reverse().toString();
                    return numStr.equals(reversed);
                })
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<String> palindromeSubstrings(String inputString) {
        return IntStream.range(0, inputString.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, inputString.length())
                        .mapToObj(j -> inputString.substring(i, j))
                        .filter(str -> str.equals(new StringBuilder(str).reverse().toString())))
                .distinct()
                .collect(Collectors.toList());
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

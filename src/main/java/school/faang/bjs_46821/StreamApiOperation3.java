package school.faang.bjs_46821;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiOperation3 {
    public static Map<String, String> noFriendsPair(Map<String, List<String>> users) {
        Map<String, String> noFriendsPair = new HashMap<>();

        users.forEach((user, friendList) -> friendList.forEach(friend -> users.get(friend).stream()
                .filter(f -> !f.equals(user) && !friendList.contains(f) && !noFriendsPair.containsKey(f))
                .forEach(f -> noFriendsPair.put(user, f))));

        return noFriendsPair;
    }

    public static Map<String, Double> avgSalary(List<Employee> employees) {
        Map<String, Double> avgSalary = new HashMap<>();
        Map<String, List<Employee>> employeeByDepartment = new HashMap<>();

        employees.forEach(employee -> {
            employeeByDepartment.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>());
            employeeByDepartment.get(employee.getDepartment()).add(employee);

        });

        employeeByDepartment.forEach((department, employeeList) -> {
            AtomicReference<Double> sumSalary = new AtomicReference<>((double) 0);
            employeeList.forEach(employee -> sumSalary.updateAndGet(v -> (v + employee.getSalary())));
            avgSalary.put(department, sumSalary.get() / employeeByDepartment.get(department).size());
        });
        return avgSalary;
    }

    public static List<Integer> palindromeNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(StreamApiOperation3::isPalindromeNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindromeNumber(int number) {
        String numberString = String.valueOf(number);
        String reverseString = new StringBuilder(numberString).reverse().toString();
        return numberString.equals(reverseString);
    }

}

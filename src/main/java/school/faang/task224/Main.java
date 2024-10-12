package school.faang.task224;

import school.faang.task224.Service.StreamAPIService;
import school.faang.task224.employee.Employee;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        StreamAPIService.findPeopleWithMutualFriends(Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie"))
        ).forEach(System.out::println);

        Employee firstEmployee = new Employee("Ivan", 60700, "marketing");
        Employee secondEmployee = new Employee("Stepan", 120000, "marketing");
        Employee thirdemployee = new Employee("Vlad", 200000, "IT");

        StreamAPIService.getAVGSalaryAtDepartment(List.of(firstEmployee, secondEmployee, thirdemployee))
                .forEach((s, aDouble) -> System.out.println(s + " " + aDouble));

        System.out.println(Arrays.toString(StreamAPIService.findPalindromeNumbersBetween(100, 212)));

        StreamAPIService.findAllSubstringThatPalindrome("abac").forEach(System.out::println);

        StreamAPIService.findAllPerfectNumberBetween(1, 1000).forEach(System.out::println);
    }
}

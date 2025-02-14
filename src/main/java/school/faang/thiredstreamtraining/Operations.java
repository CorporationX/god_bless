package school.faang.thiredstreamtraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Operations {

    public Set<Set<String>> checkThereIsNoDirectFriendship(Map<String, List<String>> friends) {
        if (friends == null) {
            return Collections.emptySet();
        }
        return friends.entrySet().stream()
                .flatMap(firstPerson -> friends.entrySet().stream()
                        .filter(secondPerson ->
                                !secondPerson.getKey().equals(firstPerson.getKey())
                                        && !secondPerson.getValue().contains(firstPerson.getKey())
                                        && !Collections.disjoint(firstPerson.getValue(), secondPerson.getValue()))
                        .map(secondPerson -> Set.of(firstPerson.getKey(), secondPerson.getKey())))
                .collect(Collectors.toSet());
    }

    public Map<DepartmentType, Double> countAverageSalary(List<Employee> employees) {
        if (employees == null) {
            return Map.of();
        }
        Map<DepartmentType, List<Integer>> departmentSalaries = new HashMap<>();
        employees.forEach(employee -> departmentSalaries.computeIfAbsent(employee.getDepartment(),
                        salary -> new ArrayList<>()).add(employee.getSalary()));
        Map<DepartmentType, Double> averageDepartmentSalary = new HashMap<>();
        departmentSalaries.forEach((department, salaries) -> {
            double averageSalary = salaries.stream().mapToDouble(salary -> salary).average().orElse(0.0);
            averageDepartmentSalary.put(department, averageSalary);
        });
        return averageDepartmentSalary;
    }

    public List<Integer> findNumberPalindroms(int start, int finish) {
        return IntStream.range(start, finish)
                .mapToObj(String::valueOf)
                .filter(this::isPalindrom)
                .map(Integer::valueOf).toList();
    }

    public Set<String> findSubstringPalindroms(String string) {
        if (string == null || string.isBlank()) {
            return Collections.emptySet();
        }
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(start -> IntStream.range(start + 1, string.length() + 1)
                        .mapToObj(finish -> string.substring(start, finish))
                        .filter(this::isPalindrom))
                .collect(Collectors.toSet());
    }

    public List<Integer> findPerfectNumbers(int start, int finish) {
        return IntStream.range(start, finish).boxed().filter(this::isEqualDivisorSum).toList();
    }

    private boolean isEqualDivisorSum(int number) {
        int divisorSum = IntStream.range(1, number).filter(integer -> number % integer == 0).sum();
        return number == divisorSum;
    }

    private boolean isPalindrom(String string) {
        if (string == null || string.isBlank()) {
            return false;
        }
        return IntStream.range(0, string.length() / 2)
                .allMatch(charPosition ->
                        string.charAt(charPosition) == string.charAt(string.length() - 1 - charPosition));
    }


}

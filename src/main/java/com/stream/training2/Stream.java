package com.stream.training2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {

    public static List<String> searchUniquePairs(List<Integer> list, int target) {
        return (IntStream.rangeClosed(0, list.size())
                        .boxed()
                        .flatMap(i -> IntStream.range(i + 1, list.size())
                                .filter(j -> list.get(i) + list.get(j) == target)
                                .mapToObj(j -> list.get(i) + ":" + list.get(j))).toList());


    }

    public static List<String> getСapital(Map<String, String> countriesWithCapital) {
        return countriesWithCapital.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getLines(List<String> linesList, char word) {
        return linesList.stream()
                .filter(line -> line.startsWith(String.valueOf(word)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<List<String>> getPair(Map<String, List<String>> list) {
        return(list.entrySet()
                .stream()
                .flatMap(k -> list.entrySet()
                        .stream()
                        .filter(k1 -> !k1.getKey().equals(k.getKey()))
                        .filter(k1 -> !k.getValue().contains(k1.getKey()))
                        .filter(k1 -> k1.getValue()
                                .stream()
                                .anyMatch(v -> k.getValue().contains(v)))
                        .map(k2 -> List.of(k.getKey(), k2.getKey()).stream()
                                .sorted()
                                .toList()))
                .distinct()
                .toList()
        );
    }

    public static Map<String, Double> getAvgSalaryByDepartment(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<String> filterLinesByAlphabet(List<String> lines, String[] words) {
        return Arrays.stream(words).flatMap(w -> lines.stream()
                        .filter(line -> line.startsWith(w)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convert(String[] byteCode) {
        return Arrays.stream(byteCode)
                .map(b -> Integer.parseInt(b, 2))
                .map(Character::toString)
                .collect(Collectors.toList());
    }
}

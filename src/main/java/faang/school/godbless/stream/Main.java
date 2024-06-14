package faang.school.godbless.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> pairsBySum = CollectionHandler.findPairsBySum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 15);
        pairsBySum.forEach(System.out::println);


        List<String> capitalByCountry = CollectionHandler.sortCountriesByCapital
                (Map.of("Russia", "Moscow", "USA", "Washington", "China", "Beijing"));
        capitalByCountry.forEach(System.out::println);


        List<String> filterByLetter = CollectionHandler.filterByLetter(List.of("Hello", "practice", "Pilot", "World", "Java", "Python"), 'P');
        filterByLetter.forEach(System.out::println);


        Map<String, List<String>> map = new HashMap<>();
        map.put("Ura", List.of("Anna", "Vasya"));
        map.put("Petya", List.of("Vasya", "Anna"));
        map.put("Vasya", List.of("Anna", "Ura"));
        map.put("Olga", List.of("Petya", "Ura"));
        map.put("Anna", List.of("Ura", "Petya"));

        List<List<String>> commonFriends = CollectionHandler.findCommonFriends(map);
        commonFriends.forEach(System.out::println);


        Employee employee1 = new Employee("Anna", 100, "departament1");
        Employee employee2 = new Employee("Petya", 200, "departament2");
        Employee employee3 = new Employee("Vasya", 300, "departament1");
        Employee employee4 = new Employee("Olga", 400, "departament4");
        Employee employee5 = new Employee("Vika", 100, "departament4");

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5);
        Map<String, Double> averageSalaryByDepartment = CollectionHandler.findAverageSalaryByDepartment(employees);
        System.out.println(averageSalaryByDepartment);


        List<String> strings = new ArrayList<>(List.of("helloo", "world", "java", "python"));
        String[] chars = new String[]{"w", "o", "r", "l", "d", "e", "a", "h"};
        List<String> filterByAlphabet = CollectionHandler.filterByAlphabet(strings, chars);
        filterByAlphabet.forEach(System.out::println);


        List<String> convertToBinary = CollectionHandler.convertToBinary(List.of(1, 2, 3, 4, 5, 1024, 2056));
        System.out.println(convertToBinary);


        List<Integer> palindromes = CollectionHandler.findPalindromes(100, 1000);
        palindromes.forEach(System.out::println);
    }
}

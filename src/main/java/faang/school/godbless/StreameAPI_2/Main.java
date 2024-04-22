package faang.school.godbless.StreameAPI_2;

import java.util.*;

import static faang.school.godbless.StreameAPI_2.CountriesAndCapitals.sortedCountry;
import static faang.school.godbless.StreameAPI_2.FilterOfString.filterChar;
import static faang.school.godbless.StreameAPI_2.PairSum.findingPairsOfNumbers;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 9, 5, 3, 6, 4, 5);
        int targetSum = 10;
        List<List<Integer>> pairs = findingPairsOfNumbers(numbers, targetSum);
        System.out.println("Pairs of numbers with sum " + targetSum + " is: " + pairs);

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Poland", "Warsaw");
        countriesAndCapitals.put("France", "Paris");
        countriesAndCapitals.put("Australia", "Canberra");
        countriesAndCapitals.put("Russia", "Moscow");
        List<String> capitals = sortedCountry(countriesAndCapitals);
        System.out.println("Sorted capitals of countries:" + capitals);

        List<String> inputStrings = Arrays.asList("apple", "banana", "123", "dog", "cat", "apricot");
        char alphabet = 'a';
        List<String> filteredAndSortedStrings = filterChar(inputStrings, alphabet);
        System.out.println("Filtered and sorted strings:" + filteredAndSortedStrings);

        HashMap<String, List<String>> friendsGraph = new HashMap<>();
        friendsGraph.put("Alice", List.of("Bob", "Vasia"));
        friendsGraph.put("Bob", List.of("Alice", "Petia"));
        friendsGraph.put("Vasia", List.of("Alice", "Natasha"));
        friendsGraph.put("Petia", List.of("Bob", "Natasha"));
        friendsGraph.put("Natasha", List.of("Чарли", "Petia"));
        Set<List<String>> unfriendlyPairs = UnfriendlyPairs.findUnfriendlyPairs(friendsGraph);
        System.out.println("Unfriendly pairs is:" + unfriendlyPairs);

        List<Employee> employees = Arrays.asList();
        new Employee("John", 100000.0, "IT");
        new Employee("Maria", 105000.0, "IT");
        new Employee("Elon", 444000.0, "Administration");
        new Employee("Mike", 500000.0, "Administration");
        new Employee("John", 33000.0, "Marketing");
        new Employee("John", 44000.0, "Marketing");
        Map<String, Double> averageSalariesByDepartment = Employee.findAverageSalaryByDepartment(employees);
        averageSalariesByDepartment.forEach((departmen,salary) ->
                System.out.println("The average salaries in departmen - " + departmen + " is:"  + salary));
    }
}
package faang.school.godbless.StreameAPI_2;

import java.util.*;

import static faang.school.godbless.StreameAPI_2.CountriesAndCapitals.sortedCountry;
import static faang.school.godbless.StreameAPI_2.Employee.findAverageSalaryByDepartment;
import static faang.school.godbless.StreameAPI_2.FilterAndSortStrings.findStringsContainsOnlyThisAlphabet;
import static faang.school.godbless.StreameAPI_2.FilterOfString.filterChar;
import static faang.school.godbless.StreameAPI_2.PairSum.findingPairsOfNumbers;
import static faang.school.godbless.StreameAPI_2.ConversionListToString.convertNumbersToString;
import static faang.school.godbless.StreameAPI_2.Palindrome.findPalindrome;

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
        Map<String, Double> averageSalariesByDepartment = findAverageSalaryByDepartment(employees);
        System.out.println(averageSalariesByDepartment);

        List<String> inputString = Arrays.asList("apple", "banana", "123", "dog", "kc", "kukumber", "кино");
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        List<String> findStringsContainsOnlyThisAlphabet = findStringsContainsOnlyThisAlphabet(inputString, alphabets);
        System.out.println("Sorted strings in ascending order of their length: " + findStringsContainsOnlyThisAlphabet);

        List<Integer> number = Arrays.asList(1, 3, 44, 75);
        List<String> binaryString = convertNumbersToString(number);
        System.out.println("A list of numbers in binary notation is: " + binaryString);

        int startOfRange = 100;
        int endOfRange = 125;
        List<Integer> palindromes = findPalindrome(startOfRange, endOfRange);
        System.out.println("Palindrome numbers between " + startOfRange + " and " + endOfRange + ":");
        palindromes.forEach(System.out::println);
    }
}
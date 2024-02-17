package faang.school.godbless.streamAPI2;

import com.sun.jdi.connect.spi.Connection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String... args) {
        List<Integer> integerList = List.of(1, 9, 3, 6, 4, 5);
        int targetSum = 10;
        System.out.println(findPairs(integerList, targetSum));
        Map<String, String> countriesAndCapitals = new HashMap<>(Map.of(
                "Russia", "Moscow",
                "Japan", "Tokio",
                "China", "Beijing",
                "USA","Washington"));
        System.out.println(capitalsOfSortedCountries(countriesAndCapitals));
        List<String> strings = List.of("argue", "vote", "pair", "something", "apple", "skin", "advisor", "advertisment");
        Character ch = 'a';
        System.out.println(sortedListStartedWith(strings, ch));
        Map<String, List<String>> friends = new HashMap<>(Map.of(
                "Jhon", new ArrayList<>(List.of("Sarah", "Terminator", "Jake")),
                "Sarah", new ArrayList<>(List.of("Jhon", "Kyle")),
                "Jake", new ArrayList<>(List.of("Michelle", "Montgomery")),
                "Bart", new ArrayList<>(List.of("Lisa", "Homer", "Bartolomey", "Marj", "Meggy")),
                "Homer", new ArrayList<>(List.of("Marj", "Abraham", "Monthomery")),
                "Leonardo", new ArrayList<>(List.of("Donatello", "Rafael", "Mickelangelo", "April", "Splinter")),
                "April", new ArrayList<>(List.of("Kesey","Donatello", "Rafael", "Leonardo", "Mickelangelo")),
                "Kesey", new ArrayList<>(List.of("April", "Splinter"))
                ));
        System.out.println("CommonFriends: " + getFriendsPairs(friends));
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Elon", 100000.0, "Tesla"),
                new Employee("Bill", 1000000.0, "Microsoft"),
                new Employee("Jhon", 5000.0, "Microsoft"),
                new Employee("Jack", 53000.0, "Tesla"),
                new Employee("Sarah", 83000.0, "Tesla")
        ));
        System.out.println("Average salary by departments: " + averageSalaryByDepartments(employees));
        List<String> words = new ArrayList<>(List.of(
                "sugar", "apple", "banana", "Grapefruit", "21century"
        ));
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        System.out.println("sorted alphabet words: " + sortAlphabetWords(words, alphabet));
        System.out.println("Binary digits are: " + getBinaryListFromInt(integerList));
        System.out.println("Palindrom digits in between 10 and 100 are: " + getPalindromDigits(10, 100));
    }

    private static List<Integer> getPalindromDigits(int start, int finish) {
        return IntStream.rangeClosed(start, finish)
                .mapToObj(integer -> String.valueOf(integer))
                .filter(string -> string.equals(new StringBuilder(string).reverse().toString()))
                .map(string -> Integer.parseInt(string))
                .toList();
    }

    private static List<String> getBinaryListFromInt(List<Integer> integerList) {
        return integerList.stream()
                .map(integer -> Integer.toBinaryString(integer))
                .toList();
    }

    private static List<String> sortAlphabetWords(List<String> words, char[] alphabet) {
        return words.stream()
                .filter(word -> word.chars().allMatch(chars -> Arrays.binarySearch(alphabet, (char) chars) >= 0))
                .sorted((word1, word2) -> word1.compareTo(word2))
                .toList();
    }

    private static Map<String, Double> averageSalaryByDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(),
                        Collectors.averagingDouble(employee -> employee.getSalary())));
    }

    private static List<List<String>> getFriendsPairs(Map<String, List<String>> friends) {
        return friends.entrySet().stream()
                .flatMap(entry -> friends.entrySet().stream()
                        .filter(entry2 -> !entry2.getKey().equalsIgnoreCase(entry.getKey()))
                        .filter(entry2 -> !entry2.getValue().contains(entry.getKey()))
                        .filter(entry2 -> !Collections.disjoint(entry.getValue(), entry2.getValue()))
                        .map(entry2 -> Arrays.asList(entry.getKey(), entry2.getKey())))
                        .toList();
    }

    private static List<String> sortedListStartedWith(List<String> strings, Character ch) {
        return strings.stream()
                .filter(string -> string.charAt(0) == ch)
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toList();
    }

    private static List<String> capitalsOfSortedCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted((country1, country2) -> country1.getKey().compareTo(country2.getKey()))
                .map(entry -> entry.getValue())
                .toList();

    }

    private static List<List<Integer>> findPairs(List<Integer> integerList, int targetSum) {
        return integerList.stream()
                .filter(first -> integerList.contains(targetSum-first))
                .filter(first -> integerList.indexOf(first) < integerList.indexOf(targetSum-first))
                .map(first -> Arrays.asList(first, targetSum-first))
                .collect(Collectors.toList());
    }
}

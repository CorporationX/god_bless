package faang.school.godbless.trainingstreamapi2_2639;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static final List<Integer> NUMBERS = new ArrayList<>(List.of(2, 5, 7, 9, 4, 3, 8, 6, 1));
    static final Map<String, String> COUNTRIES = new HashMap<>(Map.of(
            "Russia", "Moscow",
            "Spain", "Madrid",
            "Armenia", "Yerevan",
            "China", "Beijing",
            "Poland", "Warsaw"));
    static final List<String> WORDS = new ArrayList<>(List.of(
            "Apple",
            "Cat",
            "Dog",
            "Dumbbell",
            "Dwarf",
            "Wizard",
            "People"
    ));
    static final Map<String, List<String>> FRIENDS = new HashMap<>(Map.of(
            "Dima", new ArrayList<>(List.of("Timur", "Misha", "Vitaliy")),
            "Vitaliy", new ArrayList<>(List.of("Misha", "Dima", "Oleg")),
            "Timur", new ArrayList<>(List.of("Misha", "Dima", "Katya")),
            "Vlad", new ArrayList<>(List.of("Oleg", "Katya"))
    ));
    static final List<Employee> EMPLOYEES = new ArrayList<>(List.of(
            new Employee("Dima", "Finance", 85000),
            new Employee("Tanya", "Finance", 90000),
            new Employee("Larisa", "Finance", 120000),
            new Employee("Aleksandr", "IT", 200000),
            new Employee("Ruslan", "IT", 250000)
    ));
    static final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v'};

    public static void main(String[] args) {
        System.out.println(getPairsWhichSumEqualsTarget(13, NUMBERS));
        System.out.println(getCapitalsOfSortedCountries(COUNTRIES));
        System.out.println(getSortedWordsStartsWith('D', WORDS));
        System.out.println(getMutualFriendsPairs(FRIENDS));
        System.out.println(getDepartmentAverageSalary(EMPLOYEES));
        System.out.println(sortAndFilterWords(WORDS, ALPHABET));
        System.out.println(mapIntegersToBinaryStrings(NUMBERS));
        System.out.println(findPalindomNumbers(1, 500));
    }

    // 1
    public static Set<List<Integer>> getPairsWhichSumEqualsTarget(int target, List<Integer> numberList) {
        return numberList.stream()
                .flatMap(number1 -> numberList.stream()
                        .filter(number2 -> {
                            final int numberToCheck = numberList.indexOf(number1);
                            return numberToCheck < numberList.indexOf(number2);
                        })
                        .filter(number2 -> number1 + number2 == target)
                        .map(number2 -> Arrays.asList(number1, number2)))
                .collect(Collectors.toSet());
    }

    // 2
    public static List<String> getCapitalsOfSortedCountries(Map<String, String> countriesMap) {
        return countriesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getValue())
                .toList();

    }

    // 3
    public static List<String> getSortedWordsStartsWith(char firstLetter, List<String> wordList) {
        return wordList.stream()
                .filter(word -> word.charAt(0) == firstLetter)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // 4
    public static List<List<String>> getMutualFriendsPairs(Map<String, List<String>> friendMap) {
        return friendMap.entrySet().stream()
                .flatMap(entry1 -> friendMap.entrySet().stream()
                        .filter(entry2 -> !entry2.getKey().equalsIgnoreCase(entry1.getKey()))
                        .filter(entry2 -> !entry2.getValue().contains(entry1.getKey()))
                        .filter(entry2 -> !Collections.disjoint(entry2.getValue(), entry1.getValue()))
                        .map(entry2 -> Arrays.asList(entry1.getKey(), entry2.getKey())))
                .toList();
    }

    // 5
    public static Map<String, Double> getDepartmentAverageSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(),
                        Collectors.averagingDouble(employee -> employee.getSalary())));
    }

    // 6
    public static List<String> sortAndFilterWords(List<String> wordList, char[] alphabet) {
        Arrays.sort(alphabet);
        return wordList.stream()
                .filter(word -> word.toLowerCase().chars().allMatch(chars -> Arrays.binarySearch(alphabet, (char) chars) >= 0))
                .sorted((word1, word2) -> word1.compareTo(word2))
                .toList();
    }

    // 7
    public static List<String> mapIntegersToBinaryStrings(List<Integer> numberList) {
        return numberList.stream()
                .map(number -> Integer.toBinaryString(number))
                .toList();
    }

    // 8
    public static List<Integer> findPalindomNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(number -> Integer.toString(number))
                .filter(string -> string.equals(new StringBuilder(string).reverse().toString()))
                .map(string -> Integer.parseInt(string))
                .toList();
    }
}

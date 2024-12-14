package faang.school.godbless.stream_api_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 9, 3, 6, 4, 5);
        findPairWhoseSumEqualsValue(numberList, 10);

        Map<String, String> countryMap = new HashMap<>(Map.of("Russia", "Moscow",
                "China", "Beijing",
                "USA", "Washington"));
        sortCountriesAlphabetically(countryMap);

        List<String> stringList = Arrays.asList("строка", "строк", "пук", "стр");
        System.out.println(sortStringsByCharAndLength(stringList, 'с'));

        Map<String, List<String>> personWithFriendsMap = new HashMap<>();
        personWithFriendsMap.put("Варя", new ArrayList<>(List.of("Аня", "Петя", "Вася")));
        personWithFriendsMap.put("Аня", new ArrayList<>(List.of("Маша", "Петя", "Рома")));
        personWithFriendsMap.put("Миша", new ArrayList<>(List.of("Варя", "Катя", "Рома")));

        findMutualFriends(personWithFriendsMap);

        List<Employee> employeeList = new ArrayList<>(List.of(new Employee("Варя", 150000, "надзор"),
                new Employee("Петя", 200000, "надзор"),
                new Employee("Лена", 100000, "госуслуги"),
                new Employee("Саша", 80000, "госуслуги"),
                new Employee("Вася", 50000, "кадры"),
                new Employee("Таня", 60000, "кадры")));

        Map<String, Double> departmentAverageSalaryMap = getDepartmentAverageSalary(employeeList);
        departmentAverageSalaryMap.entrySet().forEach(System.out::println);

        List<String> strings = Arrays.asList("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        filterWordsByLettersAndLength(strings, alphabet);

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        convertBinaryToString(numbers);

        findPalindromesBySpan(1, 100);

    }

    private static void findPairWhoseSumEqualsValue(List<Integer> numberList, int value) {
        numberList.stream()
                .flatMap(currentNumber -> numberList.stream()
                        .filter(nextNumber -> !currentNumber.equals(nextNumber) &&
                                currentNumber < nextNumber &&
                                currentNumber + nextNumber == value)
                        .map(nextNumber -> "[" + currentNumber + ", " + nextNumber + "]")
                )
                .forEach(System.out::println);
    }

    private static void sortCountriesAlphabetically(Map<String, String> countryMap) {
        countryMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }

    private static List<String> sortStringsByCharAndLength(List<String> stringList, char letter) {
        return stringList.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static void findMutualFriends(Map<String, List<String>> map) {
        map.forEach((currentKey, currentValue) -> map.forEach((nextKey, nextValue) -> {
            if (!currentKey.equals(nextKey) &&
                    !currentValue.contains(nextKey) &&
                    nextValue.stream().anyMatch(currentValue::contains) &&
                    currentKey.compareTo(nextKey) < 0) {
                System.out.println(currentKey + " - " + nextKey);
            }
        }));
    }

    private static Map<String, Double> getDepartmentAverageSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    private static void filterWordsByLettersAndLength(List<String> stringList, char[] letters) {
        stringList.stream()
                .filter(word -> word.chars().allMatch(c -> Arrays.toString(letters).indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    private static void convertBinaryToString(List<Integer> numberList) {
        numberList.forEach(number -> System.out.println(number + " - " + Integer.toBinaryString(number)));
    }

    private static void findPalindromesBySpan(int startValue, int endValue) {
        IntStream.range(startValue, endValue)
                .filter(number -> !List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).contains(number))
                .filter(number ->
                        String.valueOf(number).equals(new StringBuilder(String.valueOf(number)).reverse().toString()))
                .forEach(System.out::println);
    }
}

package faang.school.godbless.stream_api.training_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // 1 задача
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int target = 10;
        System.out.println(findUniquePairsWithSum(numbers, target));

        // 2 задача
        System.out.println(sortCountriesAndPrintCapitals(Map.of("Russia", "Moscow", "France", "Paris", "Japan", "Tokyo", "China", "Beijing")));

        // 3
        System.out.println(filterAndSortByInitialLetter(List.of("Kirill", "Karina", "Katrin", "Oleg", "Konstantin"), 'K'));

        // 4 задача
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Alice", Arrays.asList("Bob", "Charlie", "David"));
        friends.put("Bob", Arrays.asList("Alice", "Eve"));
        friends.put("Charlie", Arrays.asList("Alice", "David"));
        friends.put("David", Arrays.asList("Alice", "Charlie"));
        friends.put("Eve", Arrays.asList("Bob"));


        List<List<String>> pairs = findNonFriendPairsWithCommonFriends(friends);
        System.out.println("Common friends: " + pairs);

        // 5 задача
        Employee firstEmployee = new Employee("Kirill", 10000, "RZD");
        Employee secondEmployee = new Employee("Mark", 20000, "RZD");
        Employee thirdEmployee = new Employee("Andrey", 70000, "YANDEX");
        Employee fourthEmployee = new Employee("Yaroslav", 100000, "YANDEX");
        List<Employee> employees = List.of(firstEmployee, secondEmployee, thirdEmployee, fourthEmployee);
        System.out.println(calculateAverageSalaryByDepartment(employees));

        // 6 задача
        List<String> strings = Arrays.asList("apple", "banana", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> result = filterAndSortByAlphabet(strings, alphabet);
        System.out.println("Result: " + result);

        // 7 задача
        List<Integer> integerList = List.of(10, 111, 30, 12, 16);
        System.out.println(convertToBinaryStrings(integerList));


        // 8 задача
        int from = 1;
        int to = 300;

        System.out.println(findPalindromeNumbersInRange(from, to));


    }

    public static Set<List<Integer>> findUniquePairsWithSum(List<Integer> numbersList, Integer targetSum) {
        return numbersList.stream()
                .flatMap(num1 -> numbersList.stream()
                        .filter(num2 -> num1 + num2 == targetSum && !num1.equals(num2))
                        .map(num2 -> Arrays.asList(num1, num2).stream()
                                .sorted().collect(Collectors.toList())))
                .collect(Collectors.toSet());

    }

    public static List<String> sortCountriesAndPrintCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> filterAndSortByInitialLetter(List<String> wordList, char letter) {
        return wordList.stream()
                .filter(word -> word.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }


    public static List<List<String>> findNonFriendPairsWithCommonFriends(Map<String, List<String>> friends) {
        return friends.entrySet().stream()
                .flatMap(outerEntry -> friends.entrySet().stream()
                        .filter(innerEntry -> !outerEntry.getKey().equals(innerEntry.getKey()))
                        .filter(innerEntry -> !outerEntry.getValue().contains(innerEntry.getKey()))
                        .filter(innerEntry -> outerEntry.getValue().stream().anyMatch(friend -> innerEntry.getValue().contains(friend)))
                        .map(innerEntry -> Stream.of(innerEntry.getKey(), outerEntry.getKey()).sorted().toList()))
                .distinct()
                .toList();

    }

    public static Map<String, Double> calculateAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(word -> {
                    for (int i = 0; i < word.length(); i++) {
                        if (!alphabet.contains(String.valueOf(word.charAt(i)))) {
                            return false;
                        }
                    }
                    return true;
                })
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinaryStrings(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromeNumbersInRange(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(num -> {
                    StringBuilder reversed = new StringBuilder(String.valueOf(num)).reverse();
                    return String.valueOf(num).contentEquals(reversed);
                })
                .boxed()
                .toList();
    }

}

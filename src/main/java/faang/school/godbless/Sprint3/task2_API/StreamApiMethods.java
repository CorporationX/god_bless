package faang.school.godbless.Sprint3.task2_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiMethods {

    public static Set<List<Integer>> uniqueCouples(List<Integer> numbers, Integer sum) {
        return numbers.stream()
                .flatMap(n1 -> numbers.stream()
                        .filter(n2 -> n1 <= n2)
                        .filter(n2 -> n1 + n2 == sum)
                        .map(n2 -> {
                            List<Integer> couple = new ArrayList<>();
                            couple.add(n1);
                            couple.add(n2);
                            return couple;
                        }))
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> stringFilterStartingChar(List<String> strings, char firstChar) {
        return strings.stream()
                .filter(string -> string.charAt(0) == firstChar)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<List<String>> searchPairsUnfriendsWithMutualFriends(Map<String, List<String>> friends) {
        List<List<String>> pairs = new ArrayList<>();

        friends.entrySet().stream()
                .flatMap(entry1 -> friends.entrySet().stream()
                        .filter(entry2 -> !entry2.getKey().equals(entry1.getKey()))
                        .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                        .filter(entry2 -> entry1.getValue().stream().anyMatch(entry2.getValue()::contains))
                        .filter(entry2 -> entry1.getKey().compareTo(entry2.getKey()) < 0)
                        .map(entry2 -> Arrays.asList(entry1.getKey(), entry2.getKey())))
                .forEach(pairs::add);
        return pairs;
    }

    public static Map<String, Double> getAverageSalaries(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> stringFilterContainsAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertNumbersToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPalindromesInRange(int startRange, int endRange) {
        return IntStream.range(startRange, endRange)
                .filter(number -> {
                    String numberString = String.valueOf(number);
                    String reversNumberString = new StringBuilder(numberString).reverse().toString();
                    return numberString.equals(reversNumberString);
                })
                .boxed()
                .collect(Collectors.toList());
    }
}
package faang.school.godbless.sprint2.streamAPI.BJS2_22432;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tasks {

    public static void printPairsWithSum(List<Integer> numbers, int targetSum) {
        Set<List<Integer>> uniquePairs = numbers.stream()
                .flatMap(n -> numbers.stream()
                        .filter(seen -> seen != n && n + seen == targetSum)
                        .map(seen -> Arrays.asList(n, seen))
                        .filter(pair -> pair.get(0) < pair.get(1))
                )
                .collect(Collectors.toSet());

        System.out.println("Input list: " + numbers);
        System.out.println("Target sum: " + targetSum);

        System.out.print("Pairs: ");
        if (uniquePairs.isEmpty()) {
            System.out.println("No pairs found");
        } else {
            System.out.println(uniquePairs.stream()
                    .map(pair -> "[" + pair.get(0) + ", " + pair.get(1) + "]")
                    .collect(Collectors.joining(", ")));
        }
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStringsByLength(List<String> strings, char startingLetter) {
        return strings.stream()
                .filter(w -> w.startsWith(String.valueOf(startingLetter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> findNonFriendPairsWithCommonFriends(Map<String, List<String>> friendships) {
        return friendships.entrySet().stream()
                .flatMap(person -> friendships.entrySet().stream()
                        .filter(person2 -> !person.getKey().equals(person2.getKey()))
                        .filter(person2 -> !person.getValue().contains(person2.getKey()))
                        .filter(person2 -> person.getValue().stream().anyMatch(person2.getValue()::contains))
                        .map(person2 -> Arrays.asList(person.getKey(), person2.getKey()))
                )
                .map(pair -> pair.stream().sorted().toList())
                .distinct()
                .toList();
    }

    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, char[] alphabet) {
        Set<Character> charSet = IntStream.range(0, alphabet.length)
                .mapToObj(i -> alphabet[i])
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(string -> string.chars().allMatch(c -> charSet.contains(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromesInRange(int start, int end) {
        List<Integer> allRange = new ArrayList<>();
        IntStream.range(start, end).forEach(allRange::add);
        return allRange.stream()
                .map(String::valueOf)
                .filter(string -> new StringBuilder(string).reverse().toString().equals(string))
                .map(Integer::valueOf)
                .toList();
    }

    public static List<String> findAllPalindromicSubstrings(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(start -> IntStream.range(start + 1, input.length() + 1)
                        .mapToObj(end -> input.substring(start, end))
                )
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
                .collect(Collectors.toList());
    }
}
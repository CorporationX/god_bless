package faang.school.godbless.StreamPattent2;

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
        System.out.println("findUniqueCombinationsThatEqualsTo: ");
        Map<Integer, Integer> m1 = findUniqueCombinationsThatEqualsTo(List.of(1, 9, 3, 6, 4, 5), 10);
        m1.forEach((key, value) -> System.out.println("----" + key + " -> " + value));

        System.out.println("sortCountriesAndGetCapitals: ");
        List<String> l1 = sortCountriesAndGetCapitals(Map.of("Russia", "Moscow",
                "Germany", "Munich",
                "Japan", "Tokio"));
        l1.forEach(value -> System.out.println("----" + value));

        System.out.println("getWordsThatStartsWithCharAndSortByLength: ");
        List<String> l2 = getWordsThatStartsWithCharAndSortByLength(List.of("Apple","Amazon","Google"), 'A');
        l2.forEach(value -> System.out.println("----" + value));

        System.out.println("getAllFriendOfFriends: ");
        HashMap<String, String> m2 = getAllFriendOfFriends(Map.of("Tem", List.of("Den","Arcash"),
                "Den", List.of("Tem"),
                "Arcash", List.of("Tem")));
        m2.forEach((key, value) -> System.out.println("----" + key + " -> " + value));

        System.out.println("findAverageSalaryForEachDepartment: ");
        Map<String, Double> m3 = findAverageSalaryForEachDepartment(List.of(new Employee("Tem","Student", 15),
                new Employee("Den","Student", 10),
                new Employee("Arcash", "Yandex", 200)));
        m3.forEach((key, value) -> System.out.println("----" + key + " -> " + value));

        System.out.println("getWordsWithOnlyChars: ");
        List<String> l3 = getWordsWithOnlyChars(List.of("Google","Amazon","Apple"), new char[]{'e','l'});
        l3.forEach(value -> System.out.println("----" + value));

        System.out.println("getBinary: ");
        List<String> l4 = getBinary(List.of(1, 3, 4 ,2));
        l4.forEach(value -> System.out.println("----" + value));

        System.out.println("getPalindromeNumsOnInterval: ");
        List<Integer> l5 = getPalindromeNumsOnInterval(100, 130);
        l5.forEach(value -> System.out.println("----" + value));

        System.out.println("getPalindromeSubstrings: ");
        List<String> l6 = getPalindromeSubstrings("aaa");
        l6.forEach(value -> System.out.println("----" + value));

        System.out.println("getPerfectNumbers: ");
        List<Integer> l7 = getPerfectNumbers(0, 10);
        l7.forEach(value -> System.out.println("----" + value));
    }

    private static Map<Integer, Integer> findUniqueCombinationsThatEqualsTo(List<Integer> nums, int target) {
        Map<Integer, Integer> pairs = new HashMap<>();
        nums.forEach(num -> {
            int subSum = target - num;
            if (pairs.containsKey(num)) {
                pairs.put(num, subSum);
            } else {
                pairs.put(subSum, null);
            }
        });

        return pairs.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static List<String> sortCountriesAndGetCapitals(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    private static List<String> getWordsThatStartsWithCharAndSortByLength(List<String> words, char ch) {
        return words.stream()
                .filter(word -> word.charAt(0) == ch)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static HashMap<String, String> getAllFriendOfFriends(Map<String, List<String>> peoplesFriends) {
        HashMap<String, String> pairs = new HashMap<>();
        peoplesFriends.forEach((key, value) -> peoplesFriends.entrySet().stream()
                .filter(entry -> !key.equals(entry.getKey()) && !value.contains(entry.getKey()))
                .forEach(entry -> entry.getValue().stream()
                        .filter(value::contains)
                        .forEach(friend -> pairs.put(entry.getKey(), key)))
                );
        return pairs;
    }

    private static Map<String, Double> findAverageSalaryForEachDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    private static List<String> getWordsWithOnlyChars(List<String> words, char[] chars) {
        String letters = new String(chars);
        return words.stream()
                .filter(word -> Arrays.stream(letters.split(""))
                        .allMatch(word::contains))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static List<String> getBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    private static List<Integer> getPalindromeNumsOnInterval(int left, int right) {
        return IntStream.range(left, right)
                .mapToObj(String::valueOf)
                .filter(num -> new StringBuilder(num).reverse().toString().equals(num))
                .map(Integer::parseInt)
                .toList();
    }

    private static List<String> getPalindromeSubstrings(String word) {
        List<String> palindromes = new ArrayList<>();
        IntStream.range(0, word.length())
                .forEach(i -> IntStream.range(i, word.length())
                        .mapToObj(j -> word.substring(i, j + 1))
                        .filter(substring -> new StringBuilder(substring).reverse().toString().equals(substring))
                        .collect(Collectors.toCollection(() -> palindromes))
                );
        return palindromes;
    }

    private static List<Integer> getPerfectNumbers(int left, int right) {
         return IntStream.range(left, right)
                .filter(num -> IntStream.range(1, num)
                        .filter(divider -> num % divider == 0)
                        .sum() == num
                )
                .boxed()
                .toList();
    }
}

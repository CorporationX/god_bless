package stream.training2;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(getNumberPairs(List.of(1, 9, 3, 6, 4, 5), 10));
        System.out.println(getSortedCapitals(Map.of(
                "Russia", "Moscow",
                "China", "Beijing",
                "Austria", "Vien",
                "Bulgaria", "Sofia")));
        System.out.println(getSortedStringsStartedWithLetter(List.of("abababab", "abab", "ab", "abccc", "bcbc", "edfdd"), 'a'));
        System.out.println(getPeoplePairsWithSameFriends(Map.of(
                "Petya", List.of("Vasya", "Vanya"),
                "Vasya", List.of("Petya", "Kolya"),
                "Vanya", List.of("Petya"),
                "Kolya", List.of("Vasya"))));
        System.out.println(getSortedStringWithLetterInAlphabet(List.of(
                "abc", "abccba", "ab", "c", "defaef", "asasfe"), new char[]{'a', 'b', 'c'}));
        System.out.println(getAverageSalaryForDepartment(List.of(
                new Employee("Vanya", "IT", 2300),
                new Employee("Vasya", "HR", 1700),
                new Employee("Petya", "IT", 3000),
                new Employee("Katya", "HR", 2000))));
        System.out.println(getBinaryStringOfNumber(List.of(1, 2, 3, 4, 5, 18, 22, 56)));
        System.out.println(getAllNumberPalindromes(100, 300));
        System.out.println(getAllPalindromicSubstrings("abcbef"));
        System.out.println(getAllPerfectNumbers(1, 10000));
    }

    public static List<List<Integer>> getNumberPairs(@NonNull List<Integer> numbers, int targetSum) {
        return IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .mapToObj(j -> List.of(numbers.get(i), numbers.get(j))))
                .filter(pair -> pair.get(0) + pair.get(1) == targetSum)
                .collect(Collectors.toList());
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> countriesCapitals) {
        return countriesCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getSortedStringsStartedWithLetter(@NonNull List<String> lines, char letter) {
        return lines.stream()
                .filter(line -> line.startsWith(Character.toString(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<List<String>> getPeoplePairsWithSameFriends(@NonNull Map<String, @NonNull List<String>> peopleFriends) {
        List<String> peoples = peopleFriends.keySet().stream().toList();
        return IntStream.range(0, peoples.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, peoples.size())
                        .mapToObj(j -> List.of(peoples.get(i), peoples.get(j))))
                .filter(pair -> !peopleFriends.get(pair.get(0)).contains(pair.get(1)))
                .filter(pair -> new ArrayList<>(
                        peopleFriends.get(pair.get(0))).removeAll(peopleFriends.get(pair.get(1))))
                .toList();
    }

    public static List<String> getSortedStringWithLetterInAlphabet(@NonNull List<String> lines, @NonNull char[] alphabet) {
        return lines.stream()
                .filter(line -> line.matches(String.format("[%s]+", new String(alphabet))))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static Map<String, Double> getAverageSalaryForDepartment(@NonNull List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> getBinaryStringOfNumber(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> getAllNumberPalindromes(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .filter(n -> isPalindrome(n.toString()))
                .toList();
    }

    public static List<String> getAllPalindromicSubstrings(@NonNull String line) {
        return IntStream.range(0, line.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, line.length() + 1)
                        .mapToObj(j -> line.substring(i, j)))
                .filter(Main::isPalindrome)
                .distinct()
                .toList();
    }

    public static List<Integer> getAllPerfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .filter(Main::isPerfectNumber)
                .toList();
    }

    private static boolean isPalindrome(@NonNull String line) {
        return line.substring(0, line.length() / 2).contentEquals(new StringBuilder(
                line.substring(line.length() - line.length() / 2)).reverse());
    }

    private static boolean isPerfectNumber(int number) {
        return number == IntStream.rangeClosed(1, number / 2)
                .filter(i -> number % i == 0)
                .sum();
    }
}

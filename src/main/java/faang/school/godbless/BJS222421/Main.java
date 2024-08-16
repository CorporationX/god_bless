package faang.school.godbless.BJS222421;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static List<Map<Integer, Integer>> findPairsWithSum(List<Integer> numbers, int targetSum) {
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);

        return numbers.stream()
                .filter(number -> number < average)
                .flatMap(i -> numbers.stream()
                        .filter(number -> number > average)
                        .filter(j -> i + j == targetSum)
                        .map(j -> Map.of(i, j)))
                .collect(Collectors.toList());
    }

    public static List<String> sortCountriesAndReturnCapitals(Map<String, String> countries){
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStringsByChar(List<String> strings, char c){
        return strings.stream()
                .filter(string -> string.startsWith(Character.toString(c)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<Map<String, String>> findPeopleWithCommonFriends(Map<String, List<String>> nameFriends){
        return nameFriends.entrySet().stream()
                .flatMap(i -> nameFriends.entrySet().stream()
                        .filter(j -> !i.getValue().contains(j.getKey()) && !i.getKey().equals(j.getKey()))
                        .filter(j -> i.getValue().stream().anyMatch(friend -> j.getValue().contains(friend)))
                        .map(j -> Map.of(i.getKey(), j.getKey()))
                )
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<String, Double> calculateAverageSalaryByDepartment(List<Employee> employees){
        return employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
    }

    public static List<String> filterAndSortStringsByAlphabet(List<String> strings, String alphabet){
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .filter(string -> Arrays.stream(string.split("")).allMatch(alphabet::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinaryStrings(List<Integer> numbers){
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List findPalindromeNumbersInRange(Integer left, Integer right) {
        Stream<Integer> numbers = Stream
                .iterate(left, n -> n + 1)
                .limit(right - left + 1);

        return numbers
                .filter(i -> {
                    var n = String.valueOf(i);
                    return n.equals(new StringBuilder(n).reverse().toString());
                })
                .toList();
    }

    public static List<String> findPalindromeSubstrings(String string){
        var numbers = Stream
                .iterate(0, n -> n + 1)
                .limit(string.length())
                .toList();

        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> numbers.indexOf(i) < numbers.indexOf(j))
                        .map(j -> string.substring(i, j + 1)))
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .distinct()
                .toList();
    }

    public static List findPerfectNumbersInRange(String word) {
        return IntStream
                .range(0, word.length())
                .boxed()
                .flatMap(index -> IntStream
                        .rangeClosed(index + 1, word.length())
                        .filter(endIndex -> isPalindrome(word, index, endIndex))
                        .mapToObj(endIndex -> word.substring(index, endIndex))).toList();
    }

    private static boolean isPalindrome(String word, int start, int end) {
        String currentWord = word.substring(start, end);
        return currentWord.contentEquals(new StringBuffer(currentWord).reverse());
    }
}

package faang.school.godbless.streamAPI_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 8, 23, 5, 7, 9);
        getCouplesEqualBy(12, numbers).forEach(System.out::println);

        List<Employee> workers = List.of(new Employee("Tom", 3400, "IT"),
                new Employee("Kety", 3900, "IT"),
                new Employee("Sam", 6000, "Accounting"),
                new Employee("Alex", 9000, "Accounting"));
        groupByDepartment(workers).entrySet().forEach(System.out::println);

        Map<String, List<String>> people = new HashMap<>();
        people.put("Tom", List.of("Bob", "Sam", "Ben"));
        people.put("Sam", List.of("Kety", "Sergey", "Ivan"));
        people.put("Ken", List.of("Alex", "Sam", "Ivan"));
        findCoupleNoFriends(people).forEach(System.out::println);

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("Slovakia", "Bratislava");
        countries.put("Austria", "Vein");
        countries.put("Belgium", "Brussels");
        groupCountries(countries).forEach(System.out::println);

        List<String> strings = List.of("accounting", "snow2", "new years", "apple", "auto", "123");
        groupByFirstSymbol(strings, 'a').forEach(System.out::println);

        System.out.println("Alphabet_task:");
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        getWordsFromAlphabet(strings, alphabet).forEach(System.out::println);

        toBinaryForm(numbers).forEach(System.out::println);

        Arrays.stream(findNumberPalindromic(1, 100)).forEach(System.out::println);

        String string = "strings bob are used wsw for storing ete text";
        findStringPalindromic(string).forEach(System.out::println);

        System.out.println(Arrays.toString(findPerfectNumber(1, 1000)));
    }

    private static int[] findPerfectNumber(int start, int end) {
        return IntStream.range(start, end)
                .filter(n -> IntStream.range(1, n)
                        .filter(d -> n % d == 0)
                        .sum() == n)
                .toArray();
    }

    private static List<String> findStringPalindromic(String string) {
        return Arrays.stream(string.split(" "))
                .filter(s -> s.contentEquals(new StringBuffer(s).reverse()))
                .toList();
    }

    private static int[] findNumberPalindromic(Integer start, Integer end) {
        return IntStream.range(start, end)
                .filter(s1 -> s1 > 10)
                .filter(s1 -> String.valueOf(s1).contentEquals(new StringBuilder(String.valueOf(s1)).reverse()))
                .toArray();
    }

    private static List<String> toBinaryForm(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    private static List<String> getWordsFromAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s1 -> Arrays.stream(s1.split(""))
                        .allMatch(s2 -> alphabet.contains(s2)))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    private static List<String> groupByFirstSymbol(List<String> strings, char symbol) {
        return strings.stream().filter(s -> s.startsWith(new String(String.valueOf(symbol))))
                .sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    private static List<String> groupCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted((s1, s2) -> s1.getKey().compareTo(s2.getKey()))
                .map(Map.Entry::getValue).toList();
    }

    private static Map<String, Double> groupByDepartment(List<Employee> workers) {
        return workers.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
    }

    private static Set<List<Integer>> getCouplesEqualBy(int sum, List<Integer> numbers) {
        return numbers.stream()
                .flatMap(num -> numbers.stream()
                        .filter(num2 -> num2 + num == sum)
                        .map(num2 -> Stream.of(num, num2).sorted().toList()))
                .collect(Collectors.toSet());
    }

    private static Set<List<String>> findCoupleNoFriends(Map<String, List<String>> people) {
        return people.entrySet().stream()
                .flatMap(i -> people.entrySet().stream()
                        .filter(j -> j.getKey().equals(i.getKey()))
                        .filter(j -> j.getValue().contains(i.getKey()))
                        .filter(j -> i.getValue().contains(j.getKey())) // когда твой друг не считает тебя другом  )
                        .filter(j -> j.getValue().stream().anyMatch(f -> i.getValue().contains(f)))
                        .map(j -> Stream.of(j.getKey(), i.getKey()).sorted().toList()))
                .collect(Collectors.toSet());
    }
}

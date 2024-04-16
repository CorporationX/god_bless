package faang.school.godbless.streamapi2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        findUniquePairs(numbers, 6);

        Map<String, String> countryMap = Map.of("USA", "Washington", "Russia", "Moscow", "Germany", "Berlin");
        sortByCountry(countryMap).forEach(System.out::println);

        List<String> stringList = List.of("string 2 with", "string 1", "word which all knows", "super idea");
        filterByCharAndSortByLength(stringList, 's').forEach(System.out::println);

        Map<String, List<String>> friends = new HashMap<>();
        String vasya = "Vasya";
        String misha = "Misha";
        String sveta = "Sveta";
        String dima = "Dima";
        String max = "Max";
        String nikita = "Nikita";
        friends.put(vasya, List.of(sveta));
        friends.put(misha, List.of(sveta, dima));
        friends.put(sveta, List.of(max));
        friends.put(dima, List.of(nikita));
        findPairsPeopleWithMutualFriends(friends);

        Employee scott = new Employee("Scott", 2000, "IT");
        Employee smith = new Employee("Smith", 2500, "IT");
        Employee pitt = new Employee("Pitt", 15500, "VIDEO");
        Employee madsen = new Employee("Madsen", 4500, "VIDEO");
        Employee mask = new Employee("Mask", 50000, "Management");
        Employee besos = new Employee("Besos", 52000, "Management");
        List<Employee> employees = List.of(scott, smith, pitt, madsen, mask, besos);
        Map<String, Double> averageDepartmentSalary = findAverageDepartmentSalary(employees);
        for (Map.Entry<String, Double> entry : averageDepartmentSalary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        List<String> strings = List.of("apple", "banana", "123", "dog", "cat");
        String abc = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(filterAndSortList(strings, abc));

        List<Integer> integers = List.of(10, 11, 12, 13, 14);
        System.out.println(convertToBinaryStringList(integers));

        System.out.println(findPalindromeNumbers(10, 102));

        String palindrom = "qweewq";
        System.out.println(findPalindromeSubstrings(palindrom));

        System.out.println(findPerfectNumber(0, 100));

    }

    public static void findUniquePairs(List<Integer> numbers, Integer number) {
        IntStream.range(0, numbers.size())
                .forEach(elem1 -> IntStream.range(0, numbers.size())
                        .filter(elem2 -> elem2 != elem1 && numbers.get(elem1) + numbers.get(elem2) == number)
                        .forEach(elem2 -> System.out.println(numbers.get(elem1) + " + " + numbers.get(elem2) + " = " + number))
                );
    }

    public static List<String> sortByCountry(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterByCharAndSortByLength(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static void findPairsPeopleWithMutualFriends(Map<String, List<String>> names) {
        names.forEach((key, value) -> names.entrySet().stream()
                .filter(entry -> !entry.getValue().contains(key) && !key.equals(entry.getKey()))
                .filter(entry -> entry.getValue().stream().anyMatch(elem -> value.contains(elem)))
                .forEach(entry -> System.out.println(key + "<->" + entry.getKey())));
    }

    public static Map<String, Double> findAverageDepartmentSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterAndSortList(List<String> strings, String Alphabet) {
        return strings.stream()
                .filter(string -> IntStream.range(0, string.length())
                        .allMatch(symbol -> Alphabet.indexOf(string.charAt(symbol)) > -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinaryStringList(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString).toList();
    }

    public static List<String> findPalindromeNumbers(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(String::valueOf)
                .filter(string -> new StringBuilder(string).reverse().toString().equalsIgnoreCase(string))
                .toList();
    }

    public static List<String> findPalindromeSubstrings(String string) {
        List<String> result = new ArrayList<>();
        IntStream.rangeClosed(0, string.length())
                .forEach(number1 -> IntStream.rangeClosed(number1 + 2, string.length())
                        .mapToObj(number2 -> string.substring(number1, number2))
                        .filter(substring -> new StringBuilder(substring).reverse().toString().equalsIgnoreCase(substring))
                        .collect(Collectors.toCollection(() -> result)));
        return result;
    }

    public static List<Integer> findPerfectNumber(int start, int end) {
        return IntStream.range(start, end)
                .filter(number -> IntStream.range(1, number)
                        .filter(divider -> number % divider == 0)
                        .sum() == number)
                .boxed().toList();
    }

}

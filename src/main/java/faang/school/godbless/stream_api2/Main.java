package faang.school.godbless.stream_api2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //1
        List<Integer> list = Arrays.asList(1, 9, 3, 6, 4, 5);
        System.out.println("#1");
        findPairsWithSum(list, 10);

        //2
        Map<String, String> countries = Map.of(
                "Spain", "Madrid",
                "France", "Paris",
                "Italy", "Rome",
                "Germany", "Berlin"

        );
        System.out.println("#2");
        getSortCountries(countries);

        //3
        List<String> words = Arrays.asList("ball", "ocean", "theatre", "iron", "beef", "movie", "brave");
        char letter = 'b';
        System.out.println("#3");
        System.out.println(getSortWordsByLengthAndStartWithGivenLetter(words, letter));

        //#4
        Map<String, List<String>> people = Map.of(
                "Mike", List.of("Bob", "Tuk", "Bill"),
                "Tony", List.of("Eleena", "Lola", "Maria"),
                "Robin", List.of("Aaron", "Elena", "Bill"),
                "Chris", List.of("Mawria", "Bowb", "John")
        );
        Map<String, String> result = getFriendsWhoHasCommonFriends(people);
        System.out.println("#4");
        result.entrySet().stream().forEach(System.out::println);

        // #5
        List<Employee> employees = List.of(new Employee("Bob", "HR", 1200),
                new Employee("Tom", "HR", 2800),
                new Employee("Pups", "Dev", 900),
                new Employee("Hero", "QA", 1900),
                new Employee("Mike", "Dev", 3000),
                new Employee("Elena", "QA", 2500));

        Map<String, Double> resAvgSalaryByDepartment = averageSalaryOfDepartment(employees);
        System.out.println("#5");
        resAvgSalaryByDepartment.entrySet().stream().forEach(System.out::println);

        //#6
        List<String> inputStrings = Arrays.asList("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<String> filteredAndSortedStrings = filterAndSortStrings(inputStrings, alphabet);
        System.out.println("#6");
        System.out.println(filteredAndSortedStrings);

        //#7
        List<Integer> numbers = Arrays.asList(10, 5, 15, 7);

        List<String> binaryStrings = convertToBinaryStrings(numbers);
        System.out.println("#7: " + binaryStrings);

        //#8
        List<Integer> palindrome = getPalindromesInRange(100, 200);
        System.out.println("#8");
        palindrome.forEach(System.out::println);

    }

    // #1
    public static void findPairsWithSum(List<Integer> numbers, int targetSum) {
        numbers.stream()
                .flatMap(num1 -> numbers.stream()
                        .filter(num2 -> num1 != num2)
                        .filter(num2 -> num1 + num2 == targetSum)
                        .map(num2 -> List.of(num1, num2).stream().sorted().collect(Collectors.toList()))
                )
                .distinct()
                .forEach(System.out::println);
    }

    //#2
    private static void getSortCountries(Map<String, String> countries) {
        countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //#3
    private static List<String> getSortWordsByLengthAndStartWithGivenLetter(List<String> words, char letter) {
        return words.stream()
                .filter(s -> s.charAt(0) == letter)
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
    }

    //#4
    private static HashMap<String, String> getFriendsWhoHasCommonFriends(Map<String, List<String>> people) {
        HashMap<String, String> pair = new HashMap<>();

        people.forEach((key, value) -> people.entrySet().stream()
                .filter(entry -> !key.equals(entry.getKey()) && !value.contains(entry.getKey()))
                .forEach(entry -> entry.getValue().stream()
                        .filter(value::contains)
                        .forEach(friend -> pair.put(entry.getKey(), key)))
        );
        return pair;
    }

    //#5
    private static Map<String, Double> averageSalaryOfDepartment(List<Employee> employees) {
        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary))
                );
        return averageSalary;
    }

    //#6
    public static List<String> filterAndSortStrings(List<String> inputStrings, char[] alphabet) {
        Set<Character> alphabetSet = new HashSet<>();
        for (char c : alphabet) {
            alphabetSet.add(c);
        }

        return inputStrings.stream()
                .filter(str -> str.chars().allMatch(ch -> alphabetSet.contains((char) ch)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //#7
    public static List<String> convertToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    //#8
    private static List<Integer> getPalindromesInRange(int left, int right) {
        return IntStream.range(left, right)
                .mapToObj(String::valueOf)
                .filter(num -> new StringBuilder(num).reverse().toString().equals(num))
                .map(Integer::parseInt)
                .toList();
    }
}
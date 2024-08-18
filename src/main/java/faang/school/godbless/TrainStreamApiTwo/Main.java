package faang.school.godbless.TrainStreamApiTwo;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> integers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    static Map<String, String> capitalsByCountries = Map.of(
            "Russia", "Moscow",
            "Croatia", "Zagreb",
            "Serbia", "Belgrade"
    );

    static List<String> strings = List.of("aboba", "shrek", "volodya", "abrakadabra","cat", "bat", "man", "alla");

    static Map<String, List<String>> friendsByPeople = Map.ofEntries(
            Map.entry("Alice", List.of("Bob", "Charlie", "David")),
            Map.entry("Bob", List.of("Alice", "Eve")),
            Map.entry("Charlie", List.of("Alice", "David")),
            Map.entry("David", List.of("Alice", "Charlie", "Eve")),
            Map.entry("Eve", List.of("Bob", "David"))
    );

    static List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR", 3000),
            new Employee("Bob", "HR", 3500),
            new Employee("Charlie", "IT", 4000),
            new Employee("David", "IT", 4500),
            new Employee("Eve", "Finance", 5000)
    );

    static List<String> testAlphabet = Arrays.asList(
            "Привет мир",
            "Hello world",
            "Привет, Hello",
            "Здравствуйте!",
            "Hello, world!",
            "12345",
            "!@#$%^&*()"
    );

    public static void main(String[] args) {
        Set<Pair> pairs = findSumPair(integers, 8);
        pairs.forEach(System.out::println);

        sortCountries(capitalsByCountries);

        sortStrings(strings, 'a').forEach(System.out::println);

        notFriendsHasCommonFriends(friendsByPeople).forEach(System.out::println);

        averageSalary(employees).forEach((dep, salary) -> System.out.println(dep + ": " + salary));

        containsWordsWithAlphabet(testAlphabet, AlphabetLanguage.ENG).forEach(System.out::println);
        System.out.println("_____________________________");
        containsWordsWithAlphabet(testAlphabet, AlphabetLanguage.RUS).forEach(System.out::println);

        integersToBinary(integers).forEach(System.out::println);

        findPolyndroms(1, 200).forEach(System.out::println);
    }

    public static Set<Pair> findSumPair(List<Integer> integers, int targetSum) {
        Set<Pair> resultPairs = new HashSet<>();
        Set<Integer> passedNums = new HashSet<>();
        integers.forEach(integer -> {
            int numToFind = targetSum - integer;
            if (passedNums.contains(numToFind)) {
                resultPairs.add(new Pair(integer, numToFind));
            }
            passedNums.add(integer);
        });
        return resultPairs;
    }

    public static void sortCountries(Map<String, String> map)
    {
        Set<Map.Entry<String,String >> countries = map.entrySet();
        List<Map.Entry<String, String>> sorted = countries.stream().sorted(Comparator.comparingInt(entry -> entry.getKey().charAt(0))).toList();

        sorted.forEach(System.out::println); // вывел не только города, что бы было легче тестить
    }

    public static List<String> sortStrings(List<String> strings, char starter) {
        return strings.stream().filter(string -> string.charAt(0) == starter).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static Set notFriendsHasCommonFriends(Map<String, List<String>> friendListsByPeople) {

        Set<Pair> filtered = friendsByPeople.keySet().stream()
                .flatMap(person1 -> friendsByPeople.keySet().stream()
                        .filter(person2 -> !person1.equals(person2))
                        .filter(person2 -> !friendsByPeople.get(person1).contains(person2))
                        .filter(person2 -> hasCommonFriends(friendsByPeople.get(person1), friendsByPeople.get(person2)))
                        .map(person2 -> new Pair(person1, person2)))
                .collect(Collectors.toSet());
        return filtered;
    }

    public static boolean hasCommonFriends(List<String> friends1, List<String> friends2) {
        Set<String> set = new HashSet<>(friends1);
        set.retainAll(friends2);
        return !set.isEmpty();
    }

    public static Map<String, Integer> averageSalary(List<Employee> employees)
    {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.averagingInt(Employee::getSalary), avg -> (int) Math.round(avg))));
    }

    public static List<String> containsWordsWithAlphabet(List<String> strings, AlphabetLanguage alphabet)
    {
        String restrictedSymbolsRegex = alphabet == AlphabetLanguage.RUS ? "[a-zA-Z]" : "[а-яА-ЯёЁ]";
        Pattern pattern = Pattern.compile(restrictedSymbolsRegex);

        return strings.stream().filter(string -> !pattern.matcher(string).find()).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> integersToBinary(List<Integer> integers) {
        return integers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findPolyndroms(int bottom, int top) {
        List<Integer> result = new ArrayList<>();
        for (int i = bottom; i <= top; i++) {
            if (Integer.toString(i).equals(new StringBuilder(Integer.toString(i)).reverse().toString())) {
                result.add(i);
            }
        }
        return result;
    }
}

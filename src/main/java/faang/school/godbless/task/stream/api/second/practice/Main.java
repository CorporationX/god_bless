package faang.school.godbless.task.stream.api.second.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers;
        List<String> words;
        char[] alphabet;
        int targetSum;
        char letter;

        // 1
        numbers = List.of(1, 7, 9, 3, 6, 4, 5, 3, 7);
        targetSum = 10;
        System.out.println("\nУникальные пары из списка которые в сумме дают %s:".formatted(targetSum));
        findUniquePairsOfNumbers(numbers, targetSum).forEach(num -> System.out.println(num));

        // 2
        System.out.println("\nСталицы стран отсортированных по алфавиту:");
        countriesSortByAlphabet(Map.of("Yemen", "Aden", "Turkey", "Ankara",
                "Iraq", "Baghdad", "China", "Beijing"));

        // 3
        words = List.of("apple", "Pepper", "mango", "pipe", "pineapple", "mandarin");
        letter = 'p';
        System.out.println("\nСписок слов на букву '%s' отсортированный по длинне (без учета регистра):"
                .formatted(letter));
        sortWordsByLengthAndLetter(words, letter).forEach(word -> System.out.println(word));

        // 4
        Map<String, List<String>> friends = Map.of(
                "Mike", List.of("Ron", "Ross"),
                "Bob", List.of("Ron", "Petter"),
                "Ron", List.of("Mike", "Bob", "Ross"),
                "Petter", List.of("Bob", "Anna"),
                "Ross", List.of("Mike", "Ron", "Anna"),
                "Jenna", List.of("Martin", "Barry", "Luis")
        );
        System.out.println("\nСписок уникальных пар людей, которые не являются друзьями, но у них есть общие друзья:");
        findFriendsOfFriends(friends).forEach(pair -> System.out.println(pair));

        // 5
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Mike", 2300, "backend"),
                new Employee("Lucy", 2700, "manager"),
                new Employee("Ross", 1900, "manager"),
                new Employee("Bob", 2100, "backend"),
                new Employee("Barry", 1800, "frontend"),
                new Employee("Mary", 3700, "frontend"),
                new Employee("Jack", 3500, "backend"),
                new Employee("Timmy", 2000, "frontend")
        ));
        System.out.println("\nСписок средних показателей зарплат по отделам:");
        findPaycheckByDivision(employees).entrySet().forEach(entry ->
                System.out.println(entry.getKey() + " " + entry.getValue()));

        // 6
        words = List.of("apple", "banana", "123", "dog", "Cat");
        alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.println("\nСписок из слов содержащих только указанные буквы и отсортированные по длинне " +
                "(буз учета регистра):");
        sortWordsByLettersAndLength(words, alphabet).forEach(word -> System.out.println(word));

        // 7
        numbers = List.of(6, 12, 2, 64, 17);
        System.out.println("\nСписок целых чисел в бинарном представлении:");
        convertNumbToBinary(numbers).forEach(str -> System.out.println(str));

        // 8
        int start = 110, end = 163;
        System.out.println("\nВсе числа палиндромы в диапазоне от %s до %s:".formatted(start, end));
        for (int n : findPalindromeNumbers(start, end)) {
            System.out.println(n);
        }

        // 9
        String subString = "abfbnlplre";
        System.out.println("\nСписок всех подстрок палиндромов из строки '%s':".formatted(subString));
        findPalindromeSubstrings(subString).forEach(n -> System.out.println(n));

    }

    // 1
    public static List<List<Integer>> findUniquePairsOfNumbers(List<Integer> numbers, int targetSum) {
        return numbers.stream()
                .flatMap(n1 -> numbers.stream()
                        .filter(n2 -> (n2 + n1) == targetSum)
                        .filter(n2 -> n2 < n1)
                        .map(n2 -> List.of(n2, n1))).distinct().toList();
    }

    // 2
    public static void countriesSortByAlphabet(Map<String, String> countriesCapitals) {
        countriesCapitals.entrySet().stream()
                .sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                .forEach(entry -> System.out.println(entry.getValue()));
    }

    // 3
    public static List<String> sortWordsByLengthAndLetter(List<String> words, char letter) {
        return words.stream()
                .filter(word -> word.toLowerCase().startsWith(Character.toString(letter)))
                .sorted(Comparator.comparing(String::length)).toList();
    }

    // 4
    public static List<List<String>> findFriendsOfFriends(Map<String, List<String>> friendsMap) {
        return friendsMap.entrySet().stream()
                .flatMap(entryA -> friendsMap.entrySet().stream()
                        .filter(entryB -> !entryA.getKey().equals(entryB.getKey()))
                        .filter(entryB -> !entryA.getValue().contains(entryB.getKey()))
                        .filter(entryB -> entryB.getValue().stream().anyMatch(friendB -> entryA.getValue().contains(friendB)))
                        .map(entryB -> List.of(entryA.getKey(), entryB.getKey()).stream().sorted().toList()))
                .distinct()
                .toList();
    }

    // 5
    public static Map<String, Double> findPaycheckByDivision(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDivision,
                        Collectors.averagingDouble(Employee::getPaycheck)));
    }

    // 6
    public static List<String> sortWordsByLettersAndLength(List<String> words, char[] letters) {
        Set<Character> charSet = IntStream.range(0, letters.length)
                .mapToObj(ch -> letters[ch]).collect(Collectors.toSet());
        return words.stream()
                .filter(word -> word.chars()
                        .allMatch(letter -> charSet.contains((char) Character.toLowerCase(letter))))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    // 7
    public static List<String> convertNumbToBinary(List<Integer> numbers) {
        return numbers.stream().map(number -> Integer.toBinaryString(number)).toList();
    }

    // 8
    public static int[] findPalindromeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> Integer.toString(number)
                        .equals(new StringBuilder(number + "").reverse().toString()))
                .toArray();
    }

    // 9
    public static List<String> findPalindromeSubstrings(String str) {
        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, str.length() + 1)
                        .mapToObj(j -> str.substring(i, j < str.length() ? j : j - 1)))
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()) && s.length() > 1)
                .distinct()
                .toList();
    }
}

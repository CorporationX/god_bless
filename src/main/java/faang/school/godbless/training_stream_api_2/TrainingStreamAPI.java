package faang.school.godbless.training_stream_api_2;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainingStreamAPI {

    public static void main(String[] args) {
        Map<String, String> countriesAndCapitals =
                Map.of("Kazakhstan", "Astana",
                        "Russia", "Moscow",
                        "England", "London",
                        "Azerbaijan", "Baku");

        List<String> words = List.of("Apple", "banana", "Notebook", "cat", "object", "Arizona", "Antalya", "broccoli");

        List<Employee> employees =
                List.of(new Employee("Emp1", 450000, "IT"),
                        new Employee("Emp2", 320000, "Sales"),
                        new Employee("Emp3", 450000, "IT"),
                        new Employee("Emp4", 320000, "Sales"));

        List<Integer> numbers = List.of(1, 9, 4, 6, 5);

        Map<String, List<String>> friends =
                Map.of("Rauan", List.of("Friend1", "Friend2", "Friend3")
                        , "Nauar", List.of("Friend3", "Friend4", "Friend5")
                        , "Alex", List.of("Friend3", "Friend10"));

        System.out.println(uniquePairsEqualsToParam(numbers, 10));
        System.out.println(sortByCountry(countriesAndCapitals));
        System.out.println(filterWordsByFirstLetterAndSort(words, 'A'));
        System.out.println(findCommonFriendsPair(friends));
        System.out.println(averageSalaryPerDepartment(employees));
        System.out.println(wordsByAlphabet(words, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(mapToBinary(numbers));
        System.out.println(palindromeNumbers(100, 200));
    }

    public static Map<Integer, Integer> uniquePairsEqualsToParam(@NonNull List<Integer> numbers, int target) {
        Map<Integer, Integer> result = new HashMap<>();

        numbers.forEach(num -> {
            int curr = target - num;
            if (curr != num || numbers.stream().filter(n -> n.equals(num)).count() >= 2) {
                result.putIfAbsent(curr, num);
            }
        });

        return result.entrySet().stream()
                .filter(entry -> entry.getKey() <= entry.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    public static List<String> sortByCountry(@NonNull Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> filterWordsByFirstLetterAndSort(@NonNull List<String> words, char target) {
        return words.stream()
                .filter(word -> word.startsWith(Character.toString(target)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Map<String, String> findCommonFriendsPair(@NonNull Map<String, List<String>> friendsMap) {
        Map<String, String> result = new HashMap<>();

        friendsMap
                .forEach((user, friends) -> friendsMap
                        .forEach((anotherUser, anotherFriends) -> {
                            if (!friends.contains(anotherUser) && !user.equals(anotherUser)) {
                                friends.stream()
                                        .filter(anotherFriends::contains)
                                        .findFirst()
                                        .ifPresent(fr -> result.put(user, anotherUser));
                            }
                        }));

        return result;
    }

    public static Map<String, Double> averageSalaryPerDepartment(@NonNull List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<String> wordsByAlphabet(@NonNull List<String> words, @NonNull String alphabet) {
        return words.stream()
                .filter(word -> word.chars()
                        .allMatch(c -> alphabet.indexOf(c) >= 0))
                .toList();
    }

    public static List<String> mapToBinary(@NonNull List<Integer> numbers) {
        return numbers.stream().map(num -> Integer.toString(num, 2)).toList();
    }

    public static List<Integer> palindromeNumbers(int start, int end) {
        List<Integer> palindromes = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.rangeClosed(start, end)
                .forEach(num -> {
                    stringBuilder.append(num);
                    if (Integer.toString(num).contentEquals(stringBuilder.reverse())) {
                        palindromes.add(num);
                    }

                    stringBuilder.delete(0, stringBuilder.length());
                });

        return palindromes;
    }
}

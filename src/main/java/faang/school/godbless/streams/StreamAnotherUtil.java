package faang.school.godbless.streams;

import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAnotherUtil {

    public static List<List<Integer>> findTargetNumberInListNumbersBySumElements(@NonNull List<Integer> numbers, int target) {
        checkIsListNotEmptyOrElseThrowError(numbers);

        return numbers.stream()
                .distinct()
                .filter(number -> number < target)
                .flatMap(number -> numbers.stream()
                        .distinct()
                        .filter(num -> num < target)
                        .filter(num -> num + number == target)
                        .map(num -> new ArrayList<>(List.of(number, num))))
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<String> getCapitalsAfterOrderTheirCountries(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();

    }

    public static List<String> orderSentencesByLengthWithFilterStartWith(List<String> sentences, Character letter) {
        return sentences.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<List<String>> getPeopleWhoIsNotFriendButIsFriendOfFriend(Map<String, List<String>> contacts) {
        List<List<String>> res = new ArrayList<>();

        contacts.keySet().stream()
                .flatMap(person -> contacts.entrySet().stream()
                        .filter(entry -> !entry.getKey().equalsIgnoreCase(person))
                        .filter(entry -> entry.getValue().contains(person))
                        .filter(entry -> entry.getValue().size() > 1)
                        .peek(entry -> entry.getValue().forEach(f -> {
                            if (!f.equalsIgnoreCase(person)) {
                                res.add(List.of(person, f));
                            }
                        }))
                )
                .count();

        return res;
    }

    public static Map<String, Double> getAverageSalaryByDepartment(@NonNull List<Employee> employees) {
        checkIsListNotEmptyOrElseThrowError(employees);

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));
    }

    public static List<String> getWordsContainsOnlyAlphabetSymbols(List<String> words, ArrayList<Character> alphabet) {
        return words.stream()
                .filter(word -> Arrays.stream(word.split(""))
                        .allMatch(symbol -> alphabet.contains(symbol.charAt(0))))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertIntegersToBinaryStrings(@NonNull List<Integer> numbers) {
        checkIsListNotEmptyOrElseThrowError(numbers);

        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> getPalindromeNumbersByRange(@NonNull List<Integer> numbers,
                                                            int startRange,
                                                            int finishRange) {
        checkIsListNotEmptyOrElseThrowError(numbers);

        return numbers.stream()
                .map(n -> String.valueOf(n).substring(startRange, finishRange))
                .filter(n -> {
                    String reversedNumber = new StringBuilder(n).reverse().toString();
                    return n.equalsIgnoreCase(reversedNumber);
                })
                .map(Integer::valueOf)
                .toList();
    }

    private static void checkIsListNotEmptyOrElseThrowError(List<?> objects) {
        if (objects.isEmpty()) {
            throw new IllegalArgumentException("Incoming list can't be empty");
        }
    }
}

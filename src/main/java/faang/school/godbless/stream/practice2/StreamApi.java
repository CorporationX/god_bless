package faang.school.godbless.stream.practice2;

import faang.school.godbless.javahashmap.absenteeism.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi {

    public static Set<Pair<Integer, Integer>> findUniquePairs(List<Integer> numbers, int targetSum) {
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();

        numbers.forEach(num -> {
            int complement = targetSum - num;
            if (numbers.contains(complement)) {
                pairs.add(new Pair<>(num, complement));
            }
        });

        return pairs;
    }

    public static void sortCountriesAndCapitals(Map<String, String> countriesAndCapitals) {
        List<String> sortedCountries = countriesAndCapitals.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .toList();

        sortedCountries.forEach(country -> System.out.println(country + ": " + countriesAndCapitals.get(country)));
    }

    public static List<String> filterAndSortStrings(List<String> strings, char targetChar) {
        return strings.stream()
                .filter(s -> s.charAt(0) == targetChar)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Set<Pair<String, String>> findPairsNotFriendsButWithCommonFriends(Map<String, List<String>> personsAndFriends) {

        Set<Pair<String, String>> friendsPairs = new HashSet<>();

        personsAndFriends.forEach((person1, friendsOfPerson1) ->
                personsAndFriends.forEach((person2, friendsOfPerson2) -> {
                    if (haveCommonFriends(friendsOfPerson1, friendsOfPerson2)) {
                        if (notFriends(person1, friendsOfPerson1, person2, friendsOfPerson2)) {
                            friendsPairs.add(new Pair<>(person1, person2));
                        }
                    }
                })
        );

        return friendsPairs;
    }

    private static boolean haveCommonFriends(List<String> friendsOfPerson1, List<String> friendsOfPerson2) {
        return friendsOfPerson1.stream().anyMatch(friendsOfPerson2::contains);
    }

    private static boolean notFriends(String person1, List<String> friendsOfPerson1, String person2, List<String> friendsOfPerson2) {
        return !friendsOfPerson2.contains(person1) && !friendsOfPerson1.contains(person2);
    }

    public static Map<String, Double> calculateAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary))
                );
    }

    public static List<String> filterAndSortStringsByAlphabet(List<String> strings, char[] alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c ->
                        IntStream.range(0, alphabet.length).anyMatch(alphabetChar -> (int) alphabet[alphabetChar] == c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertIntegersToBinaryString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPalindromesInRangeInclusive(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .filter(StreamApi::isPalindromic)
                .collect(Collectors.toList());
    }

    private static boolean isPalindromic(Integer num) {
        return String.valueOf(num).contentEquals(new StringBuilder(String.valueOf(num)).reverse());
    }
}

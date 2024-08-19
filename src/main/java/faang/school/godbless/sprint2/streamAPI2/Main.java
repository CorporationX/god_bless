package faang.school.godbless.sprint2.streamAPI2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int targetSum) {
        Set<Integer> usedNumbers = new HashSet<>();
        return numbers.stream()
                .flatMap(number -> {
                    int dif = targetSum - number;
                    if (usedNumbers.contains(dif)) {
                        return Stream.of(Arrays.asList(Math.min(number, dif), Math.max(number, dif)));
                    }
                    usedNumbers.add(number);
                    return Stream.empty();
                })
                .collect(Collectors.toSet());
    }

    public static List<String> capitalsBySortedCounties(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortedStringsThatStartWithChar(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Set<Set<String>> findNotFriendsWithMutualFriends(Map<String, List<String>> peoples) {
        return peoples.keySet().stream()
                .flatMap(person -> peoples.keySet()
                        .stream()
                        .filter(potentialFriend -> !person.equals(potentialFriend)
                                && !peoples.get(person).contains(potentialFriend)
                                && peoples.get(potentialFriend)
                                .stream()
                                .anyMatch(friend -> peoples.get(person).contains(friend)))
                        .map(foundedFriend -> Set.of(person, foundedFriend)))
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> averageSalaryForEachDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream()
                                .mapToInt(Employee::getSalary)
                                .average()
                                .orElse(0.0)));
    }

    public static List<String> filterListByAlphabetAndSorted(List<String> strings, String alphabet) {
        Set<Character> setAlphabet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        return strings.stream()
                .filter(string -> string.chars()
                        .allMatch(ch -> setAlphabet.contains((char) ch)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    private static List<Integer> numbersByPredicate(int begin, int end, Predicate<Integer> predicate) {
        if (begin > end) {
            throw new IllegalArgumentException("Начало диапазона не может быть больше конца");
        }
        return Stream.iterate(begin, number -> number + 1)
                .limit(end - begin + 1)
                .filter(predicate)
                .toList();
    }

    public static List<Integer> palindromesNumbers(int begin, int end) {
        return numbersByPredicate(begin, end, number -> isPalindrome(String.valueOf(number)));
    }

    private static boolean isPalindrome(String string) {
        return IntStream.range(0, string.length() / 2)
                .allMatch(index -> string.charAt(index) == string.charAt(string.length() - 1 - index));
    }

    public static List<String> findAllSubstringsThatPalindromes(String string) {
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(start -> IntStream.range(start + 1, string.length() + 1)
                        .mapToObj(end -> string.substring(start, end)))
                .filter(Main::isPalindrome)
                .distinct()
                .toList();
    }

    public static List<Integer> perfectNumbers(int begin, int end) {
        return numbersByPredicate(begin, end, Main::isPerfectNumber);
    }

    private static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }
        int sumOfDivisors = IntStream.range(1, number / 2 + 1)
                .filter(divisor -> number % divisor == 0)
                .sum();
        return sumOfDivisors == number;
    }
}

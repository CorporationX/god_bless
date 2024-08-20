package faang.school.godbless.bjs2_22424;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    // 1
    public static List<Pair<Integer, Integer>> getPairs(List<Integer> numbers, Integer sum) {
        List<Integer> uniqueNumbers = numbers.stream().distinct().toList();
        var size = uniqueNumbers.size();

        List<Pair<Integer, Integer>> allPairsFromNumbers = IntStream.range(0, size)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, size)
                        .mapToObj(j -> Pair.of(uniqueNumbers.get(i), uniqueNumbers.get(j))))
                .distinct()
                .toList();

        return allPairsFromNumbers.stream()
                .filter(pair -> pair.getLeft() + pair.getRight() == sum)
                .toList();
    }

    // 2
    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    // 3
    public static List<String> getStrings(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(Character.toString(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    // 4
    public static List<Pair<String, String>> getFriends(Map<String, List<String>> users) {
        var friends = users.keySet();
        return friends.stream()
                .flatMap(friend -> friends.stream()
                        .filter(inner -> !friend.equals(inner))
                        .filter(inner -> !users.get(friend).contains(inner))
                        .filter(inner -> isTwoListsContainsCommonString(users.get(friend), users.get(inner)))
                        .map(inner -> Pair.of(
                                friend.compareTo(inner) < 0 ? friend : inner,
                                friend.compareTo(inner) < 0 ? inner : friend)))
                .distinct()
                .toList();
    }

    private static boolean isTwoListsContainsCommonString(List<String> left, List<String> right) {
        var commonFriends = left.size() + right.size();
        Set<String> commonSet = new HashSet<>(left);
        commonSet.addAll(right);
        return commonSet.size() < commonFriends;
    }

    // 5
    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        Map<String, IntStream> departmentsWithSalaries = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,
                        e -> IntStream.of(e.getSalary()),
                        IntStream::concat
                ));

        return departmentsWithSalaries
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().average().orElse(0.0)
                ));
    }

    public static Map<String, Double> getAverageSalarySecondApproach(List<Employee> employees) {
        return employees.stream()
                .collect(groupingBy(
                        Employee::getDepartment,
                        averagingDouble(Employee::getSalary))
                );
    }

    // 6
    public static List<String> getStringsAlphabet(List<String> strings, char[] alphabet) {
        return strings.stream()
                .filter(s -> !s.isEmpty())
                .filter(checkString(alphabet))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static Predicate<String> checkString(char[] alphabet) {
        var alphabetString = new String(alphabet);
        return string -> string.chars()
                .allMatch(chars -> alphabetString.indexOf(chars) >= 0);
    }

    // 7
    public static List<String> intToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    // 8
    public static List<Integer> getPalindromes(Integer left, Integer right) {
        return IntStream
                .rangeClosed(left, right)
                .filter(isNumberPalindrome())
                .boxed()
                .toList();
    }

    public static IntPredicate isNumberPalindrome() {
        return i -> {
            String n = String.valueOf(i);
            return n.equals(new StringBuilder(n).reverse().toString());
        };
    }

    // 9
    public static List<String> getPalindromesFromString(String string) {
        var length = string.length();
        Stream<String> allSubstringsStream = IntStream
                .range(0, length)
                .boxed()
                .flatMap(start -> IntStream.range(start + 2, length + 1)
                        .mapToObj(end -> string.substring(start, end)));

        return allSubstringsStream
                .filter(isStringPalindrome())
                .distinct()
                .toList();
    }

    private static Predicate<String> isStringPalindrome() {
        return s -> s.equals(new StringBuilder(s).reverse().toString());
    }

    // 10
    public static List<Integer> getPerfectNumbers(Integer left, Integer right) {
        return IntStream.rangeClosed(left, right)
                .filter(isPerfect()::test)
                .boxed()
                .toList();
    }

    private static Predicate<Integer> isPerfect() {
        return number -> {
            int sum = IntStream.rangeClosed(1, number / 2)
                    .filter(i -> number % i == 0)
                    .sum();
            return sum == number;
        };
    }
}

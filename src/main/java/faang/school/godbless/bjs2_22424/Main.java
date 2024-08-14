package faang.school.godbless.bjs2_22424;

import org.apache.commons.lang3.tuple.Pair;

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
    // 1
    public static List<Pair<Integer, Integer>> getPairs(List<Integer> numbers, Integer sum) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i + j == sum && numbers.indexOf(i) < numbers.indexOf(j))
                        .map(j -> Pair.of(i, j)))
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
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,
                        e -> IntStream.of(e.getSalary()),
                        IntStream::concat
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().average().orElse(0.0)
                ));
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
        return (string) -> Arrays.stream(string.split(""))
                .allMatch(alphabetString::contains);
    }

    // 7
    public static List<String> intToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    // 8
    public static List<Integer> getPalindromes(Integer left, Integer right) {
        var numbers = Stream
                .iterate(left, n -> n + 1)
                .limit(right - left + 1);
        return numbers
                .filter(i -> {
                    var n = String.valueOf(i);
                    return n.equals(new StringBuilder(n).reverse().toString());
                })
                .toList();
    }

    // 9
    public static List<String> getPalindromesFromString(String string) {
        var numbers = Stream
                .iterate(0, n -> n + 1)
                .limit(string.length())
                .toList();

        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> numbers.indexOf(i) < numbers.indexOf(j))
                        .map(j -> string.substring(i, j + 1)))
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .distinct()
                .toList();
    }

    // 10
    public static List<Integer> getPerfectNumbers(Integer left, Integer right) {
        var numbers = Stream
                .iterate(left, n -> n + 1)
                .limit(right - left + 1);
        return numbers
                .filter(isPerfect())
                .toList();
    }

    private static Predicate<Integer> isPerfect() {
        return (number) -> {
            int sum = 0;
            for (int i = 1; i <= number / 2; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }
            return sum == number;
        };
    }
}

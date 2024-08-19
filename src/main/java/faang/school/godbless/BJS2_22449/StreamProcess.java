package faang.school.godbless.BJS2_22449;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

public class StreamProcess {
    public static Set<Pair<Integer, Integer>> findUniquePairsWithSum(int sum, List<Integer> nums) {
        return nums.stream()
                .flatMap(number -> {
                    int difference = sum - number;
                    if (nums.contains(difference)) {
                        var pair = Pair.of(Math.min(number, difference), Math.max(number, difference));
                        return Stream.of(pair);
                    } else {
                        return Stream.empty();
                    }
                })
                .collect(Collectors.toSet());
    }

    public static void printSortedCapitalsByCountry(Map<String, String> capitalsByCountries) {
        capitalsByCountries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(capitalByCountry -> System.out.println(capitalByCountry.getValue()));
    }

    public static List<String> filterStringsStartWithCharAndSortByLength(char letter, List<String> strings) {
        return strings.stream()
                .filter(string -> string != null && !string.isEmpty() && string.charAt(0) == letter)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static Map<String, String> findPairsOfNonFriendsWithCommonFriends(Map<String, List<String>> friendsByNames) {
        Map<String, String> nonFriends = new HashMap<>();
        friendsByNames.forEach((person, friends) -> friendsByNames.forEach((anotherPerson, anotherFriends) -> {
            if (!person.equals(anotherPerson) && !friends.contains(anotherPerson)) {
                friends.stream()
                        .filter(anotherFriends::contains)
                        .findFirst()
                        .ifPresent(friend -> {
                            if (!nonFriends.containsKey(anotherPerson)
                                    || (nonFriends.containsKey(anotherPerson) && !nonFriends.get(anotherPerson).equals(person))) {
                                nonFriends.put(person, anotherPerson);
                            }
                        });

            }
        }));
        return nonFriends;
    }

    public static Map<String, Double> countAvgSalaryForEachDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, Set<Character> letters) {
        return strings.stream()
                .filter(string -> string.chars().allMatch(letter -> letters.contains((char) letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertIntegersToBinaryStrings(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .mapToObj(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromicNumsInBoundaries(int leftBounder, int rightBounder) {
        return IntStream.rangeClosed(leftBounder, rightBounder)
                .filter(StreamProcess::isPalindromic)
                .boxed()
                .toList();
    }

    private static boolean isPalindromic(int num) {
        int original = num;
        int reverse = 0;
        while (num != 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return reverse == original;
    }
}

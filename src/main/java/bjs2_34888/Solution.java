package bjs2_34888;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static Set<List<String>> getPairsWithCommonFriends(Map<String, List<String>> people) {
        Set<List<String>> pairs = new HashSet<>();

        people.keySet().forEach(person -> {
            Set<String> friends = new HashSet<>(people.get(person));
            Set<String> strangers = new HashSet<>(people.keySet());
            strangers.removeAll(Set.of(friends, person));

            strangers.forEach(stranger -> {
                people.get(stranger).forEach(strangerFriend -> {
                    if (friends.contains(strangerFriend)) {
                        pairs.add(Stream.of(person, stranger).sorted().toList());
                    }
                });
            });

        });
        return pairs;
    }

    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            Integer sumSalary = entry.getValue().stream()
                                    .reduce(0,
                                            (sum, current) -> sum + current.getSalary(),
                                            Integer::sum);

                            return (double) sumSalary / entry.getValue().size();
                        }
                ));
    }

    public static List<Integer> findPalindromesInRange(int min, int max) {
        return IntStream.range(min, max + 1)
                .filter(num -> {
                    String stringNum = Integer.toString(num);
                    String reverseStringNum = new StringBuilder(stringNum).reverse().toString();
                    return stringNum.equals(reverseStringNum);
                })
                .boxed()
                .toList();
    }

    public static List<String> findPalindromesOfSubstring(String string) {
        Stream<String> allSubstrings = getStreamOfSubstrings(string);
        return allSubstrings
                .filter(Solution::isPalindromeString)
                .distinct()
                .toList();
    }

    public static List<Integer> findPerfectInRange(int min, int max) {
        return IntStream.range(min, max + 1)
                .filter(num -> {
                    if (num == 1) {
                        return false;
                    }
                    List<Integer> dividers = getAllDividersOfNumber(num);
                    Optional<Integer> sumDividers = dividers.stream().reduce(Integer::sum);
                    Integer sum = sumDividers.orElseThrow(IllegalArgumentException::new);

                    return sum == num;
                })
                .boxed()
                .toList();
    }

    private static boolean isPalindromeString(String string) {
        String reverseString = new StringBuilder(string).reverse().toString();
        return string.equals(reverseString);
    }

    private static Stream<String> getStreamOfSubstrings(String string) {
        Stream<String> substrings = Stream.empty();

        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j <= string.length(); j++) {
                substrings = Stream.concat(substrings, Stream.of(string.substring(i, j)));
            }
        }

        return substrings;
    }

    private static List<Integer> getAllDividersOfNumber(int num) {
        ArrayList<Integer> dividers = new ArrayList<>();

        for (int i = 1; i <= (num / 2); i++) {
            if (num % i == 0) {
                dividers.add(i);
            }
        }

        return dividers;
    }
}

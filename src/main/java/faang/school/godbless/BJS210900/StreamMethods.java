package faang.school.godbless.BJS210900;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMethods {
    public static Set<List<Integer>> getPairsWithSumOf(List<Integer> nums, int sum) {
        if (nums == null) {
            throw new IllegalArgumentException("List nums can't be null!");
        }

        Map<Integer, Long> duplicates = nums.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        return duplicates.keySet().stream()
                .map(num -> {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(num);
                    if (num == sum - num && duplicates.get(num) > 1) {
                        innerList.add(num);
                    } else if (duplicates.containsKey(sum - num)) {
                        innerList.add(sum - num);
                    }
                    innerList.sort(null);
                    return innerList;
                })
                .filter(list -> list.size() > 1)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals.keySet().stream()
                .filter(Objects::nonNull)
                .sorted()
                .map(string -> countriesWithCapitals.get(string))
                .toList();
    }

    public static List<String> sortFilteredStrings(List<String> strings, char filter) {
        return strings.stream()
                .filter(string -> string != null && string.startsWith("" + filter))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static Set<Set<String>> findStrangersWithCommonFriends(Map<String, List<String>> friends) {
        Map<String, List<String>> friendsCopy = new HashMap<>(friends);
        friends.values().stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .forEach(name -> friendsCopy.computeIfAbsent(name,
                                k -> friends.keySet().stream()
                                        .filter(friend -> friends.get(friend).contains(name))
                                        .toList()
                        )
                );

        Set<Set<String>> result = new HashSet<>();

        friendsCopy.keySet().stream()
                .filter(Objects::nonNull)
                .forEach(commonFriend -> {
                    for (int i = 0; i < friendsCopy.get(commonFriend).size(); i++) {
                    String nameForSearch = friendsCopy.get(commonFriend).get(i);
                    for (int j = i + 1; j < friendsCopy.get(commonFriend).size(); j++) {
                        String possibleFriend = friendsCopy.get(commonFriend).get(j);
                        if (!friendsCopy.get(nameForSearch).contains(possibleFriend)) {
                            result.add(Set.of(nameForSearch, possibleFriend));
                        }
                    }
                }
        });

        return result;
    }

    public static Map<String, Double> getDepartmentAverageSalary(List<Employee> employees) {
        return employees.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<String> filterAndSortStringsContainsAlphabet(List<String> strings, char[] alphabet) {
        Set<Character> alphabetSet = new String(alphabet).chars()
                .filter(Objects::nonNull)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s != null && s.chars()
                        .mapToObj(c -> (char) c)
                        .allMatch(alphabetSet::contains))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> toBinaryString(List<Integer> nums) {
        return nums.stream()
                .filter(Objects::nonNull)
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromes(int from, int to) {
        if (from < 10 || from >= to) {
            throw new IllegalArgumentException("Please write correct numbers (>= 10 and from < to)");
        }
        return IntStream.range(from, to)
                .filter(s -> String.valueOf(s).equals(new StringBuilder(String.valueOf(s)).reverse().toString()))
                .boxed()
                .toList();
    }
}

package school.faang.stream_optional.bjs2_89296;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Operations {

    public static Set<Set<String>> getPersonsNotFriendsWithMutualFriends(Map<String, List<String>> personFriendsMap) {
        final Map<String, Set<String>> notFriendsMap = new HashMap<>();

        personFriendsMap.entrySet()
                .forEach(personFriendsMapEntry1 -> {
                    for (Map.Entry<String, List<String>> personFriendsMapEntry2 : personFriendsMap.entrySet()) {
                        if (personFriendsMapEntry2.getKey().equals(personFriendsMapEntry1.getKey())
                                && personFriendsMapEntry2.getValue().contains(personFriendsMapEntry1.getKey())) {
                            continue;
                        }

                        personFriendsMapEntry2.getValue().forEach(
                                friend -> {
                                    if (!personFriendsMapEntry1.getValue().contains(friend)
                                    ) {
                                        notFriendsMap.computeIfAbsent(personFriendsMapEntry1.getKey(),
                                                key -> new HashSet<>()).add(friend);
                                    }
                                });
                    }
                });

        final Set<Set<String>> personsWithMutualFriendsSet = new HashSet<>();

        notFriendsMap.entrySet().forEach(entry -> {
            Set<String> tempSet = new HashSet<>();
            tempSet.add(entry.getKey());

            entry.getValue().forEach(
                    value -> tempSet.add(value)
            );
            personsWithMutualFriendsSet.add(tempSet);
        });

        return personsWithMutualFriendsSet;
    }

    public static Map<String, Double> getAvgSalaryByDepartment(List<Employee> employees) {
        final Map<String, Double> depAvgSalaryMap = new HashMap<>();

        employees.stream()
                .collect(Collectors.groupingBy(Employee::department))
                .entrySet()
                .forEach(entry -> {

                    final double avgSalary = entry.getValue().stream()
                            .mapToInt(Employee::salary)
                            .average()
                            .orElseThrow();

                    depAvgSalaryMap.put(entry.getKey(), avgSalary);
                });

        return depAvgSalaryMap;
    }

    public static List<Integer> getPalindromeBetweenTwoInts(int start, int end) {
        final List<Integer> intList = IntStream
                .rangeClosed(start, end).boxed()
                .toList();

        return intList.stream()
                .filter(i -> {
                    final StringBuilder strBuilder = new StringBuilder(String.valueOf(i));
                    return Integer.parseInt(strBuilder.reverse().toString()) == i;
                })
                .toList();
    }

    public static List<String> getPalindromesFromString(String strForPalindrome) {
        final List<String> listForSubstrings = new ArrayList<>();

        for (int i = 0; i < strForPalindrome.length(); i++) {
            for (int j = 1; j <= strForPalindrome.length() - i; j++) {
                listForSubstrings.add(strForPalindrome.substring(i, j + i));
            }
        }

        return listForSubstrings.stream()
                .filter(str -> new StringBuilder(str).reverse().toString().equals(str))
                .distinct()
                .toList();
    }

    public static List<Integer> getPerfectNumbers(int start, int end) {
        final List<Integer> rangeInts = IntStream.range(start, end).boxed().toList();

        return rangeInts.stream()
                .filter(mainInt -> {
                    int sum = IntStream.range(1, mainInt)
                            .boxed()
                            .toList().stream()
                            .filter(i -> mainInt % i == 0)
                            .mapToInt(i -> i)
                            .sum();
                    return mainInt.equals(sum);
                }).toList();
    }
}
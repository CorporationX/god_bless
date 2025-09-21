package school.faang.stream_optional.bjs2_89296;

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
                .forEach(personFriendsMapEntryMain -> {
                    for (Map.Entry<String, List<String>> personFriendsMapEntryForFilter : personFriendsMap.entrySet()) {
                        if (personFriendsMapEntryForFilter.getKey().equals(personFriendsMapEntryMain.getKey())
                                && personFriendsMapEntryForFilter
                                .getValue().contains(personFriendsMapEntryMain.getKey())) {
                            continue;
                        }

                        personFriendsMapEntryForFilter.getValue().forEach(
                                friend -> {
                                    if (!personFriendsMapEntryMain.getValue().contains(friend)
                                    ) {
                                        notFriendsMap.computeIfAbsent(personFriendsMapEntryMain.getKey(),
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
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    public static List<Integer> getPalindromeBetweenTwoInts(int start, int end) {
        return IntStream
                .rangeClosed(start, end).boxed()
                .filter(i -> {
                    String str = String.valueOf(i);
                    return str.contentEquals(new StringBuilder(str).reverse());
                }).toList();
    }

    public static Set<String> getPalindromesFromString(String strForPalindrome) {
        final Set<String> listForSubstrings = new HashSet<>();

        for (int i = 0; i < strForPalindrome.length(); i++) {
            for (int j = i + 1; j <= strForPalindrome.length(); j++) {
                String subString = strForPalindrome.substring(i, j);
                if (subString.contentEquals(new StringBuilder(subString).reverse())) {
                    listForSubstrings.add(subString);
                }
            }
        }
        return listForSubstrings;
    }

    public static List<Integer> getPerfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(mainInt ->
                        IntStream.range(1, mainInt)
                                .filter(i -> mainInt % i == 0)
                                .sum() == mainInt)
                .boxed().toList();
    }
}
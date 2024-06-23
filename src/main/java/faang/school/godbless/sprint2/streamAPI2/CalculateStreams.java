package faang.school.godbless.sprint2.streamAPI2;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalculateStreams {

    public static List<List<Integer>> getUniquePairsOfSum(List<Integer> nums, Integer sumTarget) {
        if (!ValidationUtils.isValidCollection(nums) && sumTarget == null) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        Set<Integer> seenNumbers = new HashSet<>();

        return nums.stream()
                .map(number -> {
                    Integer difference = sumTarget - number;

                    if (seenNumbers.contains(difference)) {
                        seenNumbers.add(number);
                        return Arrays.asList(difference, number);
                    } else {
                        seenNumbers.add(number);
                        return new ArrayList<Integer>();
                    }
                })
                .filter(pair -> !pair.isEmpty())
                .collect(Collectors.toList());

    }

    public static List<String> getCityList(Map<String, String> countries) {
        if (!ValidationUtils.isValidMap(countries)) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        Set<Map.Entry<String, String>> entries = countries.entrySet();

        return entries.stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey().toUpperCase(Locale.ROOT), entry.getValue()))
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> getListOfStringsStartsFromCharAndSortedByLength(List<String> list, CharSequence letter) {
        if (!ValidationUtils.isValidCollection(list) && letter == null) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return list.stream()
                .filter(el -> el != null && el.startsWith(letter.toString()))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static Map<String, List<String>> getNotFriendsWithCommonFriends(Map<String, List<String>> people) {
        if (!ValidationUtils.isValidMap(people)) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return people.entrySet().stream()
                .flatMap(entry -> {
                    String person = entry.getKey();
                    List<String> friends = entry.getValue();
                    Map<String, List<String>> result = new HashMap<>();

                    List<String> commonFriends = friends.stream()
                            .flatMap(friend -> people.getOrDefault(friend, new ArrayList<>()).stream())
                            .filter(friend -> !friend.equals(person) && !friends.contains(friend))
                            .distinct()
                            .collect(Collectors.toList());

                    result.put(person, commonFriends);
                    return result.entrySet().stream();
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }


    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
        if (!ValidationUtils.isValidCollection(employees)) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return employees.stream()
                .collect(Collectors.groupingBy
                        (Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> getListContainsLettersByLength(List<String> list, String[] alphabet) {
        if (!ValidationUtils.isValidCollection(list) && alphabet == null) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return list.stream()
                .filter(elem -> Arrays.stream(elem.split("")).allMatch(Arrays.asList(alphabet)::contains))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> toBinaryList(List<Integer> list) {
        if (!ValidationUtils.isValidCollection(list)) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return list.stream()
                .filter(Objects::nonNull)
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> getPalindromeNumbersByRange(Integer start, Integer end) {
        if (!ValidationUtils.isValidIntegerRangeValues(start, end)) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return IntStream.range(start, end)
                .boxed()
                .filter(num -> num.toString().equals(new StringBuilder(num.toString()).reverse().toString()))
                .collect(Collectors.toList());
    }
}

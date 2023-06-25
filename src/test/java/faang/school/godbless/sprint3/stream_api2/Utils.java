package faang.school.godbless.sprint3.stream_api2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {
    public static Set<List<Integer>> getUniquePairs(List<Integer> nums, int sum) {
        return nums.stream()
                .filter(num -> nums.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getAlphabeticCapitalsList(Map<String, String> capitalsMap) {
        return capitalsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getStringsStartingWithSpecificCharSortedByLength(
            List<String> stringList, char specific) {
        return stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(specific)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static Set<List<String>> getPeopleWithMutualFriends(
            Map<String, List<String>> friendMap) {
        return friendMap.keySet()
                .stream()
                .flatMap(
                        person1 -> friendMap.keySet().stream()
                        .filter(
                                person2 -> !friendMap.get(person1).contains(person2)
                                && !friendMap.get(person2).contains(person1)
                                && friendMap.get(person1).stream().anyMatch(friendMap.get(person2)::contains)
                        )
                        .map(person2 -> Arrays.asList(person1, person2))
                        .filter(list -> !list.get(0).equals(list.get(1)))
                )
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> getAverageSalaryForDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary))
                );
    }

    public static List<String> getBySpecificAlphabetSortedByLength(
            List<String> stringList, Set<Character> alphabet) {
        return stringList.stream()
                .filter(s -> IntStream.range(0, s.length())
                        .mapToObj(s::charAt)
                        .allMatch(alphabet::contains))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> getListOfBinaryRepresentation(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> getPalindromes(int start, int bound) {
        return IntStream.rangeClosed(start, bound)
                .filter(number -> new StringBuilder(String.valueOf(number))
                        .reverse()
                        .toString()
                        .contentEquals(String.valueOf(number)))
                .boxed()
                .toList();
    }
}

package faang.school.godbless.streamApi2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Evgenii Malkov
 */
public class Utils {

    public static List<List<Integer>> getUniquePairsSumEqualGivenNumber(List<Integer> nums, int targetNum) {
        Set<Integer> set = new HashSet<>();
        return nums.stream()
                .filter((num) -> {
                    int key = targetNum - num;
                    if (set.contains(key)) {
                        set.remove(key);
                        return true;
                    }
                    set.add(num);
                    return false;
                })
                .map(num -> Arrays.asList(targetNum - num, num))
                .toList();
    }

    public static List<String> getCapitalsOfSortedCountries(Map<String, String> countryCapital) {
        return countryCapital.keySet().stream().sorted().map(countryCapital::get).toList();
    }

    public static List<String> getAskLengthSortedListStartingWith(Collection<String> rows, char startedChar) {
        return rows.stream()
                .filter((row) -> row.startsWith(String.valueOf(startedChar)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<List<String>> getNonFriendsUsers(Map<String, List<String>> userFriends) {
        return userFriends.entrySet().stream()
                .flatMap((entry) -> userFriends.entrySet().stream()
                        .filter((e) -> !e.getKey().equals(entry.getKey()) && !entry.getValue().contains(e.getKey()))
                        .filter((e) -> e.getValue().stream().anyMatch(name -> entry.getValue().contains(name)))
                        .map((user) -> List.of(entry.getKey(), user.getKey())))
                .toList();
    }

    public static Map<String, Double> getDepartmentAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> getAlphabeticRowsSortedByLength(List<String> rows, char[] alphabet) {
        return rows.stream()
                .filter((row) -> row.chars().allMatch((c) -> {
                    boolean match = false;
                    for (char letter : alphabet) {
                        if (letter == c) {
                            match = true;
                            break;
                        }
                    }
                    return match;
                }))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertIntegersToBinaryStrings(List<Integer> integers) {
        return integers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> getPalindromeNumbers(int start, int finish) {
        return IntStream.range(start, finish)
                .filter(val -> {
                    int original = Math.abs(val);
                    if (original / 10 < 1) {
                        return false;
                    }
                    int reversed = 0;
                    int temp = original;

                    while (temp != 0) {
                        int digit = temp % 10;
                        reversed = reversed * 10 + digit;
                        temp /= 10;
                    }

                    return original == reversed;
                })
                .boxed()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}

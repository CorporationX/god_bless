package school.faang.moduleone.sprinttwo.task_43540;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskUtils {

    public static Set<Set<String>> findPairsWithCommonFriends(Map<String, List<String>> source) {
        Set<Set<String>> result = new HashSet<>();

        source.forEach((key, everyPersonFriends) -> {
            for (int i = 0; i < everyPersonFriends.size(); i++) {
                String friend = everyPersonFriends.get(i);
                everyPersonFriends.stream()
                        .filter(it -> !it.equals(friend))
                        .filter(it -> !source.get(it).contains(friend))
                        .forEach(it -> result.add(Set.of(friend, it)));
            }
        });
        return result;
    }

    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<Integer> findPalindromeNumbersInRange(int minBoarder, int maxBoarder) {
        return IntStream.rangeClosed(minBoarder, maxBoarder)
                .boxed()
                .map(String::valueOf)
                .filter(str -> str.contentEquals(new StringBuilder(str).reverse()))
                .map(Integer::valueOf)
                .toList();
    }

    public static List<String> findSubstringsPalindromes(String source) {
        List<String> result = new ArrayList<>();
        int n = source.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String substring = source.substring(i, j);
                if (isPalindrome(substring)) {
                    result.add(substring);
                }
            }
        }
        return result;
    }

    public static List<Integer> findAllPerfectNumbersInRange(int min, int max) {
        return IntStream.rangeClosed(min, max)
                .filter(it -> it == findAllDividers(it).stream().mapToInt(Integer::valueOf).sum())
                .boxed()
                .toList();
    }

    private static boolean isPalindrome(String substring) {
        return substring.equals(new StringBuilder(substring).reverse().toString());
    }

    private static List<Integer> findAllDividers(Integer number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }
}

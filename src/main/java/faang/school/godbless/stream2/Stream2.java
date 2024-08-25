package faang.school.godbless.stream2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream2 {
    public static List<List<Integer>> getPairs(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.stream().peek(set::remove).filter(x -> set.contains(sum - x)).map(x -> List.of(x, sum - x)).toList();
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> filterSortStrings(List<String> strings, char starts) {
        return strings.stream().filter(str -> str.startsWith(String.valueOf(starts))).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<List<String>> getCommonFriends(Map<String, List<String>> friendsMap) {
        throw new UnsupportedOperationException();
    }

    public record Employee(String name, int salary, String department) {
    }

    public static Map<String, Double> getMedianSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::department,
                Collectors.averagingInt(Employee::salary)));
    }

    public static List<String> filterByABC(List<String> strings, List<Character> letters) {
        Pattern pattern = Pattern.compile("^[" + letters + "]+$", Pattern.CASE_INSENSITIVE);
        return strings.stream().filter(s -> pattern.matcher(s).matches()).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> getBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> getPalindroms(int from, int to) {
        return IntStream.range(from, to).filter(Stream2::isPalindrome).boxed().toList();
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String value = String.valueOf(x);
        for (int i = 0; i < value.length() / 2; i++) {
            if (value.charAt(i) != value.charAt(value.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

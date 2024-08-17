package faang.school.godbless.stream2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream2 {
    public static List<List<Integer>> getPairs(List<Integer> numbers, int sum) {
        List<Integer> pairs = new ArrayList<>();
        numbers.stream().forEach(number -> {
            var pair = sum - number;
            if (numbers.contains(pair) && !pairs.contains(pair)) {
                pairs.add(number);
            }
        });
        return pairs.stream().map(pair -> List.of(pair, sum - pair)).toList();
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
        return strings.stream()
                .filter(s -> pattern.matcher(s).matches())
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> getBinary(List<Integer> numbers) {
        return numbers.stream().map(Stream2::toBinaryString).toList();
    }

    private static String toBinaryString(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            int remainder = num % 2;
            binary.append(remainder);
            num = num / 2;
        }
        return binary.reverse().toString();
    }

    public static List<Integer> getPalindroms(int from, int to) {
        return IntStream.range(from, to).filter(Stream2::isPalindrome).boxed().toList();
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int reversed = 0;
        int remainder;
        while (x != 0) {
            remainder = x % 10;
            reversed = reversed * 10 + remainder;
            x = x / 10;
        }
        return original == reversed;
    }
}

package faang.school.godbless.streamapi1;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MathMethods {
    public static int sumOfEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxElement(List<Integer> nums) {
        return nums.stream()
                .max(Comparator.comparingInt(num -> num))
                .orElse(0);
    }

    public static int mean(List<Integer> nums) {
        return (int) nums.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    public static int numberOfStrings(List<String> stringList, char beginChar) {
        String beginString = String.valueOf(beginChar);
        return (int) stringList.stream()
                .filter(str -> str.startsWith(beginString))
                .count();
    }

    public static List<String> filterBySubstring(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allElementsMatchCondition(List<String> stringList, char endChar) {
        String endString = String.valueOf(endChar);
        return stringList.stream()
                .allMatch(str -> str.endsWith(endString));
    }

    public static int findMinGreaterThan(List<Integer> nums, int target) {
        return nums.stream()
                .filter(num -> num > target)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("No element found greater that target"));
    }

    public static List<Integer> listToLength(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}

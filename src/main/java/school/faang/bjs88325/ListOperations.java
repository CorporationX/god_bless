package school.faang.bjs88325;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> integerList) {
        int sum = 0;
        for (int num : integerList) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static int findMax(List<Integer> integerList) {
        validateList(integerList);

        int max = integerList.get(0);
        for (int num : integerList) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findAverage(List<Integer> integerList) {
        validateList(integerList);
        int sum = 0;
        for (int num : integerList) {
            sum += num;
        }
        return sum / integerList.size();
    }

    public static int countStringsStartingWith(List<String> stringList, char c) {
        int count = 0;
        for (String str : stringList) {
            if (!str.isEmpty() && str.charAt(0) == c) {
                count++;
            }
        }
        return count;
    }

    public static String filterStringsContainingSubstring(List<String> strings, String value) {
        validateList(strings);
        List<String> filteredStrings = strings.stream()
            .filter(s -> s.contains(value))
            .collect(Collectors.toList());
        return filteredStrings.toString();
    }

    public static String sortByLength(List<String> strings) {
        validateList(strings);
        strings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        return strings.toString();
    }

    public static String allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        boolean allMatch = numbers.stream().allMatch(condition);
        return String.valueOf(allMatch);
    }

    public static String findMinGreaterThan(List<Integer> numbers, int i) {
        validateList(numbers);
        return numbers.stream()
            .filter(num -> num > i)
            .min(Integer::compareTo)
            .map(String::valueOf)
            .orElse("No such number");
    }

    public static String convertToLengths(List<String> strings) {
        validateList(strings);
        List<Integer> lengths = strings.stream()
            .map(String::length)
            .collect(Collectors.toList());
        return lengths.toString();
    }

    private static <T> void validateList(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список значений не может быть пуст!");
        }
    }
}

package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@SuppressWarnings("checkstyle:Indentation")
public class ListOperations {

    public static int sum(List<Integer> list) {
        return list.stream()
                .filter(i -> i % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int max(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static double average(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }


    public static long countStringsStartingWith(List<String> list, char r) {
            return list.stream()
                    .filter(s -> !s.isEmpty() && s.charAt(0) == r)
                    .count();
        }

    public static List<String> filterStringsContainingSubstring(List<String> list, String substring) {
            return list.stream()
                    .filter(s -> s.contains(substring))
                    .collect(Collectors.toList());
        }

        public static List<String> sortByLength(List<String> list) {
            return list.stream()
                    .sorted(Comparator.comparingInt(String::length))
                    .collect(Collectors.toList());
        }

        public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
            return list.stream()
                    .allMatch(predicate);
        }

        public static int findMinGreaterThan(List<Integer> list, int value) {
            return list.stream()
                    .filter(n -> n > value)
                    .min(Integer::compareTo)
                    .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + value));
        }

        public static List<Integer> convertToLengths(List<String> list) {
            return list.stream()
                    .map(String::length)
                    .collect(Collectors.toList());
        }
    }




package school.faang.sream_api1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class StreamMethods {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(evenNumberSum(list));
        System.out.println(foundMaxNumber(list));
    }

    static int evenNumberSum(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
    }

    static int foundMaxNumber(List<Integer> list) {
        return list.stream()
                .max(Integer::compare)
                .get();
    }

    static Double foundMediumNumber(List<Integer> list) {
        return list.stream()
                .collect(Collectors
                        .averagingInt(Integer::intValue));
    }

    static long stringNumber(List<String> list, char ch) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .count();
    }

    static List<String> filterListBySubstringLength(List<String> list, String string) {
        return list.stream()
                .filter(s -> s
                        .contains(string))
                .collect(Collectors.toList());
    }

    static List<String> sortListByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    static boolean checkList(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    static int foundMinNumber(List<Integer> list, int num) {
        return list.stream()
                .filter(x -> x > num)
                .min(Integer::compare).get();
    }

    static List<Integer> convertStringToStringLength(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
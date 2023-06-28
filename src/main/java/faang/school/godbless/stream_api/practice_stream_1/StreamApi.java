package faang.school.godbless.stream_api.practice_stream_1;

import java.util.List;
import java.util.Optional;

public class StreamApi {
    public static int evenSum(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, (n1, n2) -> n1 + n2);
    }

    public static Integer maxNum(List<Integer> nums) {
        return nums.stream()
                .max((n1, n2) -> n1 - n2)
                .orElseThrow();
    }

    public static Double avg(List<Integer> nums) {
        return nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static int count(List<String> stringList) {
        return (int) stringList.stream()
                .filter(item -> item.charAt(0) == 'A')
                .count();
    }

    public static List<String> filter(List<String> stringList) {
        return stringList.stream()
                .filter(s -> s.contains("111"))
                .toList();
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    public static boolean allMatch(List<Integer> numList) {
        return numList.stream()
                .allMatch(num -> num > 10);
    }

    public static Integer leastNum(List<Integer> numList, int condition) {
        return numList.stream()
                .filter(num -> num > condition)
                .min((n1, n2) -> n1 - n2)
                .orElseThrow();
    }

    public static List<Integer> toLengthList(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }

}

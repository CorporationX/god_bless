package faang.school.godbless.stream_api_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Макар", "Дмитрий", "Володя", "Юра", "Микеланджело", "Рома");
        List<Integer> nums = Arrays.asList(13, 4, 54, 56, 87, 54, 32, 34);

        System.out.println(TestingStream.sum(nums));
        System.out.println(TestingStream.max(nums));
        System.out.println(TestingStream.average(nums));
        System.out.println(TestingStream.countLinesStartingWithCertainChar(names, "М"));
        System.out.println(TestingStream.filterContainsSubstring(names, "ел"));
        System.out.println(TestingStream.sortingNamesByLength(names));
        boolean cheking = TestingStream.meetSpecificCondition(nums, num -> nums.contains(56));
        System.out.println("Содержит  - " + cheking);
        System.out.println(TestingStream.findSmallestElementGreaterThan(nums, 5));
        System.out.println(TestingStream.convertStringToLetterLength(names));
    }
}

class TestingStream {
    public static int sum(List<Integer> nums) {
        return nums.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public static double average(List<Integer> nums) {
        return nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static long countLinesStartingWithCertainChar(List<String> list, String subString) {
        return list.stream()
                .filter(string -> string.startsWith(subString))
                .count();
    }

    public static List<String> filterContainsSubstring(List<String> list, String subString) {
        return list.stream()
                .filter(string -> string.contains(subString))
                .toList();
    }

    public static List<String> sortingNamesByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(String::length)) // вот эта строчка кровошку попила, сначала сортировала по алфавиту
                .toList();
    }

    public static <T> boolean meetSpecificCondition(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    public static int findSmallestElementGreaterThan(List<Integer> nums, int importance) {
        return nums.stream()
                .filter(num -> num > importance)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> convertStringToLetterLength(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
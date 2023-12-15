package faang.school.godbless.stream_api_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Макар", "Дмитрий", "Володя", "Юра", "Микеланджело", "Рома");
        List<Integer> nums = Arrays.asList(13, 4, 54, 56, 87, 54, 32, 34);

        System.out.println(TestingStream.sum(nums));
        System.out.println(TestingStream.max(nums));
        System.out.println(TestingStream.average(nums));
        System.out.println(TestingStream.countLinesStartingWithCertainChar(names, "М"));
        System.out.println(TestingStream.filterContainsSubstring(names, "ел"));
        System.out.println(TestingStream.sortingNamesByLongLines(names));
        System.out.println(TestingStream.meetSpecificCondition(nums, 54));
        System.out.println(TestingStream.findSmallerLargerNumberOf(nums, 5));
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

    public static List<String> sortingNamesByLongLines(List<String> list) {
        return list.stream()
                .peek(string -> string.length())
                .sorted(Comparator.comparing(String::length)) // вот эта строчка кровошку попила, сначала сортировала по алфавиту
                .toList();
    }

    public static boolean meetSpecificCondition(List<Integer> nums, int x) {
        return nums.stream()
                .allMatch(num -> num == x);
    }

    public static int findSmallerLargerNumberOf(List<Integer> nums, int importance) {
        return nums.stream()
                .filter(num -> num > importance)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> convertStringToLetterLength(List<String> list) {
        return list.stream()
                .map(String::length)
                .sorted()
                .toList();
    }
}
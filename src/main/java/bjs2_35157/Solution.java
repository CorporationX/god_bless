package bjs2_35157;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static Set<List<Integer>> findPairs(List<Integer> list, int target) {
        Set<List<Integer>> pairs = new HashSet<>();
        List<Integer> sortedList = list.stream().sorted().toList();

        int left = 0;
        int right = sortedList.size() - 1;

        while (left < right) {
            int sum = sortedList.get(left) + sortedList.get(right);

            if (sum == target) {
                pairs.add(List.of(sortedList.get(left), sortedList.get(right)));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }

        }
        return pairs;
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries
                .keySet()
                .stream()
                .sorted(String::compareTo)
                .map(countries::get)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char symbol) {
        return strings
                .stream()
                .filter(string -> string.startsWith(Character.toString(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> integerToBinaryString(List<Integer> nums) {
        return nums
                .stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        return strings
                .stream()
                .filter(string -> string.chars()
                        .allMatch(symbol -> alphabet.contains(Character.toString(symbol)))
                )
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

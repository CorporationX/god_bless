package school.faang.bjs2_80675;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>(
                Set.of(1, 2, 3, 4, 5, 6)
        );
        List<Integer> nums2 = new ArrayList<>(List.of(1, 2, 3, 4));
        Map<String, String> coutries = new HashMap<>(
                Map.of(
                        "Russia", "Moscow",
                        "USA", "Washington",
                        "Germany", "Berlin"
                )
        );
        List<String> strings = new ArrayList<>(List.of("apple", "banana", "cherry", "date", "fig", "grape"));

        System.out.println(getUniquePars(nums, 6));
        System.out.println(getCapitals(coutries));
        System.out.println(sortAndFilter(strings, 'a'));
        System.out.println(transformToByteCode(nums2));
        System.out.println(sortAndFilter2(strings, "abcdefghijklmnopqrstuvwxyz"));
    }

    public static Set<List<Integer>> getUniquePars(Set<Integer> nums, int target) {
        return nums.stream()
                .filter(num -> num != target - num && nums.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> sortAndFilter(List<String> strings, char startWith) {
        return strings.stream()
                .filter(string -> string.charAt(0) == startWith)
                .sorted()
                .toList();
    }

    public static List<String> transformToByteCode(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortAndFilter2(List<String> strings, String allowedString) {
        Set<Character> allowedChars = allowedString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(str -> str.chars().allMatch(c -> allowedChars.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

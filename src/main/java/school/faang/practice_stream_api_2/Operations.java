package school.faang.practice_stream_api_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {
    public static List<List<Integer>> findUniquePairsWithSpecificSum1(List<Integer> nums, int target) {
        Set<Integer> setNumbers = new HashSet<>(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int num : setNumbers) {
            int complement = target - num;
            if (setNumbers.contains(complement) && complement > num) {
                result.add(List.of(num, complement));
            }
        }
        return result;
    }

    public static List<List<Integer>> findUniquePairsWithSpecificSum2(List<Integer> nums, int target) {
        Set<Integer> setNumbers = new HashSet<>(nums);
        List<List<Integer>> result = new ArrayList<>();
        nums.stream()
                .forEach(num -> {
                    int complement = target - num;
                    if (setNumbers.contains(complement) && complement > num) {
                        result.add(List.of(num, complement));
                    }
                });
        return result;
    }

    public static List<List<Integer>> findUniquePairsWithSpecificSum3(List<Integer> nums, int target) {
        return nums.stream()
                .flatMap(num1 -> nums.stream()
                        .filter(num2 -> num2 < num1 && num1 + num2 == target)
                        .map(num2 -> List.of(num1, num2))
                        )
                .toList();
    }

    public static List<String> sortCountries1(Map<String, String> countryCity) {
        return countryCity.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> sortCountries2(Map<String, String> countryCity) {
        return countryCity.keySet().stream()
                .sorted()
                .map(countryCity::get)
                .toList();
    }

    public static List<String> filterSort(List<String> lines, char target) {
        return lines.stream()
                .filter(line -> line.toLowerCase().startsWith(String.valueOf(target).toLowerCase()))
                .sorted()
                .toList();
    }

    public static List<String> covertToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabet(List<String> lines, String alphabet) {
        Set<Character> setOfVarsAllowed = alphabet.chars()
                .mapToObj(symbol -> (char) symbol)
                .collect(Collectors.toSet());
        return lines.stream()
                .filter(line -> line.chars().allMatch(num -> setOfVarsAllowed.contains((char) num)))
                .sorted()
                .toList();
    }
}

package school.faang.streamapi2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static List<int[]> findUniquePairs(Set<Integer> numbers, int targetSum) {
        List<int[]> pairs = new ArrayList<>();
        new HashSet<>(numbers)
                .stream()
                .filter(n -> numbers.contains(targetSum - n))
                .forEach(n -> {
                    int partner = targetSum - n;
                    if (numbers.remove(n) && numbers.remove(partner)) {
                        pairs.add(new int[]{n, partner});
                    }
                });
        return pairs;
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByChar(List<String> strings, char ch) {
        return strings
                .stream()
                .filter(s -> s.charAt(0) == ch)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers
                .stream()
                .map(Solution::convertToBinary)
                .toList();
    }

    public static List<String> filterByAlphabetAndSort(List<String> words, String alphabet) {
        String allowedAlphabet = alphabet.toLowerCase();
        return words
                .stream()
                .filter(
                        word -> word.toLowerCase()
                                .chars()
                                .allMatch(ch -> allowedAlphabet.indexOf(ch) != -1)
                )
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static String convertToBinary(int number) {
        if (number == 0) {
            return "0";
        }

        boolean isNegative = number < 0;
        int n = Math.abs(number);

        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            int remainder = n % 2;
            binary.insert(0, remainder);
            n = n / 2;
        }

        if (isNegative) {
            binary.insert(0, "-");
        }

        return binary.toString();
    }
}

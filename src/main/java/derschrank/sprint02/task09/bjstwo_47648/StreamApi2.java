package derschrank.sprint02.task09.bjstwo_47648;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi2 {
    public static List<List<Integer>> oneFindSum(List<Integer> numbers, int sum) {
        return numbers.stream()
                .distinct()
                .filter(x -> numbers.contains(sum - x))
                .map(x -> x < sum - x ? List.of(x, sum - x) :  List.of(sum - x, x))
                .collect(Collectors.toSet())
                .stream()
                .sorted((o1, o2) -> o1.get(0) - o2.get(0))
                .toList();
    }

    public static List<String> twoSortCountryAndGetCapital(Map<String, String> countryAndCapital) {
        return countryAndCapital
                .keySet()
                .stream()
                .sorted()
                .map(x -> countryAndCapital.get(x))
                .toList();
    }

    public static List<String> threeFindCharAndSortStrings(List<String> strings, char ch) {
        return strings.stream()
                .filter(x -> x.startsWith(Character.toString(ch)))
                .sorted((o1, o2) -> o1.length() - o2.length())
                .toList();
    }

    public static List<String> fourDecToBin(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> fiveFilterByAlphabetAndSortByLength(List<String> string, String alphabet) {
        return string.stream()
                .filter(
                        word -> word.chars().allMatch(ch -> alphabet.contains(Character.toString(ch)))
                )
                .sorted((o1, o2) -> o1.length() - o2.length())
                .toList();
    }
}
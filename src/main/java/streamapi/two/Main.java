package streamapi.two;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static Set<List<Integer>> findPairNumb(List<Integer> integerList, int targetSum) {
        return integerList.stream()
                .flatMap(i -> integerList.stream()
                        .filter(j -> i < j && i + j == targetSum)
                        .map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedListOfCapitals(Map<String, String> capitalsMap) {
        return capitalsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortString(List<String> stringList, char letter) {

        return stringList.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> stringList, char[] alphabet) {
        Set<Character> alphabetSet = new String(alphabet).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return stringList.stream()
                .filter(str -> str.chars().allMatch(c -> alphabetSet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertIntToBinaryString(List<Integer> integerList) {
        return integerList.stream().map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }
}

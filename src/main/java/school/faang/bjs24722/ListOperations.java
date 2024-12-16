package school.faang.bjs24722;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findUniquePairsOfNumbers(List<Integer> numbers, int sum) {
    //   Set<List<Integer>> uniquePairs;
   /*      Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        uniquePairs = numbers.stream()
                .filter(n -> uniqueNumbers.contains(sum - n))
                .map(n -> Arrays.asList(n, sum - n))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return uniquePairs;*/

  /*      return numbers.stream()
                .distinct()
                .filter(n -> numbers.contains(sum - n))
                .map(n -> {
                    int a = n;
                    int b = sum - n;
                    return a < b ? Map.entry(a, b) : Map.entry(b, a);
                })
                .distinct()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toCollection(Set.of(Se)::new));*/
            //    .collect(Collectors.toCollection(LinkedHashSet::new));

        return null;
    }

    public static List<String> sortCountriesAndEnterCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, char letter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> mapToBinaryAsStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAbcAndSortAscStrings(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        Pattern pattern = Pattern.compile(regex);
        return strings.stream()
                .filter(s -> pattern.matcher(s).find())
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
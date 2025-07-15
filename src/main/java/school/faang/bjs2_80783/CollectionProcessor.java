package school.faang.bjs2_80783;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionProcessor {
    public static Set<Pair> findPairs(Set<Integer> numbers, int resolveSumNumber) {
        Set<Pair> findingNumbers = new HashSet<>();

        numbers.forEach(number -> {
            int findingNumber = resolveSumNumber - number;
            if ((numbers.contains(findingNumber)) && (number < findingNumber)) {
                findingNumbers.add(new Pair(number, findingNumber));
            }
        });
        return findingNumbers;
    }

    public static Set<String> findCapitalAndSorted(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    public static List<String> filterForStartCharAndSortStrings(Set<String> strings, char startChar) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(startChar)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> decimalToBinary(Set<Integer> numbers) {
        List<String> binaryNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            StringBuilder binaryNumber = new StringBuilder();
            while (number != 0) {
                binaryNumber.append(number % 2);
                number /= 2;
            }
            binaryNumber.reverse();
            binaryNumbers.add(String.valueOf(binaryNumber));
        });
        return binaryNumbers;
    }

    public static List<String> filterForAlphabetAndSortStrings(Set<String> strings, String alphabet) {
        List<String> alphabetList = Arrays.asList(alphabet.split(""));
        return strings.stream()
                .filter(string -> {
                    List<String> stringList = Arrays.asList(string.split(""));
                    return new HashSet<>(alphabetList).containsAll(stringList);
                })
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
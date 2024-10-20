package school.faang.stream.api.second;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Pair> pairs = findPairsEqualTarget(List.of(1, 2, 3, 4, 5, 6, 6), 7);
        System.out.println("Уникальные пары чисел с суммой 7: " + pairs);

        List<String> capitals = sortAndPrintCapitals(Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        ));
        System.out.println("Столицы отсортированные по алфавиту " + capitals);

        List<String> filteredByPrefixStrings = filterByPrefixAndSortByLength(
                List.of("apple", "banana", "avocado", "apricot"), 'a');
        System.out.println("Строки, которые начинаются c символа \"a\": " + filteredByPrefixStrings);

        List<String> binaryFormatNums = convertToBinaryFormat(List.of(1, 2, 3, 4));
        System.out.println("Числа в двоичном формате: " + binaryFormatNums);

        List<String> filteredByAlphabetStrings = filterByAlphabetAndSortByLength(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"
        );
        System.out.println("Строки, которые содержат буквы только из заданного алфавита: " +
                filteredByAlphabetStrings);
    }

    public static List<Pair> findPairsEqualTarget(List<Integer> numbers, int target) {
        Set<Integer> seen = new HashSet<>();
        return numbers.stream()
                .flatMap((num) -> {
                    seen.add(num);
                    int complement = target - num;
                    if (seen.contains(complement)) {
                        return Stream.of(new Pair(num, complement));
                    }
                    return Stream.empty();
                })
                .distinct()
                .toList();
    }

    public static List<String> sortAndPrintCapitals(Map<String, String> countryToCapital) {
        return countryToCapital.keySet().stream()
                .sorted()
                .map(countryToCapital::get)
                .toList();
    }

    public static List<String> filterByPrefixAndSortByLength(List<String> strings, char prefix) {
        return strings.stream()
                .filter((str) -> str.charAt(0) == prefix)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        Set<Character> alphabetSet = new HashSet<>();
        for (char c : alphabet.toCharArray()) {
            alphabetSet.add(c);
        }
        return strings.stream()
                .filter((str) -> {
                    for (char c : str.toCharArray()) {
                        if (!alphabetSet.contains(c)) {
                            return false;
                        }
                    }
                    return true;
                })
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

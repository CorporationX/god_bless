package school.faang.sprint2.bjs2_58092;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOfOperations {
    public static Set<List<Integer>> findPairs(@NonNull Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(number -> numbers.contains(sum - number) && sum - number < number)
                .map(number -> List.of(number, sum - number))
                .collect(Collectors.toSet());
    }

    public static List<String> sortAndFindCapital(@NonNull Map<String, String> country) {
        return country.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(@NonNull List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(@NonNull List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(@NonNull List<String> strings, @NonNull String alphabet) {
        String regex = String.format("[%s]+", alphabet);
        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

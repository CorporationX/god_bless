package school.faang.sprint2.task_47089;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Operations {

    public List<List<Integer>> findPairs(@NonNull List<Integer> numbers, int sum) {
        return numbers.stream()
                .flatMap((num) -> numbers.stream()
                        .filter((n) -> sum - n == num)
                        .map((i) -> Stream.of(num, i)
                                .sorted()
                                .toList()))
                .distinct()
                .toList();
    }

    public List<String> sortCapitalsOfCountries(@NonNull Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> sortByLengthStartingWith(@NonNull List<String> strings, char firstLetter) {
        return strings.stream()
                .filter((s) -> s.startsWith(String.valueOf(firstLetter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> convertToBinary(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterAndSortStringsByAlphabet(@NonNull List<String> inputStrings, String allowedAlphabet) {
        return inputStrings.stream()
                .filter((string) ->
                        IntStream.range(0, string.length())
                                .mapToObj((index) -> String.valueOf(string.charAt(index)))
                                .allMatch(allowedAlphabet::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

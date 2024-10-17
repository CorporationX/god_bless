package school.faang.streamApiSecond;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamService {

    public Set<List<Integer>> getGropedNumbers(List<Integer> numbers, Integer target) {
        Set<List<Integer>> pairs;
        Set<Integer> set = new HashSet<>(numbers);
        pairs = numbers.stream()
                .filter(num -> set.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public List<String> sortByAlphabet(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> convertToBinary(List<Integer> decimalNumbers) {
        return decimalNumbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterWordsByLengthAndAlphabet(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> word.chars().anyMatch(c -> alphabet.indexOf(c) >=0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }


}

package school.faang.stream2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stream {

    public List<Set<Integer>> findUniqueNumberPairs(Set<Integer> numbers, Integer sum) {
        return numbers.stream()
                .filter(num -> numbers.contains(sum - num) && num != sum - num)
                .map(num -> Set.of(num, sum - num))
                .distinct().toList();
    }

    public List<String> sortCountryCapitalsList(Map<String, String> countriesCity) {
        return countriesCity.keySet().stream().sorted()
                .map(countriesCity::get).toList();
    }

    public List<String> filterWordsByInitialLetterSortBySize(List<String> strings, char startOfWord) {
        return strings.stream()
                .filter(item -> item.charAt(0) == startOfWord)
                .sorted()
                .toList();
    }

    public List<String> convertIntegerToBinary(Set<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString).toList();
    }

    public List<String> filterWordsBySetOfLetterSortBySize(List<String> strings, String match) {
        return strings.stream()
                .filter(item -> item.matches("[" + match + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

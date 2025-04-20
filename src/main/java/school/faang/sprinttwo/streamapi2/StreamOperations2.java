package school.faang.sprinttwo.streamapi2;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class StreamOperations2 {
    public Set<Set<Integer>> unicPairOfNumbers(Set<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> a + b == target && a < b)
                        .map(b -> Set.of(a, b)))
                .collect(Collectors.toSet());
    }

    public List<String> getCapitalOfCountry(Map<String, String> capital) {
        return capital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> sortbyChareAndOrderByLenght(List<String> fruits, Character ch) {
        return fruits.stream()
                .filter(fr -> fr.startsWith(Character.toString(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> getListOfPrimeNumbers(List<Integer> listOfPrimeNumbers) {
        return listOfPrimeNumbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> getWordsWithAlphabetLetter(List<String> fruits, String alphabet) {
        Set<Integer> alphabetSet = alphabet.codePoints().boxed().collect(Collectors.toSet());
        return fruits.stream()
                .filter(word -> word.codePoints().allMatch(alphabetSet::contains))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
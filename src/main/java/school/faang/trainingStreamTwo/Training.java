package school.faang.trainingStreamTwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Training {
    public static Set<String> sumNumber(Set<Integer> setNumber, int number) {
        List<String> pairs = new ArrayList<>();
        setNumber.stream()
                .filter(numberOne -> {
                    int numberTwo = number - numberOne;
                    return setNumber.contains(numberTwo) && numberTwo > numberOne;
                })
                .forEach(numberOne -> pairs.add(numberOne + ";" + (number - numberOne)));
        return pairs.stream()
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCountry(Map<String, String> countryCapital) {
        return countryCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortedList(List<String> wordList, char c) {
        return wordList.stream()
                .filter(a -> a.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> converter(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSorted(List<String> words, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return words.stream()
                .filter(a -> a.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

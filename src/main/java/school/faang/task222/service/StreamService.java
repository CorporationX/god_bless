package school.faang.task222.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamService {
    public static List<ServiceNumber> getPair(List<Integer> list, int sum) {
        Set<Integer> numbers = new HashSet<>(list);
        List<ServiceNumber> numberList;
        numberList = list.stream()
                .filter(p -> numbers.contains(sum - p))
                .map(n -> new ServiceNumber(n, sum - n))
                .limit(numbers.size() % 2 == 0 ? numbers.size() / 2 : numbers.size() / 2 + 1)
                .collect(Collectors.toList());
        return numberList;
    }

    public static List<String> sortCountry(Map<String, String> country) {
        return country.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortByLengthAndStartWith(List<String> list, String symbol) {
        return list.stream()
                .filter(s -> s.startsWith(symbol))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> getListOfBytes(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> sortByAlphabetAndMatch(List<String> list, String alphabet) {
        return list.stream()
                .filter(s -> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}

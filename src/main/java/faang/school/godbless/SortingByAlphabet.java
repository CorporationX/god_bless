package faang.school.godbless;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortingByAlphabet {
    public static List<String> sortByAlphabet(List<String> list, String alphabet) {
        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return list.stream()
                .filter(str -> str.chars().allMatch(c -> alphabetSet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
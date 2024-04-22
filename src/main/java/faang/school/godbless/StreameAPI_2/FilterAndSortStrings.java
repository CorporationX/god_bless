package faang.school.godbless.StreameAPI_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilterAndSortStrings {
    public static List<String> findStringsContainsOnlyThisAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> Arrays.stream(s.split(""))
                        .allMatch(alphabet::contains))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}

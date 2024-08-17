package faang.school.godbless;

import java.util.List;
import java.util.stream.Collectors;

public class FilterTheListOfStrings {
    public static List<String> filterStringsContainingSubstring(List<String> stringList, String subString) {
        return stringList.stream()
                .filter(s -> s.contains(subString))
                .collect(Collectors.toList());
    }
}
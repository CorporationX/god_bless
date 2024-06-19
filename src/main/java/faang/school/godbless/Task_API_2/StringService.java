package faang.school.godbless.Task_API_2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringService {

    public static List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> stringFilter(List<String> strings, char s) {
        return strings.stream()
                .filter(str->str.startsWith(String.valueOf(s)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

}

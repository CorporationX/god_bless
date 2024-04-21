package faang.school.godbless.StreameAPI_2;

import java.util.List;
import java.util.stream.Collectors;

public class FilterOfString {
    public static List<String> filterChar(List<String> strings, char charFilter) {
        return strings.stream()
                .filter(s -> s.charAt(0) == charFilter || s.charAt(0) == Character.toUpperCase(charFilter))
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .collect(Collectors.toList());
    }
}


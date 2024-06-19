package faang.school.godbless.Task_API_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {

    public static List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}

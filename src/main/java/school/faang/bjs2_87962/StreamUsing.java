package school.faang.bjs2_87962;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamUsing {

    public static Set<List<Integer>> findUniqueNumbers(Set<Integer> numbers, int numb) {

        return numbers.stream().filter(num -> num != numb - num && numbers.contains(numb - num))
                .map(num -> Arrays.asList(num, numb - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortContries(Map<String, String> capitals) {
        return capitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }
}

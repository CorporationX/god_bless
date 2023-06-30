package faang.school.godbless.Sprint3.Task_17_StreamAPI_2;


import java.util.*;

public class StreamAPI_2 {

    public static List<List<Integer>> findUniquePairs (List<Integer> numbers, int sum) {
        List<List<Integer>> pairs = new ArrayList<>();

        numbers.stream()
                .distinct()
                .filter(number -> numbers.contains(sum - number))
                .map(number -> Arrays.asList(number, sum - number))
                .forEach(pairs::add);

        return pairs;
    }

    public static List<String> showCapitals (Map<String, String> countries) {
        List<String> capitals = new ArrayList<>();

        countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();

        return capitals;
    }
}

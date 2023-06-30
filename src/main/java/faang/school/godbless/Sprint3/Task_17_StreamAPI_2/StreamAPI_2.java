package faang.school.godbless.Sprint3.Task_17_StreamAPI_2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}

package faang.school.godbless.streamApiTrain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstTrain {
    private FirstTrain() {

    }

    public static int evenSum(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int getMax(List<Integer> list) {
        Optional<Integer> max = list.stream()
                .max(Comparator.comparingInt(x -> x));
        if (max.isPresent()) {
            return max.get();
        } else {
            throw new RuntimeException("метод Stream.max вернул null");
        }
    }

    public static double getAverage(List<Integer> list) {
        return list.stream()
                .map(x -> x/(double)list.size())
                .reduce(0d, Double::sum);
    }


    public static long getCount(List<String> strings, Character c) {
        return strings.stream()
                .filter(string -> string.startsWith(c.toString()))
                .count();
    }
}

package faang.school.godbless.train_stream_one;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMethods {
    public static int getListSum(List<Integer> list) {
        return list.stream().reduce((x, y) -> (x + y)).get();
    }

    public static int getMaxListValue(List<Integer> list) {
        return list.stream().max((x, y) -> Integer.compare(x, y)).get();
    }

    public static int getAverageListValue(List<Integer> list) {
        return list.stream().reduce((x, y) -> (x + y)).get()/list.size();
    }

    public static List<String> filterListBySubstring(List<String> list) {
        return list.stream().filter((x)->x.contains("ok")).collect(Collectors.toList());
    }

    public static List<String> getFilteredElementCount(List<String> list) {
        return list.stream().filter((x)->x.startsWith("K")).collect(Collectors.toList());
    }
}

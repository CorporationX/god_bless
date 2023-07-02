package faang.school.godbless.train_stream_one;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMethods {
    public static int getListSum(List<Integer> list) {
        return list.stream().reduce((x, y) -> (x + y)).get();
    }

    public static int getMaxListValue(List<Integer> list) {
        return list.stream().max(Integer::compare).get();
    }

    public static int getAverageListValue(List<Integer> list) {
        return list.stream().reduce(Integer::sum).get() / list.size();
    }

    public static List<String> filterListBySubstring(List<String> list) {
        return list.stream().filter((x) -> x.contains("ok")).collect(Collectors.toList());
    }

    public static List<String> getFilteredElementCount(List<String> list) {
        return list.stream().filter((x) -> x.startsWith("K")).collect(Collectors.toList());
    }

    public static List<String> filterListByItemSize(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static boolean isAllItemMatch(List<String> list) {
        return list.stream().allMatch(x -> x.length() > 2);
    }

    public static int getMinItem(List<Integer> list) {
        return list.stream().filter((x) -> x > 5).min(Comparator.comparingInt(x -> x)).get();
    }

    public static List<Integer> getLengthList(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}

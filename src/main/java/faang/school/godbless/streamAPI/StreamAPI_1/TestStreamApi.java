package faang.school.godbless.streamAPI.StreamAPI_1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreamApi {
    public static int getSumInt(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new NullPointerException("empty");
        }

        return numbers.stream().mapToInt(num -> num).sum();
    }

    public static int getMaxInt(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new NullPointerException("empty");
        }

        return numbers.stream().max(Integer::compare).get();
    }

    public static double getAverageInt(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new NullPointerException("empty");
        }

        return numbers.stream().mapToInt(num -> num).average().orElse(Double.NaN);
    }

    public static int getQuantityFirstEntry(List<String> strings, String string) {
        if (strings.isEmpty()) {
            throw new NullPointerException("empty");
        }

        return (int) strings.stream().filter(s -> s.startsWith(string)).count();
    }

    public static List<String> getFilterSubstring(List<String> strings, String string) {
        if (strings.isEmpty()) {
            throw new NullPointerException("empty");
        }

        return strings.stream().filter(s -> s.contains(string)).collect(Collectors.toList());
    }

    public static List<String> getFilterLength(List<String> strings, int length) {
        if (strings.isEmpty()) {
            throw new NullPointerException("empty");
        }

        return strings.stream().filter(s -> s.length() > length).collect(Collectors.toList());
    }

    public static int getMinFromListButMoreNumber(List<Integer> numbers, int num) {
        if (numbers.isEmpty()) {
            throw new NullPointerException("empty");
        }

        Optional<Integer> opt = numbers.stream().filter(integer -> integer > num).min(Integer::compare);
        if (opt.isEmpty()) {
            throw new NullPointerException("numbers less than a given number");
        }

        return opt.get();
    }

    public static List<Integer> getMapStringLength(List<String> strings) {
        if (strings.isEmpty()) {
            throw new NullPointerException("empty");
        }

        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}

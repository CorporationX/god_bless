package school.faang.streamapi1;

import java.util.List;

public class StreamApiHandler {
    public static int getSum(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).mapToInt(num -> num).sum();
    }

    public static int maxElem(List<Integer> numbers) {
        if (numbers.isEmpty()) return 0;
        return numbers.stream().mapToInt(num -> num).max().getAsInt();
    }

    public static double getAvg(List<Integer> numbers) {
        if (numbers.isEmpty()) return 0;
        return numbers.stream().mapToInt(num -> num).average().getAsDouble();
    }

    public static long getNumberOfStrings(List<String> strings, char symbol) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(symbol))).count();
    }

    public static List<String> getStringsWithSubstring(List<String> strings, String str) {
        return strings.stream().filter(s -> s.contains(str)).toList();
    }
}

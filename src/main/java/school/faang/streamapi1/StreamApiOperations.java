package school.faang.streamapi1;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@UtilityClass
public class StreamApiOperations {
    public int getSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num)
                .sum();
    }

    public int maxElement(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.stream()
                .mapToInt(num -> num)
                .max()
                .getAsInt();
    }

    public double getAvg(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.stream()
                .mapToInt(num -> num)
                .average()
                .getAsDouble();
    }

    public long getNumberOfStrings(List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .count();
    }

    public List<String> getStringsWithSubstring(List<String> strings, String str) {
        return strings.stream()
                .filter(s -> s.contains(str))
                .toList();
    }

    public List<String> getSortedByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public boolean checkIfAllMatch(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public Optional<Integer> getHigherNumber(List<Integer> numbers, int targetForHigher) {
        return numbers.stream()
                .filter(num -> num > targetForHigher)
                .min(Comparator.naturalOrder());
    }

    public List<Integer> getStringsLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}

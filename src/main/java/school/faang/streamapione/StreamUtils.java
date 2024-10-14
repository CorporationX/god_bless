package school.faang.streamapione;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@UtilityClass
public class StreamUtils {

    public int calculateEvenNumbersSum(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "numbers cannot be null");

        return numbers.stream().filter(number -> number % 2 == 0).reduce(0, Integer::sum);
    }

    public Optional<Integer> findMaxNumber(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "numbers cannot be null");

        return numbers.stream().max(Integer::compare);
    }

    public double calculateAverageValue(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "numbers cannot be null");

        return numbers.stream().mapToInt((number) -> number).average().orElse(0);
    }

    public int countStringsStartingWith(List<String> strings, char startingWith) {
        Objects.requireNonNull(strings, "strings cannot be null");

        return (int) strings.stream().filter((string) -> string.charAt(0) == startingWith).count();
    }

    public List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        Objects.requireNonNull(strings, "strings cannot be null");
        Objects.requireNonNull(substring, "substring cannot be null");

        return strings.stream().filter((string) -> string.contains(substring)).toList();
    }

    public List<String> sortStringsByLength(List<String> strings) {
        Objects.requireNonNull(strings, "strings cannot be null");

        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public boolean checkNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        Objects.requireNonNull(numbers, "numbers cannot be null");
        Objects.requireNonNull(predicate, "predicate cannot be null");

        return numbers.stream().allMatch(predicate);
    }

    public Optional<Integer> findMinGreaterThan(List<Integer> numbers, int threshold) {
        Objects.requireNonNull(numbers, "numbers cannot be null");

        return numbers.stream().filter(number -> number > threshold).min(Integer::compare);
    }

    public List<Integer> convertStringsToLengths(List<String> strings) {
        Objects.requireNonNull(strings, "strings cannot be null");

        return strings.stream().map(String::length).toList();
    }
}

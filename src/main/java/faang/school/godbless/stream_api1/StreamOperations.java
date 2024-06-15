package faang.school.godbless.stream_api1;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class StreamOperations {
    public static int evenSum(@NonNull List<Integer> list) {
        return list.stream().filter(integer -> integer % 2 == 0).reduce(0, Integer::sum);
    }

    public static Optional<Integer> maxNumber(@NonNull List<Integer> list) {
        return list.stream().max(Integer::compare);
    }

    public static OptionalDouble avgNumber(@NonNull List<Integer> list) {
        return list.stream().mapToDouble(Double::valueOf).average();
    }

    public static long countStringsStartingWithCharacter(@NonNull List<String> list,
                                                         @NonNull Character start) {
        return list.stream().filter(string -> string.startsWith(String.valueOf(start))).count();
    }

    public static List<String> remainContaining(@NonNull List<String> list,
                                                @NonNull String containing) {
        return list.stream().filter(string -> string.contains(containing)).toList();
    }

    public static List<String> sortStringsByLength(@NonNull List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatcher(@NonNull List<String> list,
                                     @NonNull Predicate<String> conditions) {
        return list.stream().allMatch(conditions);
    }

    public static Optional<Integer> minGreaterThan(@NonNull List<Integer> list,
                                                   int lowerBound) {
        return list.stream().filter(integer -> integer > lowerBound).min(Integer::compare);
    }

    public static List<Integer> stringToItsLength(@NonNull List<String> list) {
        return list.stream().map(String::length).toList();
    }
}

package school.faang.sprint2.bjs2_58357;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Slf4j
public class ListOfOperations {
    public static int sumOfEvenNumbers(@NonNull List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumber(@NonNull List<Integer> list) {
        return list.stream()
                .max(Integer::compare)
                .orElseThrow(ListOfOperations::validateList);
    }

    public static double averageValue(@NonNull List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(ListOfOperations::validateList);
    }

    public static long stringCounter(@NonNull List<String> list, char startingChar) {
        return list.stream()
                .filter(s -> s != null && s.startsWith(String.valueOf(startingChar)))
                .count();
    }

    public static List<String> filterBySubstring(@NonNull List<String> input, String substring) {
        return input.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allElementsSatisfyCondition(@NonNull List<Integer> list,
                                                      @NonNull Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> list, int num) {
        return list.stream()
                .filter(value -> value > num)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(ListOfOperations::validateList);
    }

    public static List<Integer> convertToLengths(@NonNull List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }


    @NonNull
    private static NoSuchElementException validateList() {
        log.error("Вводимый список чисел пуст");
        return new NoSuchElementException("Вводимый список чисел пуст");
    }
}

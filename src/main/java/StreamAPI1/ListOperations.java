package StreamAPI1;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        Optional<Integer> maxNumber = numbers.stream()
                .max(Integer::compareTo);
        if (maxNumber.isPresent()) {
            return maxNumber.get();
        } else {
            return 0;
        }
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> texts, char symbol) {
        return texts.stream()
                .filter(text -> text.startsWith(String.valueOf(symbol)))
                .toList()
                .size();
    }

    public static List<String> filterStringsContainingSubstring(List<String> texts, String substring) {
        return texts.stream()
                .filter(text -> text.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> texts) {
        return texts.stream()
                .sorted((text1, text2) -> text1.length() - text2.length())
                .toList();
    }

    public static boolean allMatchCondition(
            List<Integer> numbers,
            Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(number -> filter.test(number));

    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(n -> n > number)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(string -> string.length())
                .toList();
    }
}

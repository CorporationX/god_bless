package school.faang.streamapi1;

import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static Integer sumOfEvenNumbers(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (a, b) -> a + b);
    }

    public static Integer findMax(List<Integer> integerList) {
        return integerList.stream()
                .max((a, b) -> a - b).orElse(0);
    }

    public static Double findAverage(List<Integer> integerList) {
        return integerList.stream()
                .mapToDouble(a -> a)
                .average()
                .orElse(0);
    }

    public static Integer countStringsStartingWith(List<String> stringList, char startingChar) {
        return Math.toIntExact(stringList.stream()
                .filter(string -> string.charAt(0) == startingChar)
                .count());
    }

    public static List<String> filterStringsContainingSubstring(List<String> stringList, String startingString) {
        return stringList.stream()
                .filter(string -> string.contains(startingString))
                .toList();
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream()
                .sorted((a, b) -> a.length() - b.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> integerList, Predicate<Integer> predicate) {
        return integerList.stream()
                .allMatch(predicate);
    }

    public static Integer findMinGreaterThan(List<Integer> integerList, Integer minInteger) {
        return integerList.stream()
                .filter(a -> a > minInteger)
                .min((a, b) -> a - b)
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        return stringList.stream()
                .map(string -> string.length())
                .toList();
    }
}

/*
9️⃣ Преобразовать список строк в список их длин.

    Метод должен принимать список строк и возвращать список целых чисел, представляющих длину каждой строки.

    Вход: List<String>, выход: List<Integer>.
 */
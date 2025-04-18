package school.faang.bjs2_70759;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
class Streams {
    public static void main(String[] args) {
        log.info(findSumOfEvenNumbers(List.of(1, 2, 3, 4, 12)).toString());
        log.info(findMaxNumber(List.of(1, 45, 100500, 65)).toString());
        log.info(findAvgNumber(List.of(25.6, 33.3, 36.6)).toString());
        log.info(countOfStringsOnLetter(List.of("qwe", "rty", "asd", "abc"), 'a').toString());
        log.info(findStringsWithSubstring(List.of("qwe super", "zxcvbn", "puper rty", "asdsuper"), "uper")
                .toString());
        log.info(sortStringsByLength(List.of("qwerty", "w", "adfqwetghj", "rty")).toString());
        log.info(String.valueOf(checkCondition(List.of(1, 2, 3, 4, 5), number -> number > 0)));
        log.info(findSmallestElementGreaterThan(List.of(23, 35, 98, 77, 100), 42).toString());
        log.info(getListOfSizes(List.of("qwe", "asdf", "q")).toString());
    }

    public static Integer findSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public static Integer findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0);
    }

    public static Double findAvgNumber(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average().orElse(0);
    }

    public static Long countOfStringsOnLetter(List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> findStringsWithSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static Integer findSmallestElementGreaterThan(List<Integer> numbers, Integer number) {
        return numbers.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> getListOfSizes(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}

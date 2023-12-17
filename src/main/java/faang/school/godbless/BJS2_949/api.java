package faang.school.godbless.BJS2_949;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;


public class api {
    private static List<Integer> numbers = List.of(3, 2, 4, 1, 6, 5);
    private static List<String> vegetables = List.of("*свекла", "свекла", "*лук");

//    static Optional<Integer> sumInList(List<Integer> numbers) {
//        Integer sum = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .reduce(0, (n, number) -> n + number);
//        return Optional.of(sum);
//    }

    static Optional<Integer> sumInList(List<Integer> numbers) {
        Integer sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        return Optional.of(sum);
    }

    static Optional<Integer> maxInt(List<Integer> numbers) {
        Optional<Integer> max = numbers.stream()
                .max(Comparator.naturalOrder());
        return max;
    }

    static OptionalDouble averageInt(List<Integer> numbers) {
        OptionalDouble average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        return average;
    }

    static Optional<Long> numberOfLines(List<String> strings, Character comparer) {
        Optional<Long> lines = Optional.of(strings.stream()
                .filter(s -> s.startsWith(Character.toString(comparer)))
                .count());
        return lines;
    }

    static Optional<List<String>> equalString(List<String> strings, String comparer) {
        Optional<List<String>> truOfEquals = Optional.of(strings.stream()
                .filter(s -> s.contains(comparer))
                .toList());
        return truOfEquals;
    }

    static Optional<int[]> linesOfList(List<String> strings) {
        Optional<int[]> lines = Optional.of(Arrays.stream(strings.stream()
                .sorted((l1, l2) -> l1.length() - l2.length())
                .mapToInt(s -> s.length())
                .toArray()).toArray());
        return lines;
    }

    static boolean allTrue(List<String> strings) {
        return strings.stream()
                .allMatch(s -> s.length() > 0);
    }

    static Optional<Integer> minNumber(List<Integer> numbers, Integer comparer) {
        Optional<Integer> min = numbers.stream()
                .filter(n -> n > comparer)
                .min(Comparator.naturalOrder());
        return min;
    }

    static Optional<List<Integer>> lengthOfLines(List<String> strings) {
        List<Integer> length = strings.stream()
                .map(String::length)
                .toList();
        return Optional.of(length);
    }


    public static void main(String[] args) {
        Optional<Integer> sum = sumInList(numbers);
        sum.ifPresent(sumInList -> System.out.println(sumInList));

        Optional<Integer> max = maxInt(numbers);
        max.ifPresent(maxInt -> System.out.println(maxInt));

        OptionalDouble average = averageInt(numbers);
        average.ifPresent(averageInt -> System.out.println(averageInt));

        char comparerChar = '*';
        Optional<Long> lines = numberOfLines(vegetables, comparerChar);
        lines.ifPresent(numberOfLines -> System.out.println(numberOfLines));

        String comparerString = "ек";
        Optional<List<String>> filter = equalString(vegetables, comparerString);
        filter.ifPresent(equalString -> System.out.println(equalString));

        Optional<int[]> numberLines = linesOfList(vegetables);
        numberLines.ifPresent(numberOfLines -> System.out.println(Arrays.toString(numberOfLines)));

        System.out.println(allTrue(vegetables));

        int comparerInt = 3;
        Optional<Integer> minInNumber = minNumber(numbers, comparerInt);
        minInNumber.ifPresent(minNumber -> System.out.println(minNumber));

        Optional<List<Integer>> length = lengthOfLines(vegetables);
        length.ifPresent(lengthOfLines -> System.out.println(lengthOfLines));
    }
}



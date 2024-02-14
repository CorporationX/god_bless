package faang.school.godbless.BJS2_953;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 1,  3, 4);
        System.out.println("The sum of even numbers: "+findSumOfEvenNumbers(nums));
        System.out.println("Max value: "+findMaxValue(nums));
        System.out.println("Average value: "+averageValue(nums));
        System.out.println("Checked condition: "+checkToCondition(nums, 3));

        List<String> strings = List.of("Hello", "average", "builder", "archer");
        System.out.println("Words with the first letter : "+countOfSomeString(strings, 'a'));
        System.out.println("Words with substring 'er': "+stringFilter(strings, "er"));
        System.out.println("Strings ordered by length: "+stringFilterByLength((strings)));
        System.out.println("List from length of words: "+stringToLength(strings));
    }
    public static int findSumOfEvenNumbers(List<Integer> listOfInt){
        return listOfInt.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Optional<Integer> findMaxValue(List<Integer> listOfInt){
        return listOfInt.stream()
                .max(Integer::compareTo);
    }

    public static double averageValue(List<Integer> listofInt){
        return listofInt.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }

    public static int countOfSomeString(List<String> listofStrings, char letter){
        long count = listofStrings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .count();
        return (int) count;
    }

    public static List<String> stringFilter(List<String> listOfStrings, String substring){
        return listOfStrings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> stringFilterByLength(List<String> listOfStrings){
        return listOfStrings.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public static List<Integer> checkToCondition(List<Integer> list, int verificationInt){
        return list.stream()
                .filter(n -> n<verificationInt)
                .collect(Collectors.toList());
    }

    public static Optional<Integer> findLowerBound (List<Integer> list, int verificationInt) {
        return list.stream()
                .filter(n -> n > verificationInt)
                .max(Comparator.naturalOrder());
    }

    public static List<Integer> stringToLength(List<String> listOfStrings) {
        List<Integer> result = listOfStrings.stream()
                .map(String::length)
                .collect(Collectors.toList());
        return result;
    }
}

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
        System.out.println("Checked condition: "+checkToCondition(nums));

        List<String> strings = List.of("Hello", "average", "builder", "archer");
        System.out.println("Words with the first letter a: "+countOfSomeString(strings));
        System.out.println("Words with substring 'er': "+stringFilter(strings));
        System.out.println("Strings ordered by length: "+stringFilterByLength((strings)));
        System.out.println("List from length of words: "+stringToLength(strings));
    }
    public static int findSumOfEvenNumbers(List<Integer> listOfInt){
        int sum = listOfInt.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        return sum;
    }

    public static Optional<Integer> findMaxValue(List<Integer> listOfInt){
        Optional<Integer> max = listOfInt.stream()
                .max(Integer::compareTo);
        return max;
    }

    public static OptionalDouble averageValue(List<Integer> listofInt){
        OptionalDouble averageValue = listofInt.stream()
                .mapToInt(Integer::intValue)
                .average();
        return averageValue;
    }

    public static int countOfSomeString(List<String> listofStrings){
        long count = listofStrings.stream()
                .filter(s -> s.charAt(0)=='a')
                .count();
        return (int) count;
    }

    public static List<String> stringFilter(List<String> listOfStrings){
        List<String> result = listOfStrings.stream()
                .filter(s -> s.contains("er"))
                .collect(Collectors.toList());
        return result;
    }

    public static List<String> stringFilterByLength(List<String> listOfStrings){
        List<String> result = listOfStrings.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return result;
    }

    public static List<Integer> checkToCondition(List<Integer> list){
        List<Integer> result = list.stream()
                .filter(n -> n<3)
                .collect(Collectors.toList());
        return result;
    }

    public static Optional<Integer> findLowerBound (List<Integer> list) {
        Optional<Integer> result = list.stream()
                .filter(n -> n > 5)
                .max(Comparator.naturalOrder());
        return result;
    }

    public static List<Integer> stringToLength(List<String> listOfStrings) {
        List<Integer> result = listOfStrings.stream()
                .map(String::length)
                .collect(Collectors.toList());
        return result;
    }
}

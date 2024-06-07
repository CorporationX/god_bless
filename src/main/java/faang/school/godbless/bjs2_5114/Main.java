package faang.school.godbless.bjs2_5114;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<String> strings = List.of("Java oop language",
                                        "C very old language",
                                        "Java is an island!");

        System.out.println("Sum even nums in the list: " + getSumEvenNumsFromList(numbers));
        System.out.println("Max number in the list of numbers: " + getMaxNumber(numbers));
        System.out.println("Average value in the list of numbers: " + getAverageFromListNumber(numbers));
        System.out.println("Count of strings in the list starts with J: " + getStringCountFromList(strings, "j"));

        System.out.println("Filter strings from List: ");
        filterStringsFromList(strings, "language").forEach(System.out::println);

        System.out.println("Sort string list by string length: ");
        sortListByStringLength(strings).forEach(System.out::println);

        System.out.println("Check that the value of numbers in the list is no more than 5: " + checkListElements(numbers, x -> x < 6));

        System.out.println("Find min element from list which more than 2: " + findMinNumberWhichNoMoreThanGivenNumber(numbers, 2));

        System.out.println("Convert string list to string length list: ");
        convertStringListToStringLengthList(strings).forEach(length -> System.out.print(length + " "));
    }

    public static int getSumEvenNumsFromList(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int getMaxNumber(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo)
                .orElseThrow();
    }

    public static int getAverageFromListNumber(List<Integer> nums) {
        return nums.stream()
                .reduce(Integer::sum)
                .map(sum -> sum/nums.size())
                .orElseThrow();
    }

    public static int getStringCountFromList(List<String> stringList, String symbol) {
        return stringList.stream()
                .map(String::toLowerCase)
                .filter(str -> str.startsWith(symbol))
                .toList().size();
    }

    public static List<String> filterStringsFromList(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortListByStringLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean checkListElements(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .takeWhile(predicate)
                .toList().size() == list.size();
    }

    public static int findMinNumberWhichNoMoreThanGivenNumber(List<Integer> numbers, Integer givenNum) {
        return numbers.stream()
                .filter(num -> num > givenNum)
                .min(Integer::compareTo)
                .orElseThrow();
    }

    public static List<Integer> convertStringListToStringLengthList(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}

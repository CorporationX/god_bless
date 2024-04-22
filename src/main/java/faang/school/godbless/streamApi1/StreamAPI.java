package faang.school.godbless.streamApi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<String> listOfStrings = List.of("close", "open", "current", "temporary closed");
        char character = 'c';
        String word = "close";
        int number = 5;
        System.out.println("Sum:" + sum(numbers));
        System.out.println("Max:" + max(numbers));
        System.out.println("Average:" + average(numbers));
        System.out.println("Number of strings starts with " + character + " is "
                + countStringsStartsWithCharacter(character, listOfStrings));
        System.out.println("All strings that contain word " + word + " is "
                + filterStringsContainsWord(listOfStrings, word));
        System.out.println("Sorted by length list of stings: " + sortByLength(listOfStrings));
        System.out.println("Does all words is list of string contains word" + word + "? "
                + checkListElements(listOfStrings, (string) -> string.equals(word)));
        System.out.println("The minimal number that bigger than " + number + " in the list is "
                + findMinElementWhichMoreThanNumber(number, numbers));
        System.out.println("The list of lengths of string in list:"
                + listOfStringToListOfLengths(listOfStrings));

    }

    public static int sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("No numbers in list"));
    }

    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.averagingInt(num -> num));
    }

    public static long countStringsStartsWithCharacter(char character, List<String> strings) {
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .filter(string -> string.charAt(0) == character)
                .count();
    }

    public static List<String> filterStringsContainsWord(List<String> list, String word) {
        return list.stream()
                .filter(string ->
                        string.contains(word)).toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean checkListElements(List<T> elements, Predicate<T> filter) {
        return elements.stream()
                .allMatch(filter);
    }

    public static int findMinElementWhichMoreThanNumber(int number, List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("No number bigger than " + number + " was found"));
    }

    public static List<Integer> listOfStringToListOfLengths(List<String> stringList) {
        return stringList.stream()
                .mapToInt(String::length).boxed().toList();
    }


}

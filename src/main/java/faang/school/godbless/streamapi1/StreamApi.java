package faang.school.godbless.streamapi1;

import java.util.Comparator;
import java.util.List;

public class StreamApi {
    public static int sumOfEvenNumbers(List<Integer> listNumbers) {
        return listNumbers.stream().filter(num -> (num & 1) == 0).reduce((x, y) -> x + y).get();
    }

    public static int maxNumber(List<Integer> listNumbers) {
        return listNumbers.stream().max(Comparator.naturalOrder()).get();
    }

    public static int avgNumber(List<Integer> listNumbers) {
        return listNumbers.stream().reduce((x, y) -> (x + y)).get() / listNumbers.size();
    }

    public static int findingNumberOfLines(List<String> strings, char symbol) {
        return (int) strings.stream().filter(string -> string.toLowerCase().charAt(0) == symbol).count();
    }

    public static List<String> filteringListOfStrings(List<String> stringList, String substring) {
        return stringList.stream().filter(string -> string.contains(substring)).toList();
    }

    public static List<String> filteringStringsByLength(List<String> stringList) {
        return stringList.stream().sorted(Comparator.comparing(string -> string.length())).toList();
    }

    public static boolean checkingListForACondition(List<String> stringList, String condition) {
        return stringList.stream().allMatch(string -> string.contains(condition));
    }

    public static int findItemInList(List<Integer> integerList, int numberCondition) {
        return integerList.stream().sorted(Comparator.reverseOrder()).min(Comparator.comparing(num -> num > numberCondition + 1)).get();
    }

    public static List<Integer> convertStringsToLengths(List<String> stringList) {
        return stringList.stream().map(string -> string.length()).toList();
    }

}

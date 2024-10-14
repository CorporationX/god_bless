package school.faang.streamapifirst;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        int sumList = list.stream().reduce(0, (firstNumber, secondNumber) -> firstNumber + secondNumber); //Integer::sum
        return sumList;
    }

    public static int findMaximum(List<Integer> list) {
        int maxNumber = list.stream().max((firstNumber, secondNumber) -> firstNumber - secondNumber).get();
        return maxNumber;
    }

    public static double findAverage(List<Integer> list) {
        double averageNumber = list.stream().reduce(0, (firstNumber, secondNumber)
                -> (firstNumber + secondNumber)).doubleValue() / list.size();
        return averageNumber;
    }

    // 4
    public static int countStringsStartWitch(List<String> list, char symbol) {
        long countStrings = list.stream().filter(element -> element.startsWith(Character.toString(symbol))).count();
        return (int) countStrings;
    }

    // 5
    public static List<String> filterStringsContainingSubstring(List<String> list, String substring) {
        List<String> stringList = list.stream().filter(element -> element.contains(substring)).collect(Collectors.toList());
        return stringList;
    }

    // 6
    public static List<String> sortByLength(List<String> list) {
       List<String> stringList = list.stream().sorted((element1, element2) -> element1.length() - element2.length()).collect(Collectors.toList());
        return stringList;
    }

    // 7
    static public boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    // 8
    static public int findMinGreaterThan(List<Integer> list, int number) {
        int resultNumber = list.stream().filter(firstNum -> number < firstNum).min((minNumber, minNumber2) -> minNumber - minNumber2).get();
        return resultNumber;
    }

    // 9
    public static List<Integer> convertToLengths(List<String> list) {
        List<Integer> integerList = list.stream().map(element -> element.length()).collect(Collectors.toList());
        return integerList;
    }
}

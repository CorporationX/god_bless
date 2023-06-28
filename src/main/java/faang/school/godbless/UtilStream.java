package faang.school.godbless;


import java.util.List;
import java.util.function.Predicate;

public class UtilStream {

    public static int findSumsEvenNumbers(List<Integer> numbers) {
       return numbers.stream().filter(number -> number % 2 ==0).reduce(0, Integer::sum);
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElse(-1);
    }

    public static double findAverageNumber(List<Integer> numbers) {
       return numbers.stream().mapToInt(number -> number.intValue()).average().getAsDouble();
    }

    public static long findNumberLinesStartingWithSpecChar(List<String> stringList, char ch) {
        return stringList.stream().filter(str -> str.toLowerCase().startsWith(String.valueOf(ch))).count();
    }

    public static List<String> filterListStringContainSubstring(List<String> stringList, String substring) {
        return stringList.stream().filter(str -> str.contains(substring)).toList();
    }

    public static List<String> sortListStrByLength(List<String> stringList) {
        return stringList.stream().sorted(String::compareTo).toList();
    }

    public static <T> boolean checkAllElemSatisfyCondition(List<T> list, Predicate<T> predicate) {
        return list.stream().anyMatch(predicate);
    }

    public static int findMinElemMoreThen(List<Integer> integerList, int moreThen) {
        return integerList.stream().filter(num -> num > moreThen).min(Integer::compareTo).orElse(-1);
    }

    public static List<Integer> convertListStrToLength(List<String> stringList) {
        return stringList.stream().map(String::length).toList();
    }
}

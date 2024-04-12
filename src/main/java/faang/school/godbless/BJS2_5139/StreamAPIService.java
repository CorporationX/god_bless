package faang.school.godbless.BJS2_5139;

import java.util.Comparator;
import java.util.List;

public class StreamAPIService {
    public static int findSumOfEvenNumbers(List<Integer> numbers){
        return numbers.stream().filter(number -> number % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMaxNumber(List<Integer> numbers){
        return numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public static int findAverageValueOfNumbers(List<Integer> numbers){
        return (int) numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static int countStringStartingWithChar(char element, List<String> strings){
        return (int) strings.stream().filter(str -> str.charAt(0) == element).count();
    }

    public static List<String> filterStringThatContainSubstring(String subStr, List<String> strings){
        return strings.stream().filter(str -> str.contains(subStr)).toList();
    }

    public static List<String> sortStringByLength(List<String> strings){
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> checkStringForMaxLength(int maxLength, List<String> strings){
        return strings.stream().filter(str -> str.length() <= maxLength).toList();
    }

    public static int findMinElementThatMoreNumber(int inputNumber, List<Integer> numbers){
        return numbers.stream().filter(number -> number > inputNumber).min(Comparator.naturalOrder()).orElse(0);
    }

    public static List<Integer> convertStringToStringLength(List<String> strings){
        return strings.stream().map(String::length).toList();
    }
}

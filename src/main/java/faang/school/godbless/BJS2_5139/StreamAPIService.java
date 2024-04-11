package faang.school.godbless.BJS2_5139;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamAPIService {
    private static final List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    private static final List<String> strings = new ArrayList<>(List.of("site", "stop", "win", "away", "sit"));

    public static int findSumOfEvenNumbers(){
        return numbers.stream().filter(number -> number % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMaxNumber(){
        return numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public static int findAverageValueOfNumbers(){
        return (int) numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static int countStringStartingWithChar(char element){
        return (int) strings.stream().filter(str -> str.charAt(0) == element).count();
    }

    public static List<String> filterStringThatContainSubstring(String subStr){
        return strings.stream().filter(str -> str.contains(subStr)).toList();
    }

    public static List<String> sortStringByLength(){
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> checkStringForMaxLength(int maxLength){
        return strings.stream().filter(str -> str.length() <= maxLength).toList();
    }

    public static int findMinElementThatMoreNumber(int inputNumber){
        return numbers.stream().filter(numb -> numb > inputNumber).min(Comparator.naturalOrder()).orElse(0);
    }

    public static List<Integer> convertStringToStringLength(){
        return strings.stream().map(String::length).toList();
    }
}

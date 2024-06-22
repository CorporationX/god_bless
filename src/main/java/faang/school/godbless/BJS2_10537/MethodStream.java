package faang.school.godbless.BJS2_10537;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class MethodStream {

    public static Integer sumEvenInt(List<Integer> list){
        int sumEven = list.stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(0,(a , b) -> a + b);
        System.out.println("Sum all even numbers: " + sumEven);
        return sumEven;
    }

    public static Optional<Integer> maxValueInList(List<Integer> list){
        Optional<Integer> maxValue = list.stream()
                .max((a , b) -> a - b);
        maxValue.ifPresent(integer -> System.out.println("Max Value in numers List: " + maxValue.get()));
        return maxValue;
    }

    public static OptionalDouble averageValue(List<Integer> list){
        OptionalDouble averageNumber = list.stream()
                .mapToInt(Integer::intValue)
                .average();
        averageNumber.ifPresent(num -> System.out.println("Average value in numbers List: " + averageNumber.getAsDouble()));
    return averageNumber;
    }

    public static Optional<Integer> minValueInList(int needMinValue , List<Integer> list){
        Optional<Integer> num = list.stream()
                .filter(n -> n > needMinValue)
                .min((a , b) -> a - b);
        num.ifPresent(value -> System.out.println("Need Min Value in numbers List: " + num.get()));
        return num;
    }

    public static Long quantityNeedLine(char needChar , List<String> list){
        long num = list.stream()
                .filter(str -> str.charAt(0) == needChar)
                .count();
        System.out.println("Quantity need Line in the List: " + num);
        return num;
    }

    public static List<String> needLineList(String needLine , List<String> list){
        List<String> newList = list.stream()
                .filter(str -> str == needLine)
                .toList();
        System.out.println("foun need line in the list: " + newList);
        return newList;
    }

    public static List<String> sortLengthList(List<String> list){
        List<String> newList = list.stream()
                .sorted((firstStr , secondStr) -> firstStr.length() - secondStr.length())
                .toList();
        System.out.println("Sorted List by length: " + newList);
        return newList;
    }

    public static Map<Boolean , List<String>> checkList(int lengthLine , List<String> list){
        Map<Boolean , List<String>> newList = list.stream()
                .collect(Collectors.partitioningBy(str -> str.length() == lengthLine));
        System.out.println("Line satisfy your condition: " + newList.get(true));
        System.out.println("Line don't saticsfy your condition: " + newList.get(false));
        return newList;
    }

    public static List<Integer> listLength(List<String> list){
        List<Integer> newList = list.stream()
                .map(str -> str.length())
                .toList();
        System.out.println("Your new List length: " + newList);
        return newList;
    }
}

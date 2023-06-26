package faang.school.godbless.stream_api1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Example {
    public static int getSumNum(List<Integer> list){
        return list.stream().reduce(0, Integer::sum);
    }

    public static int getMax(List<Integer> list){
        return list.stream().max(Integer::compareTo).orElse(0);
    }

    public static double getAverage(List<Integer> list){
        OptionalDouble optional = list.stream().mapToInt(Integer::intValue).average();
        return optional.orElse(0.0);
    }

    public static double getStringNum(List<String> list, Character ch){
        return list.stream().filter(s -> s.toLowerCase().charAt(0) == ch).count();
    }

    public static List<String> filterBySubstring(List<String> list, String subString){
        return list.stream().filter(s -> s.toLowerCase().contains(subString)).toList();
    }

    public static List<String> sortByStringLenght(List<String> list){
        return list.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    }

    public static boolean isLengthEven(List<String> list){
        return list.stream().allMatch(s -> s.length() % 2 == 0);
    }

    public static int getNum(List<Integer> list, int i){
        Optional<Integer>optional = list.stream().filter(n -> n > i).min(Integer::compareTo);
        return optional.orElse(0);
    }

    public static List<Integer> getStringLength(List<String> list){
        return list.stream().map(s -> s.length()).collect(Collectors.toList());
    }
}

package school.faang.StreamAPI2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> UniquePairs(List<Integer> numbers, int targetNum){
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>(numbers);
        set.addAll(numbers);
        pairs = numbers.stream().filter(n -> set.contains(targetNum - n)).map(n -> Arrays.asList(n, targetNum - n))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public static List<String> capitals(Map<String, String> map){
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getValue).toList();
    }

    public static List<String> filterSort(List<String> list, char chr){
        return list.stream().filter(str -> str.startsWith(String.valueOf(chr)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> toBinary(List<Integer> numbers){
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> containSort(List<String> list, String letters){
        String alhabet = "[" + letters + "]+";
        return list.stream().filter(l -> l.matches(alhabet))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }
}


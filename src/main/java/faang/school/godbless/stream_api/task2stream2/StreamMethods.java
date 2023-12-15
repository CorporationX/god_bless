package faang.school.godbless.stream_api.task2stream2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class StreamMethods {
    public static List<List<Integer>> findPairsWithSum(List<Integer> list, int sum) {
        return list.stream().
                flatMap(i -> list.stream().
                        filter(j -> i + j == sum).
                        map(j -> List.of(i, j))).
                distinct().
                toList();
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream().
                sorted(Map.Entry.comparingByKey()).
                map(Map.Entry::getValue).
                toList();
    }

    public static List<String> sortStrStartChar(List<String> strings, char symbol) {
        String symStr = String.valueOf(symbol);
        return strings.stream().
                filter(str -> str.startsWith(symStr)).
                sorted().
                toList();
    }

    public static List<List<String>> findCommonFriends(Map<String, List<String>> mapFriend) {
        return mapFriend.entrySet().stream().
                flatMap(humi -> mapFriend.entrySet().stream().
                        filter(humj -> !humi.getValue().contains(humj.getKey()) &&
                                !Collections.disjoint(humi.getValue(), (humj.getValue())) &&
                                !humi.getKey().equals(humj.getKey()) &&
                                humi.getKey().compareTo(humj.getKey()) < 0).
                        map(humj -> List.of(humi.getKey(), humj.getKey()))).
                distinct().
                toList();
    }

    public static Map<String, Double> avrTypeEmployee(List<Employee> employees) {
        return employees.stream().
                collect(Collectors.groupingBy(Employee::getType)).entrySet().stream().
                map(en -> Map.entry(en.getKey(), en.getValue().stream().
                        mapToInt((Employee::getSalary)).average().orElseThrow())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static List<String> alfStr(List<String> strings, String alf) {
        return strings.stream().
                filter(s -> s.toLowerCase().chars().allMatch(c -> alf.contains(String.valueOf((char) c)))).
                sorted().
                toList();
    }

    public static List<String> bin(List<Integer> numbers) {
        return numbers.stream().
                map(Integer::toBinaryString).toList();
    }

    public static List<Integer> palindromes(int start, int end) {
        return IntStream.range(start, end).
                filter(x -> String.valueOf(x).contentEquals(new StringBuilder(String.valueOf(x)).reverse())).
                boxed().
                toList();
    }
}


package faang.school.godbless.stream_api.task2stream2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class StreamMethods {
    public static Set<Set<Integer>> findPairsWithSum(List<Integer> list, int sum) {
        return list.stream()
                .filter(i -> list.contains(sum - i))
                .map(i -> Set.of(i, sum - i))
                .collect(Collectors.toSet());
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
                sorted(Comparator.comparingInt(String::length)).
                toList();
    }

    public static Set<Set<String>> findCommonFriends(Map<String, List<String>> mapFriend) {
        return mapFriend.entrySet().stream()
                .flatMap(person1 -> mapFriend.entrySet().stream()
                        .filter(person2 -> !person1.getKey().equals(person2.getKey())) // Исключаем одинаковых людей
                        .filter(person2 -> !person1.getValue().contains(person2.getKey())) // Они не друзья
                        .filter(person2 -> !Collections.disjoint(person1.getValue(), person2.getValue())) // Проверяем наличие общих друзей
                        .map(person2 -> Set.of(person1.getKey(), person2.getKey())))
                .collect(Collectors.toSet());
    }


    public static Map<String, Double> avrTypeEmployee(List<Employee> employees) {
        return employees.stream().
                collect(Collectors.groupingBy(Employee::getType)).entrySet().stream().
                map(en -> Map.entry(en.getKey(), en.getValue().stream().
                        mapToInt((Employee::getSalary)).average().orElseThrow())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static List<String> alfStr(List<String> strings, String alf) {
        return strings.stream()
                .filter(str -> str.toLowerCase().matches(alf))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
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


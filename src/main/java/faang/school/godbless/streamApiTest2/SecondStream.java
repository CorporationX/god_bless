package faang.school.godbless.streamApiTest2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SecondStream {
    private SecondStream() {
    }

    public static List<List<Integer>> doThePairsThatSummaryA(List<Integer> list, int a) {
        return list.stream()
                .flatMap(x -> list.stream().skip(list.indexOf(x) + 1)
                        .flatMap(y -> Stream.of(Arrays.asList(x, y))))
                .distinct()
                .filter(x -> x.get(0) + x.get(1) == a)
                .toList();
    }

    public static void sortTheCountries(Map<String, String> countries) {
        countries.keySet()
                .stream()
                .sorted()
                .forEach(k -> System.out.println(countries.get(k)));
    }

    public static List<String> sortTheStrings(List<String> strings, char c) {
        return strings.stream()
                .filter(string -> string.charAt(0) == c)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<Map.Entry<String, String>> searchFamiliar(Map<String, List<String>> friends) {
        return friends.keySet()
                .stream()
                .flatMap(people -> friends.keySet().stream().skip(1L).flatMap(
                        friend -> Stream.of(Map.entry(people, friend))))//делается поток из пар человек - человек
                .filter(pair -> friends.get(pair.getKey()).stream()
                        .anyMatch(friend -> friends.get(pair.getValue()).contains(friend)//есть хотя бы один общий друг
                                && !pair.getValue().equals(friend)//сами они не друзья
                                && !pair.getValue().equals(pair.getKey())))//это не один человек
                .map(p -> new HashSet<>(Set.of(p.getValue(), p.getKey())))//неиммутабельный объект, чтобы не было пар вида 1,2 - 2,1
                .distinct()
                .map(s -> Map.entry((String) s.toArray()[0], (String) s.toArray()[1]))
                .toList();
    }

    public static Map<String, Double> averageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));
    }

    public static List<String> filterAndSortStrings(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.codePoints()
                        .mapToObj(x -> (char) x)
                        .allMatch(c -> alphabet.contains(c.toString())))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static int[] findThePalindromes(Integer start, Integer end) {
        return IntStream.range(start, end)
                .filter(i -> {
                    String s = Integer.toString(i);
                    return s.contentEquals(new StringBuilder(s).reverse());
                }).toArray();
    }
}

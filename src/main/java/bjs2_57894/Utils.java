package bjs2_57894;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utils {
    public static List<Pair> getFriendOfFriends(Map<String, List<String>> data) {
        return data.entrySet()
                .stream()
                .flatMap(kvp -> {
                    String name = kvp.getKey();
                    List<String> friends = kvp.getValue();

                    // Выбираем друзей друга, которые не равны самому себе
                    return friends.stream()
                            .map(data::get)    // Получаем список друзей друга
                            .flatMap(List::stream)
                            .filter(friend -> !friend.equals(name)) // Пропускаем себя
                            .map(friend -> new Pair(name, friend));
                })
                .distinct()    // Удаляем повторяющиеся пары
                .sorted(Comparator.comparing(Pair::first))
                .toList();
    }

    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> data) {
        return data.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    public static List<Integer> getPalindroms(int from, int to) {
        return IntStream.range(from, to + 1)
                .boxed()
                .map(n -> new Tupple<>(
                        n,
                        n.toString().chars().boxed().collect(Collectors.toList())))
                .filter(info -> checkPalindrom(info.item2()))
                .map(Tupple::item1)
                .toList();
    }

    public static List<String> getSubstringsPalindroms(String string) {
        int len = string.length();

        return IntStream.range(0, len)
                .mapToObj(left -> IntStream.range(left, len)
                        .mapToObj(right -> string.substring(left, right + 1)))
                .flatMap(strings -> strings.map(
                        s -> new Tupple<>(
                                s,
                                s.chars().boxed().collect(Collectors.toList()))))
                .filter(info -> checkPalindrom(info.item2()))
                .map(Tupple::item1)
                .distinct()
                .toList();
    }

    public static List<Integer> getPerfectDigits(int from, int to) {
        return Stream.iterate(from, n -> n + 1)
                .limit(to - from)
                .filter(number -> {
                    int dividersSum = Stream.iterate(1, n -> n + 1)
                            .limit(number / 2)
                            .filter(divider -> number % divider == 0)
                            .mapToInt(x -> x)
                            .sum();

                    return dividersSum == number;
                })
                .toList();
    }

    private static <T> boolean checkPalindrom(List<T> list) {
        return IntStream.range(0, list.size()).allMatch(i -> list.get(i).equals(list.get(list.size() - i - 1)));
    }
}

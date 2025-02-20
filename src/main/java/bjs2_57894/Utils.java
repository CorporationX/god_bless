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
                .filter(info -> {
                    List<Integer> digits = info.item2();
                    return IntStream.range(0, digits.size())
                            .allMatch(i -> digits.get(i) == digits.get(digits.size() - i - 1));
                })
                .map(Tupple::item1)
                .toList();
    }

    public static List<String> getSubstringsPalindroms(String string) {
        List<String> result = new ArrayList<>();

        int len = string.length();
        for (int i = 0; i < len; i++) {
            result.add(string.substring(i, i + 1));

            for (int j = i + 2; j <= len; j++) {
                String substring = string.substring(i, j);
                List<Character> charList = substring.chars()
                        .mapToObj(c -> (char) c)
                        .toList();

                if (checkPalindrom(charList)) {
                    result.add(substring);
                }
            }
        }

        return result.stream().distinct().toList();
    }

    public static List<Integer> getPerfectDigits(int from, int to) {
        return Stream.iterate(from, n -> n + 1)
                .limit(to - from)
                .filter(number -> {
                    List<Integer> dividers = new ArrayList<>();
                    for (int divider = 1; divider <= number / 2; divider++) {
                        if (number % divider == 0) {
                            dividers.add(divider);
                        }
                    }

                    return dividers.stream().mapToInt(x -> x).sum() == number;
                })
                .toList();
    }

    private static <T> boolean checkPalindrom(List<T> list) {
        int leftIndex = 0;
        int rightIndex = list.size() - 1;
        while (leftIndex < rightIndex) {
            if (!list.get(leftIndex).equals(list.get(rightIndex))) {
                break;
            }

            leftIndex++;
            rightIndex--;
        }

        return leftIndex == rightIndex;
    }
}

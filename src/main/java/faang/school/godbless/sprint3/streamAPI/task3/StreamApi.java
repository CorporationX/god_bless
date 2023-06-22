package faang.school.godbless.sprint3.streamAPI.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi {

    public static List<Pair> findUniquePairsNumbers(List<Integer> numbers, Integer number) {
        return numbers.stream()
                .sorted(Comparator.comparingInt(x -> x))
                .limit(numbers.size() / 2)
                .map(x -> {
                    if (numbers.contains(number - x)) {
                        return new Pair<>(x, number - x);
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterStrings(List<String> strings, char character) {
        return strings.stream()
                .filter(s -> s.startsWith(Character.toString(character)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //not done
    public static Map<String, String> getPeopleHavingMutualFriends(Map<String, List<String>> friends) {
//        return friends.entrySet().stream()
//                .map(x -> {
//                    friends.entrySet().stream()
//                            .map(v -> {
//                                if (x.getValue().stream().anyMatch(d -> d.))
//                            })
//                })
        return null;
    }

    public static Map<String, Double> getAvgSalaryDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getAverage()));
    }

    public static List<String> getFilteredStringsContainsCharacterAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(x -> x.toLowerCase().matches("[" + alphabet + "]*"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> changeNumberToBinaryString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> findNumbersPalindromeToDiapason(int startInclusive, int endInclusive) {
        return IntStream.range(startInclusive, endInclusive)
                .boxed()
                .map(String::valueOf)
                .map(StringBuilder::new)
                .filter(x -> {
                    String s = new String(x);
                    x.reverse();
                    return s.contentEquals(x);
                })
                .map(x -> Integer.valueOf(x.toString()))
                .collect(Collectors.toList());

    }

    public static List<String> findStringsPalindromeToDiapason(String string) {
        return Arrays.stream(string.split(" "))
                .map(StringBuilder::new)
                .filter(x -> {
                    String s = new String(x);
                    x.reverse();
                    return s.contentEquals(x);
                })
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPerfectNumbers(int startInclusive, int endInclusive) {
        return IntStream.range(startInclusive, endInclusive)
                .boxed()
                .filter(x -> {
                    int sum = 0;
                    for (int i = 1; i < x; i++) {
                        if (x % i == 0) {
                            sum += i;
                        }
                    }
                    return sum == x;
                })
                .collect(Collectors.toList());
    }
}

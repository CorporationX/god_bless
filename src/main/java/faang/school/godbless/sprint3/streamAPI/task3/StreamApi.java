package faang.school.godbless.sprint3.streamAPI.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi {

    //работает только с уникальными числами
    public static List<Pair> findUniquePairsNumbers(List<Integer> numbers, Integer number) {
        OptionalInt min = numbers.stream()
                .mapToInt(Math::toIntExact)
                .min();
        int filterNumber;
        if (min.getAsInt() < 0) {
            filterNumber = (number - min.getAsInt()) / 2;
        } else {
            filterNumber = number / 2;
        }
        return numbers.stream()
                .filter(x -> x < filterNumber)
                .map(x -> {
                    if (numbers.contains(number - x) && x != (number / 2) + 1) {
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
    public static Map<String, String> getPeopleHavingMutualFriends(Map<String, List<String>> map) {
        Map<String, String> result = new HashMap<>();

        map.forEach((user, friends) -> {
            map.forEach((another, anotherFriends) -> {
                if (!user.equals(another) && !friends.contains(another)) {
                    friends.stream()
                            .filter(anotherFriends::contains)
                            .findFirst()
                            .ifPresent(friend -> {
                                        if (!result.containsKey(another) || !result.get(another).equals(user)) {
                                            result.put(user, another);
                                        }
                                    }
                            );
                }
            });
        });
        return result;
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

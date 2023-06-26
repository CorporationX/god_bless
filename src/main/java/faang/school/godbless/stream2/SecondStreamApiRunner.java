package faang.school.godbless.stream2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecondStreamApiRunner {

    public static List<String> searchPairOfDigits(List<Integer> numbers, int value) {
        return numbers.stream()
                .flatMap(num1 -> numbers.stream()
                        .filter(num2 -> num1 != num2 && num1 + num2 == value)
                        .map(num2 -> {
                            int smallerNum = Math.min(num1, num2);
                            int largerNum = Math.max(num1, num2);
                            return smallerNum + " + " + largerNum;
                        }))
                .distinct()
                .toList();
    }

    public static List<String> getCountryCapitals(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> searchLinesWithChar(List<String> strings, char filterChar) {
        return strings.stream()
                .filter(line -> line.startsWith(String.valueOf(filterChar)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static Map<String, String> searchMutualFriends(Map<String, List<String>> friendsMap) {
        Map<String, String> result = new HashMap<>();

        friendsMap.forEach((human, hisFriends) -> hisFriends
                .forEach(friend -> friendsMap.forEach((key, value) -> {
                    if (!key.equals(human) && value.contains(friend)
                            && !hisFriends.contains(key) && !value.contains(human)) {
                        if (result.containsKey(key)) {
                            if (!result.get(key).contains(human)) {
                                result.put(human, key);
                            }
                        } else {
                            result.put(human, key);
                        }
                    }
                })));
        return result;
    }

    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> stringsFiltering(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(line -> line.replaceAll(" ", "").toLowerCase().matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> intToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> getPalindromes(int start, int end) {
        return IntStream.range(start, end + 1)
                .filter(num -> {
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
                    String str = stringBuilder.toString();
                    String reversed = stringBuilder.reverse().toString();
                    return str.equals(reversed);
                })
                .boxed()
                .toList();
    }
}

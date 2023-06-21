package faang.school.godbless.sprint3.streamAPI.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi {

    //not done
    public static List<Integer> findUniquePairsNumbers(List<Integer> numbers, Integer number) {
        return numbers.stream()
                .map(x -> number - x)
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

    public static void main(String[] args) {
        List<String> expected = List.of("11", "22", "33", "44", "55");

        List<StringBuilder> collect = IntStream.range(10, 56)
                .boxed()
                .map(x -> new StringBuilder(x)).toList();
        StringBuilder stringBuilder = new StringBuilder("3");
        StringBuilder tringBuilder = new StringBuilder(5);

        collect.forEach(System.out::println);

    }
}

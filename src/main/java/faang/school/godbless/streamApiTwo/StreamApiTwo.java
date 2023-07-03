package faang.school.godbless.streamApiTwo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiTwo {

    public static Set<List<Integer>> getUniqueCoupleWhereSumEqualsGiven(List<Integer> numbers, int sum) {
        return numbers.stream()
                .flatMap(numberOne -> numbers.stream()
                        .filter(numberTwo -> numberOne <= numberTwo)
                        .filter(numberTwo -> numberOne + numberTwo == sum)
                        .map(numberTwo -> {
                            List<Integer> couple = new ArrayList<>();
                            couple.add(numberOne);
                            couple.add(numberTwo);
                            return couple;
                        }))
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitals(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStringsByCharAndOrder(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Map<String, String> findMutualFriend(Map<String, List<String>> friends) {
        Map<String, String> potentialAcquaintances = new HashMap<>();
        friends.forEach((s1, listS1) -> {
            friends.forEach((s2, listS2) -> {
                if (!(s1.equals(s2)) && !(listS1.contains(s2))) {
                    listS1.stream()
                            .filter(listS2::contains)
                            .findFirst()
                            .ifPresent(s -> {
                                if (!(potentialAcquaintances.containsKey(s2)) || !(potentialAcquaintances.get(s2).equals(s1))) {
                                    potentialAcquaintances.put(s1, s2);
                                }
                            });
                }
            });
        });
        return potentialAcquaintances;
    }

    public static Map<String, Double> getAverageSalaryForEveryDepartment(List<Employee> employees) {
        Map<String, Double> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
        return result;
    }

    public static List<String> filterStringByAlphabet(String string, List<String> stringList) {
        return stringList.stream()
                .filter(s -> s.matches("[a-zA-Z]*"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> {
                    String string = Integer.toString(number);
                    return string.contentEquals(new StringBuilder(string)
                            .reverse());
                })
                .boxed()
                .toList();
    }
}

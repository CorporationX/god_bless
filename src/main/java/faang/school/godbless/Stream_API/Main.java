package faang.school.godbless.Stream_API;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void findPairs(int[] numbers, int keyNumber) {
        IntStream intStream = Arrays.stream(numbers);
        intStream.boxed()
                .flatMap(i -> intStream.boxed()
                        .filter(j -> i != j && i + j == keyNumber)
                        .map(j -> new int[]{i, j}))
                .distinct()
                .forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    public static void sortedMapOfCountries(Map<String, String> mapOfCountries) {
        mapOfCountries.entrySet().stream().sorted().forEach(System.out::println);
    }

    public static void sortByChar(List<String> strings, char key) {
        Stream<String> stringStream = strings.stream();
        stringStream.sorted(Comparator.comparingInt(String::length))
                .filter(s -> s.startsWith(String.valueOf(key)));
    }

    public static void notFriendsButWithSameFriends(Map<String, List<String>> mapOfFriends) {
        mapOfFriends.entrySet().stream().filter(entry1 -> mapOfFriends.entrySet().stream()
                        .anyMatch(entry2 -> !entry1.getKey().equals(entry2.getKey()) &&
                                entry1.getValue().containsAll(entry2.getValue()) &&
                                entry2.getValue().containsAll(entry1.getValue())))
                .forEach(entry -> System.out.println("Not friends but with same friends: " + entry.getKey()));
    }

    public static Map<String, Double> getAverageDepartmentSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static void alphabetSorting(String[] strings, String alphabet) {
        Arrays.stream(strings).filter(s -> s.contains(String.valueOf(alphabet)))
                .sorted((a, b) -> a.length() - b.length());
    }

    public static List<String> toBinaryStrings(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static void findPalindrooms(int leftBorder, int rightBorder) {
        IntStream.range(leftBorder, rightBorder).boxed()
                .filter(integer -> integer.toString().equals(new StringBuilder(integer.toString()).reverse().toString()))
                .forEach(System.out::println);
    }
}

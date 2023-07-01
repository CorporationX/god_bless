package faang.school.godbless.stream_api2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example {
    public static List<List<Integer>> getUniquePairs(List<Integer> nums, int num){
        return nums.stream()
                .filter(n -> n < num)
                .flatMap(n -> nums.stream()
                        .filter(m -> m < num && m != n && m + n == num && nums.indexOf(m) > nums.indexOf(n))
                        .map(m -> Arrays.asList(n, m))
                        .distinct())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> getCapitalsOrdered(Map<String, String> map){
        return map.entrySet().stream()
                .map( x -> x.getValue())
                .sorted()
                .peek(System.out::println)
                .toList();
    }

    public static List<String> sortStringsBySize(List<String> list, Character ch){
        return list.stream()
                .filter(x -> x.toLowerCase().startsWith(ch.toString()))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getAverageSalary(List<Employee> list){
        return list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> getStringsContainingAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(x -> x.toLowerCase().matches("[" + alphabet + "]*"))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    public static List<Integer> getPalindroms(int start, int end) {
        return IntStream.range(start, end)
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

    public static List<Integer> getPerfectNums(int start, int end) {
        return IntStream.range(start, end)
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

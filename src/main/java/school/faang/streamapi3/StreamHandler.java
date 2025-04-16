package school.faang.streamapi3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamHandler {
    public static List<List<String>> getWithMutualFriends(Map<String, List<String>> people) {
        return people.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .filter(entry -> people.entrySet().stream()
                        .anyMatch(pairEntry -> !pairEntry.getKey().equals(entry.getKey())
                                && pairEntry.getValue().equals(entry.getValue())))
                .map(entry -> {
                    Map.Entry<String, List<String>> pairEntry = people.entrySet().stream()
                            .filter(enr -> !enr.getKey().equals(entry.getKey())
                                    && enr.getValue().equals(entry.getValue())).findFirst().get();
                    return Arrays.asList(entry.getKey(), pairEntry.getKey());
                })
                .peek(Collections::sort)
                .distinct()
                .toList();
    }

    public static Map<String, Double> getDeptAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<Integer> getPalindromInRage(Integer firstNum, Integer lastNum) {
        return IntStream.range(firstNum, lastNum + 1)
                .boxed()
                .map(String::valueOf)
                .filter(num -> num.contentEquals(new StringBuilder(num).reverse()))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> getPalindromsForString(String inputString) {
        String[] inputArray = inputString.split("");
        return IntStream.range(0, inputArray.length)
                .boxed()
                .flatMap(i -> {
                    String val = inputArray[i];
                    List<String> list = new ArrayList<>();
                    list.add(val);
                    StringBuilder stringBuilder = new StringBuilder(val);
                    for (int j = i + 1; j < inputArray.length; j++) {
                        if (stringBuilder.append(inputArray[j]).toString().contentEquals(new StringBuilder(stringBuilder).reverse())) {
                            list.add(stringBuilder.toString());
                        }
                    }
                    return list.stream();
                })
                .distinct()
                .toList();
    }

    public static List<Integer> getPerfectNumbers(Integer firstNum, Integer lastNum) {
        return IntStream.range(firstNum, lastNum + 1)
                .filter(num -> {
                    List<Integer> delimeters = new ArrayList<>();
                    for (int i = 1; i < num; i++) {
                        boolean isDelimeter = num % i == 0;
                        if (isDelimeter) {
                            delimeters.add(i);
                        }
                    }
                    int sum = 0;
                    for (Integer j : delimeters) {
                        sum += j;
                    }
                    return sum == num;
                })
                .boxed()
                .toList();
    }
}

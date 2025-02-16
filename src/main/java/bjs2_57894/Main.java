package bjs2_57894;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        Map<String, List<String>> data1 = new HashMap<>();
        insertItemToTask1(data1, "Alice", List.of("Bob", "Charlie"));
        insertItemToTask1(data1, "Bob", List.of("Alice", "David"));
        insertItemToTask1(data1, "Charlie", List.of("Alice", "David"));
        insertItemToTask1(data1, "David", List.of("Bob", "Charlie"));

        List<Pair> friendOfFriends = getFriendOfFriends(data1);
        System.out.println(friendOfFriends);
        System.out.println();

        System.out.println("Task 2");
        List<Employee> data2 = new ArrayList<>();
        insertItemToTask2(data2, "Alice", 1, "Department 1");
        insertItemToTask2(data2, "Bob", 2, "Department 2");
        insertItemToTask2(data2, "Charlie", 3, "Department 1");
        insertItemToTask2(data2, "David", 4, "Department 3");
        insertItemToTask2(data2, "Ivan", 5, "Department 3");
        insertItemToTask2(data2, "Sven", 58, "Department 2");

        Map<String, Double> averageSalaryByDepartment = getAverageSalaryByDepartment(data2);
        System.out.println(averageSalaryByDepartment);
        System.out.println();

        System.out.println("Task 3");
        int from = 100;
        int to = 200;
        System.out.printf("[%d, %d]%n", from, to);
        List<Integer> palindroms = getPalindroms(from, to);
        System.out.println(palindroms);
        System.out.println();

        System.out.println("Task 4");
        String string = "abaca";
        System.out.println(string);
        List<String> substringsPalindroms = getSubstringsPalindroms(string);
        System.out.println(substringsPalindroms);
        System.out.println();

        System.out.println("Task 5");
        from = 1;
        to = 1000;
        System.out.printf("[%d, %d]%n", from, to);
        List<Integer> perfectDigits = getPerfectDigits(from, to);
        System.out.println(perfectDigits);
        System.out.println();
    }

    private static void insertItemToTask1(Map<String, List<String>> data, String name, List<String> friends) {
        data.put(name, friends);
        System.out.printf("%s: %s%n", name, friends);
    }

    private static void insertItemToTask2(List<Employee> data, String name, double salary, String department) {
        data.add(new Employee(name, salary, department));
        System.out.printf("%s %.2f %s%n", name, salary, department);
    }

    private static List<Pair> getFriendOfFriends(Map<String, List<String>> data) {
        List<Pair> sortedUniquePairs = data.entrySet()
                .stream()
                .map(kvp -> kvp.getValue()
                        .stream()
                        .map(friend -> new Pair(kvp.getKey(), friend))
                        .toList())
                .flatMap(List::stream)
                .distinct()    // Удаляем повторяющиеся пары
                .sorted(Comparator.comparing(Pair::first))
                .toList();

        Set<String> processedNames = new HashSet<>();
        List<Pair> result = new ArrayList<>();

        for (Pair pair : sortedUniquePairs) {
            String name = pair.first();
            String friendName = pair.second();

            if (processedNames.contains(name) || processedNames.contains(friendName)) {
                continue;
            }

            Optional<Pair> friendPair = sortedUniquePairs.stream()
                    .filter(p -> p.first().equals(friendName))
                    .findFirst();
            if (friendPair.isEmpty()) {
                continue;
            }

            result.add(new Pair(name, friendPair.get().second()));
            processedNames.add(friendName);
        }

        return result;
    }

    private static Map<String, Double> getAverageSalaryByDepartment(List<Employee> data) {
        return data.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    private static List<Integer> getPalindroms(int from, int to) {
        List<Integer> result = new ArrayList<>();

        List<Integer> invertedDigits = new ArrayList<>();

        int firstDigit = from;
        while (firstDigit > 0) {
            invertedDigits.add(firstDigit % 10);
            firstDigit /= 10;
        }

        for (int i = from; i <= to; i++) {
            if (checkPalindrom(invertedDigits)) {
                result.add(i);
            }

            int j = 0;
            for (; j < invertedDigits.size() - 1; j++) {
                int digit = invertedDigits.get(j);
                if (digit < 9) {
                    invertedDigits.set(j, digit + 1);
                    break;
                } else {
                    invertedDigits.set(j, 0);
                }
            }

            if (j == invertedDigits.size() - 1 && invertedDigits.get(j) <= 9) {
                invertedDigits.set(j, invertedDigits.get(j) + 1);
            }
        }

        return result;
    }

    private static List<String> getSubstringsPalindroms(String string) {
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

    private static List<Integer> getPerfectDigits(int from, int to) {
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

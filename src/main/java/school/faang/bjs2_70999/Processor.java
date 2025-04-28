package school.faang.bjs2_70999;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Processor {
    public static List<Set<String>> findMutualFriends(Map<String, List<String>> users) {
        List<String> people = new ArrayList<>(users.keySet());
        
        return IntStream.range(0, people.size())
        .boxed()
        .flatMap(i -> IntStream.range(i + 1, people.size())
                .mapToObj(j ->  {
                    String person1 = people.get(i);
                    String person2 = people.get(j);
                    List<String> friendsOfPerson1 = users.get(person1);
                    List<String> friendsOfPerson2 = users.get(person2);
                    boolean areDirectFriends = friendsOfPerson1.contains(person1);
                    boolean hasMutualFriends = friendsOfPerson1.stream().anyMatch(friendsOfPerson2::contains);
                    if (!areDirectFriends && hasMutualFriends) {
                        return Set.of(person1, person2);
                    } else {
                        return new HashSet<String>();
                    }
                })
        )
        .filter(s -> !s.isEmpty())
        .toList();
    }

    public static Map<String, Double> getAvgSalaryByDpt(List<Employee> employees) {
        return employees.stream()
        .collect(Collectors.groupingBy(
            (Employee::getDepartment),
            Collectors.averagingDouble(Employee::getSalary)
        ));
    }

    public static List<Integer> findPalindromicNumsInRange(int start, int end) {
        return IntStream.range(start, end).mapToObj(String::valueOf)
            .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
            .map(Integer::valueOf)
            .sorted()
            .toList();
    }

    public static List<String> findPalindromicStrings(String str) {
        return IntStream.range(0, str.length())
            .mapToObj(i -> Processor.intIndexToMapOfSubstrings(i, str))
            .flatMap(List::stream)
            .distinct()
            .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
            .toList();
    }

    public static List<Integer> findPerfectNumbersInRange(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(Processor::intToMapOfIntDivision)
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> entry.getValue().stream()
                        .reduce(0, Integer::sum).equals(entry.getKey())
                )
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private static Map<Integer, List<Integer>> intToMapOfIntDivision(int i) {
        ArrayList<Integer> multipliers = new ArrayList<>();
        for (int j = 1; j < i; j++) {
            if (i % j == 0) {
                multipliers.add(j);
            }
        }
        return Map.of(i, multipliers);
    }

    private static List<String> intIndexToMapOfSubstrings(int i, String str) {
        List<String> substrings = new ArrayList<>();
        for (int j = 1 + i; j <= str.length(); j++) {
            substrings.add(str.substring(i, j));
        }
        return substrings;
    }
}

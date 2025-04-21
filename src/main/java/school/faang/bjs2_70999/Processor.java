package school.faang.bjs2_70999;

import java.util.ArrayList;
import java.util.HashMap;
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
                        List<String> friendsofPerson2 = users.get(person2);
                        boolean areDirectFriends = friendsOfPerson1.contains(person1);
                        boolean hasMutualFriends = friendsOfPerson1.stream().anyMatch(friendsofPerson2::contains);
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

    public static Map<String, Double> calcAverageSalary(List<Employee> employees) {
        return employees.stream()
            .map(employee -> new HashMap<String, Double>(Map.of(employee.getDepartment(), employee.getSalary())))
            .flatMap(map -> map.entrySet().stream())
            .collect(Collectors.groupingBy(
                Map.Entry::getKey, 
                Collectors.averagingDouble(Map.Entry::getValue))
            );
    }

    public static List<Integer> findPalindromicNumsInRange(int start, int end) {
        IntStream intStream = IntStream.range(start, end);
        return intStream.mapToObj(i -> String.valueOf(i))
            .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
            .map(s -> Integer.valueOf(s))
            .sorted()
            .toList();
    }

    public static List<String> findPalindromicStrings(String str) {
        List<String> substrings = new ArrayList<>();
        IntStream intStream = IntStream.range(0, str.length());
        return intStream.mapToObj(i -> {
                for (int j = 1 + i; j <= str.length(); j++) {
                    substrings.add(str.substring(i, j));
                }
                return substrings;
            })
            .flatMap(List::stream)
            .distinct()
            .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
            .toList();
    }

    public static List<Integer> findPerfectNumbersInRange(int start, int end) {
        IntStream intStream = IntStream.range(start, end);
        return intStream.mapToObj(i -> {
                ArrayList<Integer> multipliers = new ArrayList<>();
                for (int j = 1; j < i; j++) {
                    if (i % j == 0) {
                        multipliers.add(j);
                    }
                }
                return Map.of(i, multipliers);
            })
            .flatMap(map -> map.entrySet().stream())
            .filter(entry -> entry.getValue().stream()
                .reduce(0, Integer::sum).equals(entry.getKey())
            )
            .collect(Collectors.mapping(Map.Entry::getKey, Collectors.toList()));
    }
}

package school.faang.stream_api3_BJS2_34812;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamProcessor {

    public List<String[]> findCommonFriends(Map<String, List<String>> users) {
        Set<String> friendships = users.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(friend -> {
                            String person = entry.getKey();
                            return person.compareTo(friend) < 0 ? person + "," + friend : friend + "," + person;
                        }))
                .collect(Collectors.toSet());

        List<String> people = new ArrayList<>(users.keySet());

        return people.stream()
                .flatMap(person1 -> people.stream()
                        .filter(person2 -> person1.compareTo(person2) < 0)
                        .filter(person2 -> {
                            String potentialFriendship = person1 + "," + person2;
                            return !friendships.contains(potentialFriendship);
                        })
                        .filter(person2 -> {
                            Set<String> commonFriends = new HashSet<>(users.get(person1));
                            commonFriends.retainAll(users.get(person2));
                            return !commonFriends.isEmpty();
                        })
                        .map(person2 -> new String[]{person1, person2})
                )
                .collect(Collectors.toList());
    }

    public Map<String, Double> findAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment
                        , Collectors.averagingDouble(Employee::getSalary)));
    }

    public List<Integer> findNumPalindromes(int from, int to) {
        List<Integer> numbers = createList(from, to);
        return numbers.stream()
                .map(String::valueOf)
                .filter((num) -> new StringBuilder(num).reverse().toString().equals(num))
                .map(Integer::parseInt)
                .toList();
    }

    public Set<String> findStringPalindromes(String str) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings.stream()
                .filter((s -> new StringBuilder(s).reverse().toString().equals(s)))
                .collect(Collectors.toSet());
    }

    public List<Integer> findPerfectNumbers(int from, int to) {
        List<Integer> numbers = createList(from, to);
        return numbers.stream()
                .filter((num) -> {
                    int sum = 0;
                    for (int i = 1; i < num; i++) {
                        if (num % i == 0) {
                            sum += i;
                        }
                    }
                    return sum == num;
                })
                .collect(Collectors.toList());
    }

    public List<Integer> createList(int from, int to) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = from; i < to; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}


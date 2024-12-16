package derschrank.sprint02.task11.bjstwo_47572;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi3 {
    public Set<List<String>> taskOneFindCommonFriends(Map<String, List<String>> personWithFriends) {
        return personWithFriends.entrySet().stream()
                        .filter(
                                x -> !isTheyFriends(personWithFriends, x.getValue().get(0), x.getValue().get(1))
                        ).map(x -> sortPersonsByNameFromList(x.getValue()))
                        .collect(Collectors.toSet());
    }

    private boolean isTheyFriends(Map<String, List<String>> personWithFriends, String person1, String person2) {
        return personWithFriends.get(person1).contains(person2)
                &&  personWithFriends.get(person2).contains(person1);
    }

    private List<String> sortPersonsByNameFromList(List<String> c) {
        String person1 = c.get(0);
        String person2 = c.get(1);
        return person1.compareTo(person2) <= 0 ? List.of(person1, person2) : List.of(person2, person1);
    }


    public Map<String, Double> taskTwoAverageSalary(Set<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingInt(Employee::salary)
                ));
    }

    public List<Integer> taskThreeFindPolindromNumbers(int begin, int end) {
        return Stream.iterate(begin, x -> x <= end, x -> x + 1)
                .filter(x -> new StringBuilder(String.valueOf(x)).reverse().toString().equals(String.valueOf(x)))
                .toList();
    }

    public Collection<String> taskFourMakeSubstringsFromString(String s) {
        Set<String> setOfSubStrings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if (!subString.isBlank()) {
                    setOfSubStrings.add(subString);
                }
            }
        }
        setOfSubStrings.remove(null);
        return setOfSubStrings;
    }

    public List<String> taskFourFindPolindromSubStrings(Collection<String> c) {
        return c.stream()
                .filter(x -> new StringBuilder(String.valueOf(x)).reverse().toString().equals(String.valueOf(x)))
                .toList();
    }

    public List<Integer> taskFiveFindSuperNumber(int begin, int end) {
        return Stream.iterate(begin, x -> x <= end, x -> x + 1)
                .filter(x -> Objects.equals(x,
                        Stream.iterate(1, y -> y < x, y -> y + 1)
                                .filter(y -> x % y == 0)
                                .reduce(0, (a, b) -> a + b)))
                .toList();
    }
}

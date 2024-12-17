package derschrank.sprint02.task11.bjstwo_47572;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi3 {
    public Set<List<String>> taskOneFindCommonFriends(Map<String, List<String>> personsWithTheirFriends) {
        return personsWithTheirFriends.entrySet().stream()

                .filter(
                        x -> !isTheyFriends(personsWithTheirFriends, x.getValue().get(0), x.getValue().get(1))
                ).map(x -> sortPersonsByNameFromList(x.getValue()))
                .collect(Collectors.toSet());
    }

    private boolean isTheyFriends(Map<String, List<String>> personWithFriends, String person1, String person2) {
        return personWithFriends.get(person1).contains(person2)
                && personWithFriends.get(person2).contains(person1);
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
        return IntStream.rangeClosed(begin, end).boxed()
                .filter(getPolindromePredicate())
                .toList();
    }

    public List<String> taskFourFindPolindrom(String string) {
        return taskFourFindPolindromSubStrings(
                taskFourMakeSubstringsFromString(string));
    }

    private Collection<String> taskFourMakeSubstringsFromString(String s) {
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

    private List<String> taskFourFindPolindromSubStrings(Collection<String> collection) {
        return collection.stream()
                //.filter(x -> new StringBuilder(String.valueOf(x)).reverse().toString().equals(String.valueOf(x)))
                .filter(getPolindromePredicate())
                .toList();
    }

    private <T> Predicate<T> getPolindromePredicate() {
        return x -> new StringBuilder(String.valueOf(x)).reverse().toString().equals(String.valueOf(x));
    }

    public List<Integer> taskFiveFindSuperNumber(int begin, int end) {
        return IntStream.rangeClosed(begin, end)
                .filter(x -> Objects.equals(x,
                        IntStream.range(1, x)
                                .filter(y -> x % y == 0)
                                .sum())).boxed()
                .toList();
    }
}

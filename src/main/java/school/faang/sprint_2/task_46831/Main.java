package school.faang.sprint_2.task_46831;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public Set<List<String>> findPairsWithMutualFriends(@NonNull Map<String, List<String>> friends) {
        var pairsNoFriends = friends.entrySet().stream()
                .flatMap(personEntry  ->
                        friends.keySet().stream()
                                .filter(otherPerson ->
                                        !personEntry.getValue().contains(otherPerson)
                                                && !otherPerson.equals(personEntry.getKey()))
                                .map(otherPerson -> Arrays.asList(personEntry.getKey(), otherPerson))
                )
                .peek(pair -> pair.sort(Comparator.naturalOrder()))
                .collect(Collectors.toSet());
        return pairsNoFriends.stream()
                .filter(pair -> {
                    var firstPersonFriends = friends.get(pair.get(0));
                    var secondPersonFriends = friends.get(pair.get(1));
                    return firstPersonFriends.stream().anyMatch(secondPersonFriends::contains);
                })
                .collect(Collectors.toSet());
    }

    public Map<String, Double> findAverageSalaryForEachEmployee(@NonNull List<Employee> employees) {
        return employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingInt(Employee::getSalary)
                        )
                );
    }

    public List<Integer> findAllNumbersPalindromes(int leftBorder, int rightBorder) {
        validateBorders(leftBorder, rightBorder);
        return IntStream.rangeClosed(leftBorder, rightBorder)
                .boxed()
                .filter(num -> isPalindrome(String.valueOf(num)))
                .toList();
    }

    public List<String> findAllSubstringsPalindromes(@NonNull String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("String can`t be blank");
        }
        return IntStream.range(0, string.length()).boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, string.length()).mapToObj(j -> string.substring(i, j)))
                .distinct()
                .filter(this::isPalindrome)
                .toList();
    }

    public List<Integer> findExcellentNumbers(int leftBorder, int rightBorder) {
        validateBorders(leftBorder, rightBorder);
        return IntStream.rangeClosed(leftBorder, rightBorder).boxed()
                .filter(currentNum ->
                    IntStream.range(1, currentNum)
                            .filter(divider -> currentNum % divider == 0)
                            .sum() == currentNum
                )
                .toList();
    }

    private void validateBorders(int leftBorder, int rightBorder) {
        if (leftBorder >= rightBorder) {
            throw new IllegalArgumentException("Left border must be less then right border");
        }
    }

    private boolean isPalindrome(@NonNull String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("String can`t be blank");
        }
        return new StringBuilder(string).reverse().toString().equals(string);
    }
}

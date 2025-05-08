package school.faang.unique_pairs;

import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final Set<Integer> numbers = Set.of(1, 8, 9, 5);
        final int targetNumber = 10;
        Set<int[]> uniquePairs = findUniquePairs(numbers, targetNumber);
        uniquePairs.forEach(pair -> System.out.println(pair[0] + " " + pair[1]));
    }

    private static Set<int[]> findUniquePairs(Set<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .filter(number -> number > targetNumber - number)
                .filter(number -> numbers.contains(targetNumber - number))
                .map(x -> new int[]{x, targetNumber - x})
                .collect(Collectors.toSet());
    }
}

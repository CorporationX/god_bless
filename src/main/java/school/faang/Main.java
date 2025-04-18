package school.faang;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        final int targetNumber = 6;
        List<int[]> uniquePairs = findUniquePairs(numbers, targetNumber);
        uniquePairs.forEach(pair -> System.out.println(pair[0] + " " + pair[1]));
    }

    public static List<int[]> findUniquePairs(Set<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .flatMap(first -> numbers.stream()
                        .filter(second -> first + second == targetNumber)
                        .filter(second -> first > second)
                        .map(second -> new int[]{first, second}))
                .peek(pair -> System.out.println(pair[0] + " " + pair[1]))
                .toList();
    }
}

package school.faang.m1.stream;

import java.util.*;
import java.util.stream.Collectors;


/*
    1️⃣ Найдите уникальные пары чисел
    Дано множество (Set) целых чисел и целевое число.
    Найдите все уникальные пары чисел, сумма которых равна заданному числу.

    Пример:
    Вход: [1, 2, 3, 4, 5, 6], целевое число: 6
    Выход: [(1, 5), (2, 4)]
 */
public class SetOperations {
    public static void main(String[] args) {
        HashSet<Integer> inputSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int targetNumber = 0;
        System.out.println(getPairsGivingTotal(inputSet, targetNumber));
        System.out.println(getPairsGivingTotalOptimal(inputSet, targetNumber));
    }

    private static Set<List<Integer>> getPairsGivingTotal(Set<Integer> inputSet, int targetNumber) {
        return inputSet.stream().flatMap(a -> inputSet.stream().filter(b ->
                a < b && a + b == targetNumber).map(b -> Arrays.asList(a, b))).collect(Collectors.toSet());
    }

    /*
     unique pair & O(1) lookup, a < b ensures uniqueness without extra dedup steps.
     */
    private static Set<List<Integer>> getPairsGivingTotalOptimal(HashSet<Integer> inputSet, int targetNumber) {
        return inputSet.stream()
                .filter(a -> {
                    int b = targetNumber - a;
                    return a < b && inputSet.contains(b);
                })
                .map(a -> List.of(a, targetNumber - a)).collect(Collectors.toSet());
    }
}

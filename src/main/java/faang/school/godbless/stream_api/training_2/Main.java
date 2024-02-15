package faang.school.godbless.stream_api.training_2;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int target = 10;
        System.out.println(printTwoSum(numbers, target));
    }

    public static Set<List<Integer>> printTwoSum(List<Integer> numbersList, Integer targetSum) {
        return numbersList.stream()
                .flatMap(num1 -> numbersList.stream()
                        .filter(num2 -> num1 + num2 == targetSum && !num1.equals(num2))
                        .map(num2 -> Arrays.asList(num1, num2).stream()
                                .sorted().collect(Collectors.toList())))
                .collect(Collectors.toSet());

    }

}

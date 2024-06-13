package faang.school.godbless;

import java.util.List;
import java.util.stream.Collectors;

public class TargetSum {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 5, 7, 8, 10);
        var result = targetSum(numbers, 10);
        result.forEach(System.out::println);
    }
    public static List<List<Integer>> targetSum(List<Integer> nums, int target) {
        List<List<Integer>> result = nums.stream().flatMap(firstNum -> nums.stream()
                        .filter(secondNums -> firstNum != secondNums && firstNum + secondNums == target)
                        .map(secondNum -> List.of(firstNum, secondNum)))
                .distinct().collect(Collectors.toList());
        return result;
    }
}

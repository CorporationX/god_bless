package faang.school.godbless.BJS2_22430;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> inputList = List.of(1, 9, 3, 5, 6, 4, 5);
        int targetSum = 10;
        System.out.println(uniquePairs(inputList, targetSum));
    }


    public static Map<String, Integer> uniquePairs(List<Integer> inputList, int targetSum) {
        Map<String, Integer> resultMap = inputList.stream()
                .flatMap(outerNum -> inputList.stream()
                        .filter(innerNum -> innerNum + outerNum == targetSum && (outerNum > innerNum || outerNum.equals(innerNum)))
                        .map(innerNum -> outerNum + "," + innerNum))
                .collect(Collectors.toMap(value -> value, value -> targetSum, (target1, target2) -> targetSum));

        return resultMap;
    }
}

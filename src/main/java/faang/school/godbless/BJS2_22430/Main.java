package faang.school.godbless.BJS2_22430;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    //    Пример: Input List: [1, 9, 3, 6, 4, 5]
//    Target Sum: 10
//    Pairs: [[1, 9], [6, 4]]
    public static void main(String[] args) {
        List<Integer> inputList = List.of(1, 9, 3, 6, 4, 5);
        int targetSum = 10;
        System.out.println(uniquePairs(inputList, targetSum));
    }


    public static Map<String,Integer> uniquePairs(List<Integer> inputList, int targetSum) {
         Map<String,Integer> resultMap = inputList.stream()
                .flatMap(outerNum -> inputList.stream()
                        .filter(innerNum -> !outerNum.equals(innerNum) && innerNum + outerNum == targetSum && outerNum<innerNum).map(innerNum->outerNum+","+innerNum)).collect(Collectors.toMap(val->val,val->targetSum));

        return resultMap;
    }
}

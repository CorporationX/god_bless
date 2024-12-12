package school.faang.bjs_47121;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOperations2 {
    public static Map<Integer, Integer> pairOfNumbers(List<Integer> numbers, int sum) {
        Map<Integer, Integer> pairNumbers = new HashMap<>();

        numbers.forEach(number -> {
            int secondNumber = sum - number;

            if (numbers.contains(secondNumber) && !pairNumbers.containsKey(secondNumber)
                    && !pairNumbers.containsValue(secondNumber)) {
                pairNumbers.put(number, secondNumber);
            }

        });
        return pairNumbers;
    }

}

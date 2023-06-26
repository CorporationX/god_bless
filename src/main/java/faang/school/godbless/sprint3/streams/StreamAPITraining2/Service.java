package faang.school.godbless.sprint3.streams.StreamAPITraining2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {

    public Map<Integer, Integer> findUniquePairNumbersWhichEqualThis(List<Integer> list, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, Integer> memory = new HashMap<>();
        list.forEach(number -> {
            int tempResult = target - number;
            if (memory.containsKey(tempResult)) {
                if (tempResult + number == target) {
                    result.put(tempResult, number);
                }
            } else {
                memory.put(number, tempResult);
            }
        });
        return result;
    }
}

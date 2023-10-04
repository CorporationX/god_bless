package sprint2.magic;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 1, 3, 4, 5, 1};
        Map<Integer, Integer> map = uniqueNumbers(arr);
        System.out.println(map);
    }

    private static Map<Integer, Integer> uniqueNumbers(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int key : nums) {
            if (!result.containsKey(key)) {
                result.put(key, 1);
            } else {
                //result.computeIfPresent(num, (key, value) -> result.put(key, value + 1));
                int value = result.get(key);
                result.put(key, value + 1);
            }
        }
        return result;
    }
}

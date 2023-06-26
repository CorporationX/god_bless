package faang.school.godbless.StreamAPI2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 5, 5, 6, 6);

        System.out.println(Stream.pairsOfNumbers(nums, 10));

        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("C", "c");
        map.put("B", "b");
        map.put("A", "A");

        Stream.countriesAlphabetically(map);
    }
}

package school.faang.streamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<String, String> map = new HashMap<>();
        map.put("Russia", "Moscow");
        map.put("USA", "Washington");
        map.put("Germany", "Berlin");



        StreamApi.findUniqPairs(numbers, 7).forEach(pair -> System.out.print(Arrays.toString(pair)));
        System.out.println();
        System.out.println(StreamApi.dexToBinary(numbers));

    }
}

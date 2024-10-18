package school.faang.streamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> stringList1 = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> stringList2 = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        Map<String, String> mapCapital = new HashMap<>();
        mapCapital.put("Russia", "Moscow");
        mapCapital.put("USA", "Washington");
        mapCapital.put("Germany", "Berlin");


        StreamApi.findUniqPairs(numbers, 7).forEach(System.out::print);
        System.out.println();
        System.out.println(StreamApi.sortMapByStream(mapCapital));
        System.out.println(StreamApi.sortAndFilter(stringList1, 'a'));
        System.out.println(StreamApi.dexToBinary(numbers));
        System.out.println(StreamApi.checkString(stringList2, "abcdefghijklmnopqrstuvwxyz"));


    }
}

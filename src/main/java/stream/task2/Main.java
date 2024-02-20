package stream.task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,9,3,6,4,5);
        StreamApi2.findPair(list, 9);
        Map<String, String> map = new HashMap<>();
        map.put("Russia", "Moscow");
        map.put("Argentina", "Bueno");
        map.put("Brazil", "San Paulo");
        map.put("USA", "New York");
        StreamApi2.printCountryCity(map);
        List<String> strings = List.of("Iphone", "Banana", "Uber", "Google", "Booking");
        List<String> filterList = StreamApi2.getList(strings, 'B');
        System.out.println(filterList);
    }
}

package faang.school.godbless.BJS2_8093;

import java.util.HashMap;
import java.util.Map;

public class Houses {
    private Map<String, House> map = new HashMap<>();
    public  void add(House house) {
        if (!map.containsKey(house.getName()))
            map.put(house.getName(), house);
    }

    public  void remove(String houseName) {
        map.remove(houseName);
    }

    public  void printHouseSigil(String houseName) {
        System.out.println(map.get(houseName).getSigil());
    }

    public  void printAllHouses() {
        map.forEach((s, house) -> System.out.println(house));
    }
}

package faang.school.godbless.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houseMap = new HashMap<>();

        houseMap.put("Stark", new House("Stark", "Wolf"));
        houseMap.put("Lannister", new House("Lannister", "Leo"));
        houseMap.put("Barateon", new House("Barateon", "Deer"));

        House house = new House(houseMap);

        house.addHouse("Stark", new House("Stark", "Wolf"));
        house.removeHouse("Lannister");

        house.searchHouse("Stark");
        house.searchHouse("Lannister");

        house.getHousesAndSigils();
    }
}

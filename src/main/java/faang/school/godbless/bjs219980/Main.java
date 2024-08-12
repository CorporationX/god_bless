package faang.school.godbless.bjs219980;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        House stark = new House("Stark", "A grey direwolf on a white field");
        House lannister = new House("Lannister", "A golden lion rampant on a red field");
        House baratheon = new House("Baratheon", "A crowned black stag on a gold field");
        houses.put(stark.getName(), stark);
        houses.put(lannister.getName(), lannister);
        houses.put(baratheon.getName(), baratheon);

        HouseManager.addHouse(houses, "Targaryen", "Three dragons on a black field");
        HouseManager.removeHouse(houses, "Lannister");
        HouseManager.findSigilByHouseName(houses, "Baratheon");
        HouseManager.findAll(houses);
    }
}

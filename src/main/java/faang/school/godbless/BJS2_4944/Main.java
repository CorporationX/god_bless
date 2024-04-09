package faang.school.godbless.BJS2_4944;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        House stark = new House("Stark", "wolf");
        House lannister = new House("Lanister", "lion");
        House barateon = new House("Barateon", "deer");

        House.addHouse(houses, stark);
        House.addHouse(houses, lannister);
        House.addHouse(houses, barateon);
        House.printAllHouses(houses);

        House.deleteHouse(houses, stark);
        House.printAllHouses(houses);

        System.out.println(House.findHouseByName(houses, "Lanister"));
        System.out.println(House.findHouseByName(houses, "Barateon"));
    }
}

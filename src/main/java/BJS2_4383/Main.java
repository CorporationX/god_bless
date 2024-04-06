package BJS2_4383;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "Wolf");
        House lannister = new House("Lannister", "Lion");
        House barateon = new House("Barateon", "Deer");

        House.addHouse(HOUSES, stark);
        House.addHouse(HOUSES, lannister);
        House.addHouse(HOUSES, barateon);
        System.out.println(House.findHouse(stark.getName(), HOUSES));
        House.deleteHouse(HOUSES, stark);
        House.addHouse(HOUSES, stark);
        House.allHouse(HOUSES);
    }
}

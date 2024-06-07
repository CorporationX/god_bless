package faang.school.godbless.Task6;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, House> houses = new HashMap<>();
        House stark = new House("Stark", "Fire");
        House lannister = new House("Lannister", "Frost");
        House barateon = new House("Barateon", "Earth");
        houses.put(stark.getName(), stark);
        houses.put(lannister.getName(), lannister);
        houses.put(barateon.getName(), barateon);
        System.out.println(houses);

        House pain = new House("Pain", "Rose");
        pain.addToMap(houses);
    }

}

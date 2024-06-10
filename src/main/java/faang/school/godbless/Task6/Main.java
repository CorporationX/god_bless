package faang.school.godbless.Task6;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.Task6.House.findHouse;
import static faang.school.godbless.Task6.House.removeHouse;


public class Main {

    public static void showHouses(Map<String, House> houses) {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getSigil());
        }
    }

    public static void main(String[] args) {

        Map<String, House> houses = new HashMap<>();
        House stark = new House("Stark", "Fire");
        House lannister = new House("Lannister", "Frost");
        House barateon = new House("Barateon", "Earth");
        houses.put(stark.getName(), stark);
        houses.put(lannister.getName(), lannister);
        houses.put(barateon.getName(), barateon);
        System.out.println(houses);
        //adding house into hashmap
        House pain = new House("Pain", "Rose");
        pain.addToMap(houses);
        System.out.println(houses);
        //removing house from hashmap
        removeHouse(stark.getName(), houses);
        System.out.println(houses);
        //searching for house
        findHouse("Pain", houses);
        //showing all houses with their sigils
        showHouses(houses);

    }

}

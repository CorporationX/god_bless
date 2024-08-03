package faang.school.godbless.BJS2_19803;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, House> houses = new HashMap<>();
        houses.put("Stark", new House("Stark", "black"));
        houses.put("Lannister", new House("Lannister", "white"));
        houses.put("Barateon", new House("Barateon", "blue"));

        House.addHouse(houses, new House("Robert", "red"));
        System.out.println(houses);

        House.removeHouse(houses, "Stark");
        System.out.println(houses);

        String sigil = House.findSigilByHouseName(houses, "Robert");
        System.out.println(sigil);

        House.printAllHouses(houses);
    }
}

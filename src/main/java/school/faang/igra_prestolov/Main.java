package school.faang.igra_prestolov;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        House Starck = new House("Starck", "zebra");
        House Lannister = new House("Lanister", "lion");
        House Barateon = new House("Barateon", "capybara");

        addHouse("Starck", Starck);
        addHouse("Lannister", Lannister);
        addHouse("Barateon", Barateon);
        printAllHouses();
        removeHouse("Starck");
        printAllHouses();
        getSigilByHouseName("Lannister");
    }

    public static void addHouse(String name, House house) {
        HOUSES.put(name, house);
    }

    public static void removeHouse(String name) {
        HOUSES.remove(name);
    }

    public static void getSigilByHouseName(String name) {
        House house = HOUSES.get(name);
        System.out.println(name + " house sigil is: " + house.getSigil());
    }

    public static void printAllHouses() {
        for (Map.Entry<String, House> entry : HOUSES.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

package faang.school.godbless.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<String, House> HOUSE_MAP = new HashMap<>();

    public static void main(String[] args) {
        HOUSE_MAP.put("Stark", new House("Stark", "Wolf"));
        HOUSE_MAP.put("Baratheon", new House("Baratheon", "Deer"));
        HOUSE_MAP.put("Lannister", new House("Lannister", "Lion"));
        addHouse("Targaryen", "Dragon");
        findHouseByName("Targaryen");
        removeHouseByName("Targaryen");
        showAllHouses();
    }

    public static void addHouse(String name, String sigil) {
        House house = new House(name, sigil);
        HOUSE_MAP.put(name, house);
    }

    public static void removeHouseByName(String name) {
        HOUSE_MAP.remove(name);
    }

    public static void findHouseByName(String name) {
        String sigil = HOUSE_MAP.get(name).getSigil();
        System.out.printf("Sigil of house %s is %s\n", name, sigil);
    }

    public static void showAllHouses() {
        for (House house : HOUSE_MAP.values()) {
            System.out.printf("House - %s, Sigil - %s\n", house.getName(), house.getSigil());
        }
    }
}
package faang.school.godbless.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<String, House> HOUSE_MAP = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "Wolf");
        House baratheon = new House("Baratheon", "Deer");
        House lannister = new House("Lannister", "Lion");
        House targaryen = new House("Targaryen", "Dragon");
        addHouse(stark);
        addHouse(baratheon);
        addHouse(lannister);
        addHouse(targaryen);
        findHouseByName("Targaryen");
        findHouseByName("Tyrell");
        removeHouseByName("Targaryen");
        showAllHouses();
    }

    public static void addHouse(House house) {
        HOUSE_MAP.put(house.getName(), house);
    }

    public static void removeHouseByName(String name) {
        HOUSE_MAP.remove(name);
    }

    public static void findHouseByName(String name) {
        if (HOUSE_MAP.get(name) != null) {
            System.out.printf("Sigil of house %s is %s\n", name, HOUSE_MAP.get(name).getSigil());
        } else {
            System.out.printf("No house with name %s is found\n", name);
        }
    }

    public static void showAllHouses() {
        for (House house : HOUSE_MAP.values()) {
            System.out.printf("House - %s, Sigil - %s\n", house.getName(), house.getSigil());
        }
    }
}
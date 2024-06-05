package faang.school.godbless;

import java.util.HashMap;

public class Main {
    private static HashMap<String, House> mapOfHouses = new HashMap<>();

    public static void addHouse(House house) {
        mapOfHouses.put(house.getName(), house);
    }

    public static void deleteHouse(String name) {
        mapOfHouses.remove(name);
    }

    public static void findHouse(String name) {
        if (mapOfHouses.containsKey(name)) {
            System.out.println(name + " has a sigil: " + mapOfHouses.get(name).getSigil());
        } else {
            System.out.println("The house " + name + " not found");
        }
    }

    public static void showAllHouses() {
        for (var entry : mapOfHouses.entrySet()) {
            System.out.println("House: " + entry.getKey() + ", sibil: " + entry.getValue().getSigil());
        }
    }

    public static void main(String[] args) {
        House stark = new House("Stark", "Grey wolf");
        House lannister = new House("Lannister", "Golden lion");
        House baratheon = new House("Baratheon", "Black stag");
        addHouse(stark);
        addHouse(lannister);
        addHouse(baratheon);
        showAllHouses();
        deleteHouse("Stark");
        findHouse("Stark");
        showAllHouses();
    }
}

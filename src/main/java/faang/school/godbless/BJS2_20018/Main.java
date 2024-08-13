package faang.school.godbless.BJS2_20018;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, House> mapHouses = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "Fierce wolf");
        House lannister = new House("Lannister", "Lion");
        House baratheon = new House("Baratheon", "Deer");

        addHouse(stark);
        addHouse(lannister);
        addHouse(baratheon);
        deleteHouse("Stark");
        outputInformationEmblemHouse("Lannister");
        outputAllHouse();

    }

    public static void addHouse(House house) {
        if (house != null) {
            mapHouses.put(house.getName(), house);
        } else {
            System.out.println("house не может быть null");
        }
    }

    public static void deleteHouse(String nameHouse) {
        if (!nameHouse.trim().isEmpty()) {
            mapHouses.remove(nameHouse);
        } else {
            System.out.println("имя дома не может быть пустым");
        }

    }

    public static void outputInformationEmblemHouse(String nameHouse) {
        if (!nameHouse.trim().isEmpty()) {
            House house = mapHouses.get(nameHouse);
            if (house != null) {
                System.out.println(mapHouses.get(nameHouse).getSigil());
            } else {
                System.out.println("house = null");
            }
        } else {
            System.out.println("имя дома не может быть пустым");
        }
    }

    public static void outputAllHouse() {
        for (Map.Entry<String, House> entry : mapHouses.entrySet()) {
            System.out.println("House: " + entry.getKey() + "; Emblem: " + entry.getValue().getSigil());
        }
    }
}

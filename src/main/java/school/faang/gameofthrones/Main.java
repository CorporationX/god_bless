package school.faang.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    private static void addHouse(House house) {
        HOUSES.put(house.getName(), house);
    }

    private static void deleteHouseByName(String name) {
        HOUSES.remove(name);
    }

    private static void getSigilByHouseName(String houseName) {
        System.out.println(HOUSES.get(houseName).getSigil());
    }

    private static void getAllHousesWithSigils() {
        for (Map.Entry<String, House> entry : HOUSES.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        House stark = new House("Stark", "Wolf");
        House lannister = new House("Lanister", "Lion");
        House baratheon = new House("Baratheon", "Deer");

        HOUSES.put("Stark", stark);
        HOUSES.put("Lannister", lannister);
        HOUSES.put("Baratheon", baratheon);

        addHouse(new House("Targaryen", "Dragon"));
        addHouse(new House("Greyjoy", "Kraken"));

        getSigilByHouseName("Stark");
        deleteHouseByName("Targaryen");
        getAllHousesWithSigils();
    }
}
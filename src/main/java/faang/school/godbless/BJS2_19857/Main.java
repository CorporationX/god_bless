package faang.school.godbless.BJS2_19857;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "direwolf");
        House lannister = new House("Lannister", "lion");
        House barateon = new House("Barateon", "deer");
        addHouse(stark);
        addHouse(lannister);
        addHouse(barateon);
        deleteHouseByName("Barateon");
        searchHouseAndPrintSigilByName("Lannister");
        printAllHousesAndSigils();
    }

    private static void addHouse(House house) {
        HOUSES.put(house.getName(), house);
    }

    private static void deleteHouseByName(String name) {
        HOUSES.remove(name);
    }

    private static void searchHouseAndPrintSigilByName(String name) {
        System.out.println(HOUSES.get(name).getSigil());
    }

    private static void printAllHousesAndSigils() {
        HOUSES.forEach((name, house) -> System.out.println(name + " house has " + house.getSigil() + " sigil"));
    }
}

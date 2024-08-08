package faang.school.godbless.thrones;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.thrones.HouseService.*;

public class Main {

    public static Map<String, House> houses = new HashMap<>();

    static{
        houses.put("Stark", new House("Stark", "Stark"));
        houses.put("Lannister", new House("Lannister", "Lannister"));
        houses.put("Barateon", new House("Barateon", "Barateon"));
    }

    public static void main(String[] args) {

        printHouses();
        addHouse("Test", "Test");
        System.out.println("\n");
        printHouses();
        removeHouse("Stark");
        System.out.println("\n");
        printHouses();
        System.out.println("\n");
        findHouseAndPrintSigillInfo("Test");

    }
}

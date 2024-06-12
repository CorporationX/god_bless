package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Application {

    private static Map<String, House> houses = new HashMap<>();

    public static void addNewHouse(House house) {
        if(house.getName() != null) {
            houses.put(house.getName(), house);
        }
        else {
            System.err.println("Error!");
        }

    }

    public static void deleteHouseByName(String name) {
        if(name != null && houses.containsKey(name)) {
            houses.remove(name);
        }
        else {
            System.err.println("Error!");
        }
    }

    public static void getInfoByName(String name) {
        String sigil = houses.get(name).getSigil();
        if(sigil.isEmpty()) {
            System.err.printf("House %s don't find", name);
        }
        else {
            System.out.printf("The sigil of %s is %s%n", name, sigil);
        }
    }

    public static void printAllHouses() {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {

        addNewHouse(new House("Stark", "Direwolf"));
        addNewHouse(new House("Lannister", "Lion"));
        addNewHouse(new House("Baratheon", "Stag"));

        printAllHouses();

        getInfoByName("Stark");

        deleteHouseByName("Lannister");

        printAllHouses();
    }
}

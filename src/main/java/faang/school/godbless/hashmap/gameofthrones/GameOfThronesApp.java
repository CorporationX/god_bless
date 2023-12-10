package faang.school.godbless.hashmap.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class GameOfThronesApp {

    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        House house1 = new House("Starkoracia", "Phoenix");
        House house2 = new House("House of Valor", "Lion");
        House house3 = new House("House of Serenity", "Swan");
        House house4 = new House("House of Wisdom", "Owl");

        addNewHouse(house1);
        addNewHouse(house2);
        addNewHouse(house3);
        addNewHouse(house4);
        printHousesData();

        deleteHouseByName("House of Serenity");
        printHousesData();

        printSigilByHouseName("Starkoracia");
        printHousesData();
    }

    private static void addNewHouse(House house) {
        houses.put(house.getName(), house);
    }

    private static void deleteHouseByName(String name) {
        houses.remove(name);
    }

    private static void printSigilByHouseName(String name) {
        System.out.println(houses.get(name).getSigil());
    }

    private static void printHousesData() {
        houses.forEach((name, house) -> System.out.printf("House: %s\nSigil: %s\n\n", name, house.getSigil()));
    }

}

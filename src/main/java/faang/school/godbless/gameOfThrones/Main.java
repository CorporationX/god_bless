package faang.school.godbless.gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        houses.put("Stark", new House("Stark", "Wolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Baratheon", new House("Baratheon", "Deer"));

        addNewHouse(new House("Greyjoy", "Kraken"));
        deleteHouse("Lannister");

        informationAboutSigil("Stark");
        informationAboutSigil("Staaaaark");

        displayingAllHousesAndSigils();

    }

    public static void addNewHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void deleteHouse(String nameOfHouse) {
        houses.remove(nameOfHouse);
    }

    public static void informationAboutSigil(String nameOfHouse) {
        House house = houses.get(nameOfHouse);
        if (house != null) {
            System.out.println("Герб дома " + nameOfHouse + ": " + house.getSigil());
        } else {
            System.out.println("Дом " + nameOfHouse + " не найден.");
        }
    }

    public static void displayingAllHousesAndSigils() {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getValue().getName() + " : " + entry.getValue().getSigil());
        }
    }
}
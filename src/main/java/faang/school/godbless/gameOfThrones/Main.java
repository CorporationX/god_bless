package faang.school.godbless.gameOfThrones;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> mapHouses = new HashMap<>();
        mapHouses.put("Stark", new House("Stark", "Wolf"));
        mapHouses.put("Lannister", new House("Lannister", "Lion"));
        mapHouses.put("Baratheon", new House("Baratheon", "Deer"));

        // Добавим новый дом
        addNewHouse(mapHouses, new House("Greyjoy", "Kraken"));
        // Удалим дом
        deleteHouse(mapHouses, "Lannister");
        // Выведем информацию о доме
        informationAboutSigil(mapHouses, "Stark");
        informationAboutSigil(mapHouses, "Staaaaark");

        // Выведем информацию о всех домах
        displayingAllHousesAndSigils(mapHouses);

    }

    public static void addNewHouse(Map<String, House> mapHouses, House house) {
        mapHouses.put(house.getName(), house);
    }

    public static void deleteHouse(Map<String, House> mapHouses, String nameOfHouse) {
        mapHouses.remove(nameOfHouse);
    }

    public static void informationAboutSigil(Map<String, House> mapHouses, String nameOfHouse) {
        House house = mapHouses.get(nameOfHouse);
        if (house != null) {
            System.out.println("Герб дома " + nameOfHouse + ": " + house.getSigil());
        } else {
            System.out.println("Дом " + nameOfHouse + " не найден.");
        }
    }

    public static void displayingAllHousesAndSigils(Map<String, House> mapHouses) {
        for (Map.Entry<String, House> entry : mapHouses.entrySet()) {
            System.out.println(entry.getValue().getName() + " : " + entry.getValue().getSigil());
        }
    }

}

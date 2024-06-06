
package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> houseMap = new HashMap<>();

    public static void main(String[] args) {
        House vesterosa = new House("Vesterosa", "v");
        House stark = new House("Stark", "s");
        House lannister = new House("Lannister", "l");

        houseMap.put(vesterosa.getName(), vesterosa);
        houseMap.put(stark.getName(), stark);
        houseMap.put(lannister.getName(), lannister);

        addNewHouse(new House("Baratheon", "b"));
        removeHouse("Stark");
        findSigilByName("Vesterosa");
        printAllHouses();
    }

    public static void addNewHouse(House house) {
        houseMap.put(house.getName(), house);
    }

    public static void removeHouse(String name) {
        houseMap.remove(name);
    }

    public static void findSigilByName(String name) {
        System.out.println(houseMap.get(name).getSigil());
    }

    public static void printAllHouses() {
        for (Map.Entry<String, House> house : houseMap.entrySet()) {
            System.out.println(house.getKey() + ": " + house.getValue().getSigil());
        }
    }
}
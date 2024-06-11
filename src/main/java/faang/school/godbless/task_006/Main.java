package faang.school.godbless.task_006;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houseMap = new HashMap<>();

    public static void main(String[] args) {


        houseMap.put("Starks", new House("Starks", "Wolf"));
        houseMap.put("Arrens", new House("Arrens", "Bird"));
        houseMap.put("Barateons", new House("Barateons", "Deer"));
        houseMap.put("Greyjoies", new House("Greyjoies", "Octopus"));
        houseMap.put("Lanisters", new House("Lanisters", "Lion"));
        houseMap.put("Martels", new House("Martels", "Spear"));

        System.out.println("изначальный список домов:");
        printAllHouses();
        System.out.println();

        System.out.println("Добавление дома \"Tallis\"");
        House newHouse = new House("Tallis", "Fish");
        addHouse(newHouse);

        System.out.println("Удаление дома \"Starks\"");
        removeHouse("Starks");
        System.out.println();

        System.out.println("итоговый список домов: ");
        printAllHouses();

    }

    private static void printAllHouses() {
        for (House house : houseMap.values()) {
            System.out.println(house);
        }
    }

    private static void removeHouse(String nameHouse) {
        houseMap.remove(nameHouse);
    }

    private static void addHouse(House house) {
        if (!houseMap.containsKey(house.name())) {
            houseMap.put(house.name(), house);
        }
    }


}

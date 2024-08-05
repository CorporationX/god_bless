package faang.school.hashmap.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static private final HashMap<String, House> mapHouse = new HashMap<>();
    public static void main(String[] args) {
        House stark = new House("Stark", "Direwolf");
        House lannister = new House("Lannister", "Leon");
        House baratheons = new House("Baratheons", "Black deer");
        House martell = new House("Martell", "Solar spear");
        House arenas = new House("Arenas", "White falcon and the moon");

        addNewHouse(stark);
        addNewHouse(lannister);
        addNewHouse(baratheons);
        addNewHouse(martell);
        addNewHouse(arenas);

        printAllHouseAndSigil();
        printInfoSigil("Stark");
        deleteHouse(" ");
        deleteHouse("Stark");
        printAllHouseAndSigil();

    }

    private static void addNewHouse(House house) {
        mapHouse.put(house.getNameHouse(), house);
    }

    private static void deleteHouse(String nameHouse) {
        if (!(nameHouse.isBlank())) {
            mapHouse.remove(nameHouse);
        } else {
            System.out.println("Введите название дома");
        }
    }

    private static void printInfoSigil(String nameHouse) {
        if (mapHouse.containsKey(nameHouse)) {
            System.out.println(mapHouse.get(nameHouse).getSigilHouse());
        }
    }

    private static void printAllHouseAndSigil() {
        for (Map.Entry<String, House> house : mapHouse.entrySet()) {
            System.out.println(house);
        }
    }
}

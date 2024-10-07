package school.faang.bjs2_32420_game_of_thrones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSE_DATA = new HashMap<>();

    public static void main(String[] args) {
        HOUSE_DATA.putAll(Map.of(
                "Wolf", new House("Stark", "Wolf"),
                "Lion", new House("Lannister", "Lion"),
                "Stag", new House("Baratheon", "Stag")
        ));
        System.out.println(HOUSE_DATA);

        addHouse(new House("Targaryen", "Dragon"));
        System.out.println(HOUSE_DATA);

        removeHouse("Stark");
        System.out.println(HOUSE_DATA);

        searchHouse("Lannister");

        displayHouses();
    }

    private static void addHouse(House house) {
        HOUSE_DATA.put(house.getSigil(), house);
    }

    private static void removeHouse(String name) {
        Iterator<Map.Entry<String, House>> iterator = HOUSE_DATA.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, House> entry = iterator.next();
            if (entry.getValue().getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

    private static void searchHouse(String name) {
        for (var entry : HOUSE_DATA.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                System.out.printf("The House of %s has a sigil of %s\n", name, entry.getKey());
            }
        }
    }

    private static void displayHouses() {
        for (var entry : HOUSE_DATA.entrySet()) {
            System.out.printf("The House of %s has a sigil of %s\n", entry.getValue().getName(), entry.getKey());
        }
    }
}

package faang.school.godbless.game_of_trones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Starks", "direwolf");
        House barateon = new House("Barateons", "deer");
        House lanister = new House("Lanisters", "lion");
        addHouse("Starks", stark);
        addHouse("Lanisters", lanister);
        addHouse("Barateons", barateon);
        removeHouse("Starks");
        String emblem = searchHouse("Lanisters");
        System.out.println(emblem);
        getAllHouses();

    }

    public static void addHouse(String nameHouse, House house) {
        houses.put(nameHouse, house);
    }

    public static void removeHouse(String nameHouse) {
        houses.remove(nameHouse);

    }

    public static String searchHouse(String nameHouse) {
        String emblem = null;
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            if (entry.getKey().equals(nameHouse)) {
                emblem = entry.getValue().getEmblem();
            }
        }
        return emblem;
    }

    public static void getAllHouses() {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getKey() + "--> " + entry.getValue());
        }
    }
}

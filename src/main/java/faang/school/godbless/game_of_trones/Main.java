package faang.school.godbless.game_of_trones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Starks", "direwolf");
        House barateon = new House("Barateons", "deer");
        House lanister = new House("Lanisters", "lion");
        Main.addHouse("Starks", stark);
        Main.addHouse("Lanisters", lanister);
        Main.addHouse("Barateons", barateon);
        Main.removeHouse("Starks");
        House house = Main.searchHouse("Lanisters");
        System.out.println(house);
        System.out.println(getAllHouses());

    }
    public static void addHouse(String nameHouse, House house) {
        houses.put(nameHouse, house);
    }
    public static void removeHouse(String nameHouse) {
        houses.remove(nameHouse);

    }
    public static House searchHouse(String nameHouse) {
        return houses.get(nameHouse);
    }
    public static Map<String, House> getAllHouses() {
        return houses;
    }
}

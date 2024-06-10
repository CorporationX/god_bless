package faang.school.godbless.game_of_trones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        House stark = new House("Stark", "Wolf");
        House lanister = new House("Lanister", "Lion");
        House barateon = new House("Barateon", "Deer");

        houses.put(stark.getName(), stark);
        houses.put(lanister.getName(), lanister);
        houses.put(barateon.getName(), barateon);

        System.out.println(houses);
        addHouse(new House("Targarien", "Dragon"));
        System.out.println(houses);
        deleteHouse("Lanister");
        System.out.println(houses);
        System.out.println(getHouseByName("Stark"));
        getAllHouses();
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void deleteHouse(String name) {
        houses.remove(name);
    }

    public static String getHouseByName(String name) {
        return houses.get(name).getSigil();
    }

    public static void getAllHouses() {
        for (var entry : houses.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getSigil());
        }
    }
}

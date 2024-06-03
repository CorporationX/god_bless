package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<String, House> westeros = new HashMap<>();

    public Main() {
        westeros.put("Stark", new House("Stark", "Wolf"));
        westeros.put("Greyjoy", new House("Greyjoy", "Squid"));
        westeros.put("Arryn of the Eyrie", new House("Arryn of the Eyrie", "Eagle"));
        westeros.put("Tully", new House("Tully", "Fish"));
        westeros.put("Baratheon of King's Landing", new House("Baratheon of King's Landing", "Deer"));

    }

    public void addHouse(House house) {
        westeros.put(house.name, house);
    }

    public String getSigil(String houseName) {
        return westeros.get(houseName).sigil;
    }

    public void removeHouse(String houseName) {
        westeros.remove(houseName);
    }

    public void listHouses() {
        System.out.println("==============================");
        for (House house : westeros.values()) {
            System.out.println(house);
        }
        System.out.println("==============================");
    }
}

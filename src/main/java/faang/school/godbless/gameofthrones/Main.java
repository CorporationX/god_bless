package faang.school.godbless.gameofthrones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<String, House> houses = new HashMap<>();

    public Main() {
        houses.put("Stark", new House("Stark", "Direwolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Baratheon", new House("Baratheon", "Stag"));
//        houses.put("Targaryen", new House("Targaryen", "Dragon"));
//        houses.put("Greyjoy", new House("Greyjoy", "Kraken"));
//        houses.put("Martell", new House("Martell", "Sun and Spear"));
//        houses.put("Tyrell", new House("Tyrell", "Rose"));
    }

    public void addNewHouse(House house) {
        houses.put(house.name(), house);
    }

    public void removeHouseByName(String name) {
        houses.remove(name);
    }

    public String getSigilByHouseName(String name) {
        if (!houses.containsKey(name)) {
            return null;
        }

        return houses.get(name).sigil();
    }

    public List<String> getHouses() {
        List<String> result = new ArrayList<>();

        for (House house : houses.values()) {
            result.add(house.toString());
        }

        return result;
    }
}
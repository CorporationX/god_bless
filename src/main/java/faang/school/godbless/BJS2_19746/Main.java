package faang.school.godbless.BJS2_19746;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Map<String, House> houses = new HashMap<>();

    {
        houses.put("Stark", new House("Stark", "Frog"));
        houses.put("Lanister", new House("Lanister", "Tiger"));
        houses.put("Arrens", new House("Arrens", "Lion"));
        houses.put("Bron", new House("Bron", "Bear"));
    }

    public void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public boolean deleteHouse(String name) {
        if (houses.containsKey(name)) {
            houses.remove(name);
            return true;
        } else return false;
    }

    public String getSigil(String name) {
        House house;
        if ((house = houses.get(name)) != null) {
            return house.getSigil();
        } else return "Дома с названием " + name + " не существует";
    }

    public List<String> getAllHouses() {
        return houses.values()
                .stream()
                .map(House::toString)
                .toList();
    }
}

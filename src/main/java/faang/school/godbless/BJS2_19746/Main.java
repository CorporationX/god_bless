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

    public House deleteHouse(String name) {
        return houses.remove(name);
    }

    public String getSigil(String name) {
        return houses.get(name).getSigil();
    }

    public List<String> getAllHouses() {
        return houses.values()
                .stream()
                .map(House::toString)
                .toList();
    }
}

package faang.school.godbless.alexbulgakoff.gameofthrones;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

public class HouseServiceImpl implements HouseService {

    Map<String, House> houses;

    public HouseServiceImpl(Map<String, House> houses) {
        this.houses = houses;
    }

    @Override
    public void addHouse(House newHouse) {
        houses.put(newHouse.getName(), newHouse);
    }

    @Override
    public void deleteHouseByName(String name) {
        houses.entrySet().removeIf(entry -> entry.getKey().equalsIgnoreCase(name));
    }

    @Override
    public String searchHouse(String name) {
        StringBuilder searchingSigil = new StringBuilder();

        for (Map.Entry<String, House> entry : houses.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name)) {
                searchingSigil.append(entry.getValue().getSigil());
            }
        }
        return searchingSigil.toString();
    }

    @Override
    public List<Map<String, House>> getAllHouse() {
        List<Map<String, House>> result = new ArrayList<>();

        result.add(houses);

        return result;
    }
}

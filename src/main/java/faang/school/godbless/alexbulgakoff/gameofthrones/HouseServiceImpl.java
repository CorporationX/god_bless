package faang.school.godbless.alexbulgakoff.gameofthrones;

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
    public void searchHouse(String name) {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name)) {
                System.out.println(entry.getValue().getSigil());
            }
        }
    }

    @Override
    public void getAllHouse(Map<String, House> houses) {
        houses.forEach((key, value) ->
                System.out.println("House name: " + key + "\n" + "Sigil: " + value.getSigil() + "\n"));
    }
}

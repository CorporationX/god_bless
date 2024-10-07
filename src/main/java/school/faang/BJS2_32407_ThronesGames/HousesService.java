package school.faang.BJS2_32407_ThronesGames;

import java.util.HashMap;
import java.util.Map;

public class HousesService {
    private Map<String, House> houses;

    public HousesService() {
        houses = new HashMap<>();
    }

    public void addHouse(House house) {
        if (house == null)
            throw new IllegalArgumentException("House can't be null.");
        houses.put(house.getName(), house);
    }

    public void removeHouse(String houseName) {
        validateString(houseName);
        houses.remove(houseName);
    }

    public void findAndPrintHouse(String houseName) {
        validateString(houseName);
        House house = houses.get(houseName);
        if (house != null)
            System.out.printf("House %s has sigil %s\n", houseName, house.getSigil());
        else
            System.out.printf("There is no house with such name: %s\n.", houseName);
    }

    public void printAllHouses() {
        for (House house: houses.values()) {
            System.out.printf("House %s has sigil %s\n", house.getName(), house.getSigil());
        }
    }

    public int getHousesCount() {
        return houses.size();
    }

    private void validateString(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("Invalid data.");
        }
    }
}

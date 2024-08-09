package faang.school.godbless.gameofthrones;

import java.util.Map;

public class HouseService {

    public void addHouse(Map<String, House> houses, House house) {
        houses.put(house.getName(), house);
    }

    public void removeHouse(Map<String, House> houses, String houseName) {
        var house = houses.remove(houseName);
        if (house == null) {
            System.out.println("House not found" + "\n");
        }
    }

    public void showSigilByHouseName(Map<String, House> houses, String houseName) {
        var house = houses.get(houseName);
        if (house == null) {
            System.out.println("Sigil of house " + houseName + " not found");
        } else {
            System.out.println("Sigil of house " + houseName + ": " + house.getSigil());
        }
    }

    public void showHousesInfo(Map<String, House> houses) {
        houses.forEach((key, value) ->
                System.out.println("Name: " + key +
                        ", Sigil: " + value.getSigil()));
    }
}

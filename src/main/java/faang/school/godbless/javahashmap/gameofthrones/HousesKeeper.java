package faang.school.godbless.javahashmap.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class HousesKeeper {

    private final Map<String, House> houses = new HashMap<>();

    public void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public void removeHouse(String houseName) {
        houses.remove(houseName);
    }

    public void findAndPrintHouse(String houseName) {
        House house = houses.get(houseName);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("House not found");
        }
    }

    public void printAllHousesInfo() {
        for (String houseName : houses.keySet()) {
            House house = houses.get(houseName);
            System.out.println(house);
        }
    }

    public HashMap<String, House> getDeepCopyOfHouses() {
        HashMap<String, House> housesForReturn = new HashMap<>();
        houses.forEach((houseName, house) -> housesForReturn.put(houseName, new House(houseName, house.getSigil())));
        return housesForReturn;
    }
}

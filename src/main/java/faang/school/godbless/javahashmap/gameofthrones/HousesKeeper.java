package faang.school.godbless.javahashmap.gameofthrones;

import java.util.HashMap;

public class HousesKeeper {

    private final HashMap<String, House> houses = new HashMap<>();

    public void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public void removeHouse(String houseName) {
        houses.remove(houseName);
    }

    public void findAndPrintHouse(String houseName) {
        House house = houses.get(houseName);
        if (house != null) {
            System.out.println("House: " + house.getName() + ", Sigil: " + house.getSigil());
        } else {
            System.out.println("House not found");
        }
    }

    public void printAllHousesInfo() {
        for (String houseName : houses.keySet()) {
            House house = houses.get(houseName);
            System.out.println("House: " + house.getName() + ", Sigil: " + house.getSigil());
        }
    }

    public HashMap<String, House> getHouses() {
        HashMap<String, House> housesForReturn = new HashMap<>();
        houses.forEach((houseName, house) -> housesForReturn.put(houseName, new House(houseName, house.getSigil())));
        return housesForReturn;
    }
}

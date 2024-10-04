package dima.evseenko.thrones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vesteros {
    private final Map<String, House> houses = new HashMap<>();

    public void addHouse(House house) {
        validateHouse(house);

        houses.put(house.getName(), house);
    }

    public void addHouses(List<House> houses) {
        validateHouses(houses);

        houses.forEach(this::addHouse);
    }

    public void deleteHouse(String houseName) {
        houses.remove(houseName);
    }

    public void deleteHouse(House house) {
        deleteHouse(house.getName());
    }

    public House getHouse(String houseName) {
        return houses.get(houseName);
    }

    public String getSigil(String houseName) {
        if(houseName == null) return null;
        return getHouse(houseName).getSigil();
    }

    private void validateHouse(House house) {
        if(house == null)
            throw new IllegalArgumentException("house is null");
        if(house.getName() == null)
            throw new IllegalArgumentException("house name is null");
        if(house.getSigil() == null)
            throw new IllegalArgumentException("house sigil is null");
    }

    private void validateHouses(List<House> houses) {
        if(houses == null)
            throw new IllegalArgumentException("houses is null");
    }

    public void printHouses() {
        houses.forEach((name, house) -> System.out.println(name+" "+house));
        System.out.println();
    }
}

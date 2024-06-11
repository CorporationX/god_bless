package faang.school.godbless.gameofthrones;

import faang.school.godbless.helpers.CustomException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseManager {
    private final Map<String, House> HOUSES = new HashMap<>();

    public HouseManager() {
        House starkHouse = new House("House 1", "Старк");
        House lannisterHouse = new House("House 2", "Ланнистер");
        House barateonHouse = new House("House 3", "Баратеон");
        HOUSES.put(starkHouse.getName(), starkHouse);
        HOUSES.put(lannisterHouse.getName(), lannisterHouse);
        HOUSES.put(barateonHouse.getName(), barateonHouse);
    }

    public Map<String, House> getHouses() {
        return HOUSES;
    }

    public void addHouse(String houseName, String houseSigil) throws CustomException {
        if (houseName.isEmpty()) {
            throw new CustomException("House name is empty");
        }
        if (houseSigil.isEmpty()) {
            throw new CustomException("House sigil is empty");
        }
        House houseToAdd = new House(houseName, houseSigil);
        HOUSES.put(houseToAdd.getName(), houseToAdd);
    }

    public void deleteByName(String houseName) {
        if (!houseName.isEmpty()) {
            HOUSES.remove(houseName);
        }
    }

    public House getHouseByName(String houseName) throws CustomException {
        if (houseName.isEmpty()) {
            throw new CustomException("house name is null");
        }
        return HOUSES.get(houseName);
    }
}

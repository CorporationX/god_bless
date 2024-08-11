package faang.school.godbless.task.hashmap.game.thrones;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class HouseAndSigillManager {
    private Map<String, House> houseMap = new HashMap<>();

    public void addNewHouse(House house) {
        validHouseOrThrowNullPointerException(house);
        houseMap.put(house.name(), house);
    }

    public void deleteHouseByName(String name) {
        if (!houseMap.containsKey(name)) {
            houseNotFoundExceptionThrow(name);
        }
        houseMap.remove(name);
    }

    public void printSigillByHouseName(String name) {
        if (!houseMap.containsKey(name)) {
            houseNotFoundExceptionThrow(name);
        }
        System.out.println(houseMap.get(name).sigill());
    }

    public void printAllHouseAndSigill() {
        houseMap.values().forEach(house -> System.out.println(house));
    }

    private void houseNotFoundExceptionThrow(String name) {
        throw new NoSuchElementException("Дом с именем %s не найден".formatted(name));
    }

    private void validHouseOrThrowNullPointerException(House house) {
        if (house == null) {
            throw new NullPointerException("Дом не может быть null");
        }
    }
}

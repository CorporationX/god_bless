package faang.school.godbless.task.game.of.thrones;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class HouseAndSigillManager {
    private Map<String, House> nameHouseMap = new HashMap<>();

    public void addNewHouse(House house) throws NoSuchElementException {
        Optional.ofNullable(house).ifPresentOrElse(hs -> {
            nameHouseMap.putIfAbsent(house.name(), house);
        }, () -> {
            throw new NoSuchElementException("Дом не может быть %s".formatted(house));
        });
    }

    public void deleteHouseByName(String name) throws NoSuchElementException {
        if (nameHouseMap.remove(name) == null) {
            houseNotFoundExceptionThrow(name);
        }
    }

    public void findSigillByHouseName(String name) throws NoSuchElementException {
        House house = nameHouseMap.get(name);
        if (house == null) {
            houseNotFoundExceptionThrow(name);
        }
        System.out.println(house.sigill());
    }

    private void houseNotFoundExceptionThrow(String name) throws NoSuchElementException {
        throw new NoSuchElementException("Дом с именем %s не найден".formatted(name));
    }

    public void printAllHouseAndSigill() {
        nameHouseMap.values().forEach(house -> System.out.println(house));
    }
}

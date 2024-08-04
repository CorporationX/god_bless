package faang.school.godbless.task.game.of.thrones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseAndSigillManager {
    private Map<String, House> stringHouseMap = new HashMap<>();

    public void addNewHouse(House house) {
        stringHouseMap.putIfAbsent(house.name(), house);
    }

    public void deleteHouseByName(String name) {
        stringHouseMap.remove(name);
    }

    public String findSigillByHouseName(String name) {
        House house = stringHouseMap.get(name);
        return house != null ? house.sigill() : null;
    }

    public List<String> getAllHouseAndSigill() {
        List<String> houseAndSigillList = new ArrayList<>();
        stringHouseMap.forEach((name, house) -> {
            houseAndSigillList.add("Name: " + name + "; Sigill: " + house.sigill());
        });
        return houseAndSigillList;
    }
}

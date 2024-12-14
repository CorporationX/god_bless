package faang.school.godbless.BJS_8044;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Westeros {
    private HashMap<String, House> houses = new HashMap<>();

    public void addHouses(House... houses) {
        for (House house : houses) {
            addHouse(house);
        }
    }

    public void addHouse(House house) {
        houses.putIfAbsent(house.getName(), house);
    }

    public void deleteHouseFromWesterosHouses(String name) {
        houses.remove(name);
    }

    public void getCrestInfo(String name) {
        if (validateHousesList()) {
            if (houses.containsKey(name)) {
                System.out.println(name + " House has " + houses.get(name).getCrest() + " etched on their crest");
            } else {
                System.out.println(name + " house doesn't belong to Westeros");
            }
        }
    }

    public void getHousesAndCrest() {
        int num = 1;
        if (validateHousesList()) {
            System.out.println();
            for (Map.Entry<String, House> entry : houses.entrySet()) {
                String msg = String.format("%d house is %s and it's crest is %s", num, entry.getKey(), entry.getValue().getCrest());
                System.out.println(msg);
                num++;
            }
        }
    }

    private boolean validateHousesList() {
        if (!houses.isEmpty()) {
            return true;
        } else {
            System.out.println("There's no one house in Westeros");
            return false;
        }
    }

}

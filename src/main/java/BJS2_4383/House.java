package BJS2_4383;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;

    static void addHouse(Map<String, House> houses, House house) {
        houses.put(house.name, house);
    }

    static void deleteHouse(Map<String, House> houses, House house) {
        houses.remove(house.name);
    }

    static String findHouse(String name, Map<String, House> houses) {
        return houses.get(name).getSigil();
    }

    static void allHouse(Map<String, House> houses) {
        for (Map.Entry<String, House> house : houses.entrySet()) {
            System.out.println(house.getKey() + " - " + house.getValue().getSigil());
        }
    }
}

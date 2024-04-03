package BJS2_4383;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;

    public static void addHouse(Map<String, House> houses, House house) {
        houses.put(house.name, house);
    }

    public static void deleteHouse(Map<String, House> houses, House house) {
        houses.remove(house.name);
    }
}

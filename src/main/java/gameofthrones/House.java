package gameofthrones;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class House {

    private String name;
    private String sigil;

    public static void addHouse(Map<String, House> map, House house) {
        map.put(house.getName(), house);
    }

    public static void removeHouse(Map<String, House> map, String name) {
        map.remove(name);
    }

    public static String getSigil(Map<String, House> map, String name) {
        return map.get(name).getSigil();
    }

    public static Map<String, House> getAllHouses(Map<String, House> houses) {
        return houses;
    }
}

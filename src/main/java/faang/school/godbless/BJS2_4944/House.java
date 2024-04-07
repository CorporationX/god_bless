package faang.school.godbless.BJS2_4944;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;

    static void addHouse(Map<String, House> houses, House house) {
        houses.put(house.getName(), house);
    }

    static void deleteHouse(Map<String, House> houses, House house) {
        houses.remove(house.getName());
    }

    static String findHouseByName(Map<String, House> houses, String name) {
        return houses.get(name).getSigil();
    }

    static void printAllHouses(Map<String, House> houses) {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getSigil());
        }
    }
}

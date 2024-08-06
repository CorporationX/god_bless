package faang.school.godbless.BJS2_19803;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@ToString
public class House {
    private String name;
    private String sigil;

    public static void addHouse(Map<String, House> houses, House house) {
        houses.put(house.name, house);
    }

    public static void removeHouse(Map<String, House> houses, String houseName) {
        houses.remove(houseName);
    }

    public static String findSigilByHouseName(Map<String, House> houses, String houseName) {
        return houses.get(houseName).sigil;
    }

    public static void printAllHouses(Map<String, House> houses) {
        for (House house : houses.values()) {
            System.out.printf("%s %s%n", house.name, house.sigil);
        }
    }
}

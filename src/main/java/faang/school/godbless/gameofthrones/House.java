package faang.school.godbless.gameofthrones;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class House {
    private static final Map<String, House> houses = new HashMap<>();

    private String name;
    private String sigil;

    public static void addHouse(String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    public static void deleteHouse(String name) {
        houses.remove(name);
    }

    public static House searchHouse(String name) {
        return houses.get(name);
    }

    public static void printAllHouses() {
        houses.forEach((key, house) -> System.out.println(house));
    }
}

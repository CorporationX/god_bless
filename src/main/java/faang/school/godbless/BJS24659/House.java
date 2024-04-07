package faang.school.godbless.BJS24659;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;

    public static void addHouse(Map<String, House> houses, String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    public static void removeHouse(Map<String, House> houses, String name) {
        houses.remove(name);
    }

    public static void findHouse(Map<String, House> houses, String name) {
        House house = houses.get(name);
        if (house != null) {
            System.out.println("Информация о гербе дома " + name + ": " + house.getSigil());
        } else {
            System.out.println("Дом с названием \"" + name + "\" не найден.");
        }
    }
}

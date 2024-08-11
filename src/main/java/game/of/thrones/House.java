package game.of.thrones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class House {
    static Map<String, House> storage = new HashMap<>();
    private String name;
    private String sigil;

    public static void main(String[] args) {
        House stark = new House("Старки", "Волк");
        House lannister = new House("Ланистеры", "Лев");
        House barateon = new House("Баратеон", "Олень");

        addHouse(stark.getName(), stark);
        addHouse(lannister.getName(), lannister);
        addHouse(barateon.getName(), barateon);
        printHouses();

        removeHouse("Ланистеры");
        printHouses();

        System.out.println(getHouse("Баратеон"));
    }

    static void addHouse(String name, House house) {
        storage.put(name, house);
    }

    static void removeHouse(String name) {
        storage.remove(name);
    }

    static House getHouse(String name) {
        if (storage.containsKey(name)) {
            return storage.get(name);
        }

        throw new IllegalArgumentException(String.format("Дом с названием %s не был найден.", name));
    }

    static void printHouses() {
        storage.forEach((name, house) -> {
            System.out.printf("Дом: %s, Герб: %s", name, house.getSigil()).println();
        });
    }
}

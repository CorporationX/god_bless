package school.faang.game.of.thrones;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<String, House> nameToHouse = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Старк", "Герб дома Старк");
        House lannister = new House("Ланнистер", "герб дома Ланнистер");
        House baratheon = new House("Баратеон", "герб дома Баратеон");

        Main main = new Main();
        main.add(stark);
        main.add(lannister);
        main.add(baratheon);
        main.print();

        main.remove(stark.getName());
        main.print();

        String sigil = main.get(lannister.getName());
        System.out.println("Информация про герб второго дома " + sigil);
    }

    public void add(@NonNull House house) {
        nameToHouse.put(house.getName(), house);
    }

    public void remove(@NonNull String name) {
        nameToHouse.remove(name);
    }

    public String get(@NonNull String name) {
        return nameToHouse.get(name).getSigil();
    }

    public void print() {
        nameToHouse.values().forEach(System.out::println);
        System.out.println();
    }
}

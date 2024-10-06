package school.faang.game.of.thrones;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<String, House> nameToHouse = new HashMap<>();

    public static void main(String[] args) {
        House house1 =  new House("Старк", "Какой-то герб");
        House house2 =  new House("Ланнистер", "Какой-то герб");
        House house3 =  new House("Баратеон", "Какой-то герб");

        Main main = new Main();
        main.add(house1);
        main.add(house2);
        main.add(house3);
        main.print();

        main.remove(house1.getName());
        main.print();

        String sigil = main.get(house2.getName());
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

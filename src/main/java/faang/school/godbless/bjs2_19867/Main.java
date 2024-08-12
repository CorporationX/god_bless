package faang.school.godbless.bjs2_19867;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        var stark = House.builder().name("Stark").sigil("Stark sigil").build();
        var lannister = House.builder().name("Lannister").sigil("Lannister sigil").build();
        var barateon = House.builder().name("Barateon").sigil("Barateon sigil").build();
        var allNulls = House.builder().name(null).sigil(null).build();
        var nameNull = House.builder().name(null).sigil("not null").build();
        var sigilNull = House.builder().name("not null").sigil(null).build();
        var duplicate1 = House.builder().name("duplicate").sigil("duplicate").build();
        var duplicate2 = House.builder().name("duplicate").sigil("duplicate").build();

        put(stark);
        put(lannister);
        put(barateon);
        put(allNulls);
        put(nameNull);
        put(sigilNull);
        put(duplicate1);
        put(duplicate2);
        System.out.println("Size of houses: " + houses.size());

        remove("barateon.getName()");
        System.out.println("Size of map: " + houses.size());

        get(lannister.getName());

        System.out.println();
        print();
    }

    private static void put(House house) {
        if (house != null) {
            houses.put(house.getName(), house);
        }
    }

    private static void remove(String name) {
        if (name != null) {
            houses.remove(name);
        }
    }

    private static void get(String name) {
        if (name != null) {
            var foundHouse = houses.get(name);
            if (foundHouse != null) {
                System.out.println("Sigil: " + foundHouse.getSigil());
            } else {
                System.out.println("House not found by name: " + name);
            }

        }
    }

    private static void print() {
        houses.values().forEach(
                house -> System.out.println(house.toString()
        ));
    }
}

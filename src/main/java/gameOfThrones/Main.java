package gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, addHouse> HOUSES = new HashMap<>();


    public static void main(String[] args) {
        HOUSES.computeIfAbsent("Stark", key -> new addHouse("Stark of Winterfell", "SOW"));
        HOUSES.computeIfAbsent("Lannister", key -> new addHouse("Lannister of Casterly Rock", "LOCR"));
        HOUSES.computeIfAbsent("Barateon", key -> new addHouse("Barateon of Storm's End", "BOSE"));
        HOUSES.forEach((k, v) -> System.out.println("Ключ-" + k + "/ Дом-" + v.getName() + "/ Герб-" + v.getSigil()));


        addHouse("Targaryen of King's Landing", "TOKL");
        addHouse("Arryn of the Eyrie", "Arr");
        addHouse("Tully of Riverrun", "TOR");
        addHouse("Greyjoy of Pyke", "GOP");
        addHouse("Tyrell of Highgarden", "TOH");
        addHouse("Martell of Sunspear", "MOS");

        System.out.println();
        HOUSES.forEach((k, v) -> System.out.println("Ключ-" + k + "/ Дом-" + v.getName() + "/ Герб-" + v.getSigil()));


        removeHouse("Targaryen");
        removeHouse("Arryn");
        removeHouse("Tully");
        System.out.println();
        HOUSES.forEach((k, v) -> System.out.println("Ключ-" + k + "/ Дом-" + v.getName() + "/ Герб-" + v.getSigil()));
    }

    public static void addHouse(String name, String sigil) {
        String key = name.split(" ")[0];
        HOUSES.computeIfAbsent(key, (k) -> new addHouse(name, sigil));
    }

    public static void removeHouse(String name) {
        HOUSES.remove(name);
    }
}

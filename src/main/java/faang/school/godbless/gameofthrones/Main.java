package faang.school.godbless.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, House> houses = new HashMap<>() {{
        put("Stark", new House("Stark", "Grey wolf on a white background"));
        put("Lannister", new House("Lannister", "Golden lion on a red background"));
        put("Baratheon", new House("Baratheon", "Black deer on a golden background"));
    }};

    public static void main(String[] args) {
        add(new House("Greyjoy", "Golden octopus on a black background"));
        deleteByName("Lannister");
        printSigilByName("Greyjoy");
        printAll();
    }

    public static void add(House house) {
        houses.put(house.getName(), house);
    }

    public static void deleteByName(String name) {
        houses.remove(name);
    }

    public static void printSigilByName(String name) {
        String sigil = houses.get(name).getSigil();
        System.out.println(sigil);
    }

    public static void printAll() {
        for (var entry : houses.entrySet()) {
            System.out.println(String.format("House: %s, Sigil: %s", entry.getKey(), entry.getValue().getSigil()));
        }
    }
}

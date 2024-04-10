package faang.school.godbless.JavaHashMap.Task1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSE_MAP = new HashMap<>();

    public static void main(String[] args) {

        House stark = new House("Старк", "Волк");
        House lannister = new House("Ланнистер", "Лев");
        House barateon = new House("Баратеон", "Олень");
        House tyrell = new House("Тирелл", "Роза");

        add(stark.getName(), stark);
        add(lannister.getName(), lannister);
        add(barateon.getName(), barateon);
        add(tyrell.getName(), tyrell);

        remove(lannister.getName());
        find(tyrell.getName());
        printAll();
    }

    private static void add(String name, House house) {
        HOUSE_MAP.put(name, house);
    }

    private static void remove(String name) {
        HOUSE_MAP.remove(name);
    }

    private static String find(String name) {
        return HOUSE_MAP.get(name).getSigil();
    }

    private static void printAll() {
        HOUSE_MAP.forEach((s, house) -> System.out.println(s + ":" + house.getSigil()));
    }
}

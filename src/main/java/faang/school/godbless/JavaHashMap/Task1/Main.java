package faang.school.godbless.JavaHashMap.Task1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

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
        HOUSES.put(name, house);
    }

    private static void remove(String name) {
        HOUSES.remove(name);
    }

    private static void find(String name) {
        if (HOUSES.get(name) != null) {
            System.out.println("Герб" + " : " + HOUSES.get(name).getSigil());
        }else System.out.println("Дом не найден");
    }

    private static void printAll() {
        HOUSES.forEach((s, house) -> System.out.println(s + ":" + house.getSigil()));
    }
}

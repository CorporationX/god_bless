package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {

   public static final Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        House stark = new House("Старк", "sig");
        House lannister = new House("Ланнистер", "sag");
        House barateon = new House("Баратеон", "sig");

        add(stark.getName(), stark);
        add(lannister.getName(), lannister);
        add(barateon.getName(), barateon);

        remove(stark.getName());

        find(lannister.getName());

        printAll();
    }

    public static void add(String name, House house) {
        houses.put(name, house);
    }

    public static void remove(String name) {
        houses.remove(name);
    }

    public static String find(String name) {
        return houses.get(name).getSigil();
    }

    public static void printAll() {
        boolean home = false;
        houses.forEach((name, house) -> System.out.println(home + ":" + house.getSigin()));
    }

}

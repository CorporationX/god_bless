package faang.school.godbless.r_edzie.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Старк", "Stark Sigil");
        House lanister = new House("Ланнистер", "Lanister Sigil");
        House barateon = new House("Баратеон", "Barateon Sigil");

        add(stark.getName(), stark);
        add(lanister.getName(), lanister);
        add(barateon.getName(), barateon);

        remove(lanister.getName());

        System.out.println(find(barateon.getName()));

        System.out.println("-----");

        printAll();
    }

    public static void add(String name, House house) {
        HOUSES.put(name, house);
    }

    public static void remove(String name) {
        HOUSES.remove(name);
    }

    public static String find(String name) {
        return HOUSES.get(name).getSigil();
    }

    public static void printAll() {
        for (Map.Entry<String, House> entry : HOUSES.entrySet()) {
            String name = entry.getKey();
            String sigil = entry.getValue().getSigil();
            System.out.println(name + " " + sigil);
        }
    }
}

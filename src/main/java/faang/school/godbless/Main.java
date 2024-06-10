package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> westeros = new HashMap<>();

    static {
        westeros.put("Stark", new House("Stark", "Wolf"));
        westeros.put("Lanistar", new House("Lanistar", "lion"));
        westeros.put("Barateon", new House("Barateon", "Deer"));
    }

    public static void main(String[] args) {
        getInfoAboutHousesWesteros();
        System.out.println();

        getInfoOnSigil("Stark");
        System.out.println();

        addNewHouse("Arrean", new House("Arrean", "White falcon"));
        deleteHouse("Barateon");
        getInfoAboutHousesWesteros();
    }

    public static void addNewHouse(String nameHouse, House newHouse) {
        if (newHouse != null && nameHouse != null)
            westeros.put(nameHouse, newHouse);
    }

    public static void deleteHouse(String nameHouse) {
        if (nameHouse != null && westeros.containsKey(nameHouse))
            westeros.remove(nameHouse);
    }

    public static void getInfoOnSigil(String nameHouse) {
        if (nameHouse != null && westeros.containsKey(nameHouse))
            System.out.println(westeros.get(nameHouse).getSigil());
    }

    public static void getInfoAboutHousesWesteros() {
        for (Map.Entry<String, House> x : westeros.entrySet())
            System.out.println("Home name:" + x.getValue().getName() + " sigil:" + x.getValue().getSigil());
    }

}

package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Westeros {
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
        if (newHouse != null) {
            if (nameHouse != null) {
                westeros.put(nameHouse, newHouse);
            } else {
                throw new IllegalArgumentException("Name not specified");
            }
        } else {
            throw new IllegalArgumentException("The house has not been transferred");
        }
    }

    public static void deleteHouse(String nameHouse) {
        if (nameHouse != null) {
            if (westeros.containsKey(nameHouse)) {
                westeros.remove(nameHouse);
            } else {
                throw new IllegalArgumentException("Westeros not contains this name");
            }
        } else {
            throw new IllegalArgumentException("Name not specified");
        }
    }

    public static void getInfoOnSigil(String nameHouse) {
        if (nameHouse != null) {
            if (westeros.containsKey(nameHouse)) {
                System.out.println(westeros.get(nameHouse).getSigil());
            } else {
                throw new IllegalArgumentException("Westeros not contains this name");
            }
        } else {
            throw new IllegalArgumentException("Name not specified");
        }
    }

    public static void getInfoAboutHousesWesteros() {
        for (Map.Entry<String, House> x : westeros.entrySet())
            System.out.println("Home name:" + x.getValue().getName() + " sigil:" + x.getValue().getSigil());
    }
}

package faang.school.godbless.game_of_trones;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        House STARK = new House("Stark", "Volf");
        House LANNESTER = new House("Lannester", "Lion");
        House BARATEON = new House("Barateon", "Deer");
        HOUSES.put(STARK.getName(), STARK);
        HOUSES.put(LANNESTER.getName(), LANNESTER);
        HOUSES.put(BARATEON.getName(), BARATEON);

        addHouse("Targarien", new House("Targarien", "Dragon"));
        System.out.println(findHouse("Lannester"));
        showAllHouses();
        removeHouse("Barateon");
        showAllHouses();
    }

    public static void addHouse(String houseName, House house) {
        HOUSES.put(houseName, house);
    }

    public static void removeHouse(String houseName) {
        if (HOUSES.containsKey(houseName)) {
            HOUSES.remove(houseName);
        } else {
            throw new NoSuchElementException(String.format("No such house: %s", houseName));
        }
    }

    public static String findHouse(String houseName) {
        if (HOUSES.containsKey(houseName)) {
            return HOUSES.get(houseName).getSigil();
        } else {
            throw new NoSuchElementException(String.format("No such house: %s", houseName));
        }
    }

    public static void showAllHouses() {
        HOUSES.forEach((name, house) -> System.out.println(house));
    }
}

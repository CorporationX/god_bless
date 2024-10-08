package school.faang.BS232492;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSE_MAP = new HashMap<>();

   static {
        HOUSE_MAP.put("Stark", new House("Stark house", "Stark"));
        HOUSE_MAP.put("Lanister", new House("Lanister house", "Lanister"));
        HOUSE_MAP.put("Barateon", new House("Barateon house", "Barateon"));
    }

    public static void main(String[] args) {
        printAllHousesAndSigils();
        addNewHouse("Doniyor", new House("Doniyor", "Doniyor sigil"));
        addNewHouse("Nadejda", new House("Nadejda", "Nadejda sigil"));
        addNewHouse("Anvar", new House("Anvar", "Anvar"));
        System.out.println(HOUSE_MAP);
        System.out.println();
        deleteHouseByName("Nadejda");
        System.out.println(HOUSE_MAP);
        System.out.println();
        findAndGetSigilOfHouse("Anvar");
        System.out.println();
        printAllHousesAndSigils();
    }

    public static void addNewHouse(String sigil, House house) {
        HOUSE_MAP.put(sigil, house);
    }

    public static void deleteHouseByName(String name) {
        HOUSE_MAP.remove(name);
    }

    public static void findAndGetSigilOfHouse(String nameOfHouse) {
        if (nameOfHouse.isEmpty() || nameOfHouse.isBlank()) {
            throw new IllegalArgumentException("Fill the nameOfHouse");
        }

        House house = HOUSE_MAP.get(nameOfHouse);
        System.out.println(house);
    }

    public static void printAllHousesAndSigils() {
        HOUSE_MAP.forEach((sigil, nameOfHouse) -> System.out.println(sigil + ":" + nameOfHouse));
    }
}

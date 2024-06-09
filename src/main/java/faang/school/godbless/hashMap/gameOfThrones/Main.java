package faang.school.godbless.hashMap.gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> westerosHouses = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Adding");
        add(new House("name1", "sigil1"));
        add(new House("name2", "sigil2"));
        add(new House("name3", "sigil3"));
        add(new House("name4", "sigil4"));
        printAll();

        System.out.println("\nFinding");
        System.out.println(findByName("name1"));

        System.out.println("\nPrinting sigil");
        printSigilByName("name3");

        System.out.println("\nPrinting all after deleting");
        deleteByName("name2");
        printAll();
    }

    public static void add(House house) {
        westerosHouses.put(house.getName(), house);
    }

    public static void deleteByName(String name) {
        validateString(name);
        validateHouse(westerosHouses.remove(name));
    }

    public static House findByName(String name) {
        validateString(name);
        return validateHouse(westerosHouses.get(name));
    }

    public static void printSigilByName(String name) {
        House house = findByName(name);
        System.out.println("Sigil by house " + name + ": " + house.getSigil());
    }

    public static void printAll() {
        for (Map.Entry<String, House> houseEntry : westerosHouses.entrySet()) {
            System.out.println(houseEntry.getValue());
        }
    }

    private static void validateString(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name can`t be null");
        }
    }

    private static House validateHouse(House house) {
        if (house == null) {
            throw new NotFoundException("House not found");
        }
        return house;
    }
}
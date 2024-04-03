package faang.school.godbless.vesterosslibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, House> houseMap = new HashMap<>();

    static {
        houseMap.put("Targaryen", new House("Targaryen", "Fire and Blood"));
        houseMap.put("Stark", new House("Stark", "Winter is Coming"));
        houseMap.put("Lannister", new House("Lannister", "Hear Me Roar"));
        houseMap.put("Baratheon", new House("Baratheon", "Ours is the Fury"));
        houseMap.put("Greyjoy", new House("Greyjoy", "We do not sow"));
    }

    public static void main(String[] args) {

        System.out.println("Print all house:");
        printAllHouseInfo();
        System.out.println("----------------------------");

        System.out.println("add House of Tyrell");
        House houseOfTyrell = new House("Tyrell", "Growing Strong");
        addHouse(houseOfTyrell);
        System.out.println("----------------------------");

        System.out.println("Delete House of GreyJoy");
        deleteHouse("Greyjoy");
        System.out.println("----------------------------");

        System.out.println("print info House of Stark");
        printSingleHouseSigilInfo("Stark");
        System.out.println("----------------------------");

        System.out.println("Print all house:");
        printAllHouseInfo();

    }

    public static void addHouse(House house) {
        if (houseMap.containsKey(house.getName())) {
            throw new IllegalArgumentException("This house already exists");
        }
        houseMap.put(house.getName(), house);
    }

    public static void addHouse(String houseName, String sigil) {
        if (houseMap.containsKey(houseName)) {
            throw new IllegalArgumentException("House of " + houseName + "already exists");
        }
        houseMap.put(houseName, new House(houseName, sigil));
    }

    public static void deleteHouse(String houseName) {
        houseMap.remove(houseName);
    }

    public static void printSingleHouseSigilInfo(String houseName) {
        if (!houseMap.containsKey(houseName)) {
            throw new IllegalArgumentException("There is no information about the House of" + houseName);
        }

        System.out.println((houseMap.get(houseName).getSigil()));
    }

    public static void printAllHouseInfo() {
        houseMap.values().forEach(house -> System.out.println(house.getName() + " " + house.getSigil()));
    }


}

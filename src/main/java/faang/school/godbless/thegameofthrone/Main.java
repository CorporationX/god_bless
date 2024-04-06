package faang.school.godbless.thegameofthrone;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static Map<String, House> HOUSE_MAP = new HashMap<>();

    static {
        HOUSE_MAP.put("Targaryen", new House("Targaryen", "Fire and Blood"));
        HOUSE_MAP.put("Stark", new House("Stark", "Winter is Coming"));
        HOUSE_MAP.put("Lannister", new House("Lannister", "Hear Me Roar"));
        HOUSE_MAP.put("Baratheon", new House("Baratheon", "Ours is the Fury"));
        HOUSE_MAP.put("Greyjoy", new House("Greyjoy", "We do not sow"));
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
        if (HOUSE_MAP.containsKey(house.getName())) {
            throw new IllegalArgumentException("This house already exists");
        }
        HOUSE_MAP.put(house.getName(), house);
    }

    public static void deleteHouse(String houseName) {
        HOUSE_MAP.remove(houseName);
    }

    public static void printSingleHouseSigilInfo(String houseName) {
        if (!HOUSE_MAP.containsKey(houseName)) {
            throw new IllegalArgumentException("There is no information about the House of" + houseName);
        }

        System.out.println((HOUSE_MAP.get(houseName).getSigil()));
    }

    public static void printAllHouseInfo() {
        HOUSE_MAP.values().forEach(house -> System.out.println(house.getName() + " " + house.getSigil()));
    }
}
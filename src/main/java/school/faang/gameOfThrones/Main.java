package school.faang.gameOfThrones;

import java.util.HashMap;

public class Main {
    private static final HashMap<String, House> HOUSE_HASH_MAP = new HashMap<>();

    public static void addNewHouse(House house) {
        HOUSE_HASH_MAP.put(house.getName(), new House(house.getName(), house.getSigil()));
    }

    public static void removeHouseByName(String houseName) {
        HOUSE_HASH_MAP.remove(houseName);
    }

    public static void showInfoByName(String houseName) {
        System.out.println(HOUSE_HASH_MAP.get(houseName));
    }

    public static void showAllInfo() {
        System.out.println(HOUSE_HASH_MAP);
    }

    public static void main(String[] args) {
        House house1 = new House("Stark", "Wolf");
        House house2 = new House("Lanistar", "Lion");
        House house3 = new House("Barateon", "Eagle");

        HOUSE_HASH_MAP.put("Stark", house1);
        HOUSE_HASH_MAP.put("Lanistar", house2);
        HOUSE_HASH_MAP.put("Barateon", house3);
        showAllInfo();
        System.out.println();

        House house4 = new House("Abzalkhan", "Ondakanov");
        addNewHouse(house4);
        showAllInfo();
        System.out.println();

        removeHouseByName("Abzalkhan");
        showAllInfo();
        System.out.println();

        showInfoByName("Stark");

    }
}

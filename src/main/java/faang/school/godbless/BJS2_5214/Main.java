package faang.school.godbless.BJS2_5214;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> housesMap = new HashMap<>();

    public static void main(String[] args) {
        House houseStark = new House("Stark", "The Direwolf");
        House houseLannister = new House("Lannister", "The Lion");
        House houseTargaryen = new House("Targaryen", "The Three-Headed Dragon");
        House houseBaratheon = new House("Baratheon", "The Stag");
        //House houseTully = new House("Tully", "The Trout");
        //House houseTyrell = new House("Tyrell", "The Rose");
        //House houseArryn = new House("Arryn", "The Falcon");
        //House houseGreyjoy = new House("Greyjoy", "The Kraken");
        //House houseMartell = new House("Martell", "The Sun and Spear");

        addHouse(houseStark);
        addHouse(houseLannister);
        addHouse(houseTargaryen);

        findHouse("Lannister");
        findHouse("Baratheon");
        addHouse(houseBaratheon);
        findHouse("Baratheon");

        getAllHousesInfo();
        removeHouse("Targaryen");
        getAllHousesInfo();

    }

    private static void addHouse(House house) {
        housesMap.put(house.getName(), house);
    }

    private static void removeHouse(String houseName) {
        housesMap.remove(houseName);
    }

    private static House findHouse(String houseName) {
        House house = housesMap.get(houseName);
        if (house != null) {
            System.out.println("House is found. Sigil: " + house.getSigil());
            return house;
        }
        else
            System.out.println("House is not found");

        return null;
    }

    private static void getAllHousesInfo() {
        for (House house : housesMap.values()) {
            System.out.println(house.getName() + ": " + house.getSigil());
        }
    }

}

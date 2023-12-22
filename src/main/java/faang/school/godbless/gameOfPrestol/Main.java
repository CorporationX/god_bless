package faang.school.godbless.gameOfPrestol;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static <Map> void main(String[] args) {
        HashMap<String, House> houses = new HashMap<>();
        addHouse(houses, new House("VIKUS", "PIKUS"));
        addHouse(houses, new House("SLAVUS", "TAVUS"));
        addHouse(houses, new House("JAVA", "SCRIPT"));
        getAllHouse(houses);
        System.out.println("_________________________________________________");
        addHouse(houses, new House("FICUS", "PIKUS"));
        addHouse(houses, new House("KULIS", "TAVUS"));
        addHouse(houses, new House("CPLUSPLUS", "SCRIPT"));
        getAllHouse(houses);
        System.out.println("_________________________________________________");
        removeHouse(houses, "CPLUSPLUS");
        removeHouse(houses, "VIKUS");
        getAllHouse(houses);
        System.out.println("_________________________________________________");
        getInfoAboutHouse(houses, "SLAVUS");
        getInfoAboutHouse(houses, "JAVA");
        getAllHouse(houses);
        System.out.println("_________________________________________________");
    }

    public static void addHouse(HashMap<String, House> houses, House house) {
        houses.putIfAbsent(house.getName(), house);
    }

    public static void removeHouse(HashMap<String, House> houses, String houseName) {
        houses.remove(houseName);
    }

    public static void getInfoAboutHouse(HashMap<String, House> houses, String houseName) {
        House house = houses.get(houseName);
        System.out.println("Название дома: " + house.getName() + ", Герб: " + house.getSigil());
    }

    public static void getAllHouse(HashMap<String, House> houses) {
        for (Map.Entry<String, House> house : houses.entrySet()) {
            getInfoAboutHouse(houses, house.getValue().getName());
        }
    }
}

package faang.school.godbless;

import java.util.HashMap;

public class Application {
    private static HashMap<String, House> allHouseMap = new HashMap<>();

    public static void main(String[] args) {

        House house = new House("Старк", "герб1");
        House house2 = new House("Ланнистер", "герб2");
        House house3 = new House("Баратеон", "герб3");

        addHouse(house.getName(), house);
        addHouse(house2.getName(), house);
        addHouse(house3.getName(), house);
        printAll();

        delHouse(house2.getName());
        System.out.println("Удалили дом: " + house2.getName());
        printAll();

        System.out.println("Поиск герба:" + findHouse(house3.getName()));
    }

    public static void addHouse(String name, House house) {
        allHouseMap.put(name, house);
    }

    public static void delHouse(String name) {
        allHouseMap.remove(name);
    }

    public static String findHouse(String name) {
        return allHouseMap.get(name).getSigil();
    }

    public static void printAll() {
        allHouseMap.forEach((s, house) -> {
            System.out.println("Дом: " + s + ", Герб: " +house.getSigil());
        });
    }
}
package faang.school.godbless.javahashmap.task1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> houseMap = new HashMap<>();

    public static void main(String[] args) {
        addHouse(new House("Вестерос", "герб Вестерос"));
        addHouse(new House("Старк", "герб Старк"));
        addHouse(new House("Ланнистер", "герб Ланнистер"));
        addHouse(new House("Баратеон", "герб Баратеон"));

        removeHouse("Ланнистер");
        System.out.println(findHouse("Старк"));
        printSigil("Вестерос");
        printAllHouse();
    }

    public static void addHouse(House house) {
        houseMap.put(house.getName(), house);
    }

    public static House removeHouse(String nameHouse) {
        return houseMap.remove(nameHouse);
    }

    public static House findHouse(String nameHouse) {
        return houseMap.get(nameHouse);
    }

    public static void printSigil(String nameHouse) {
        System.out.println(houseMap.get(nameHouse).getSigil());
    }

    public static void printAllHouse() {
        for (Map.Entry<String, House> entry: houseMap.entrySet()) {
            System.out.println("Дом " + entry.getKey() + " " + entry.getValue().getSigil());
        }
    }
}

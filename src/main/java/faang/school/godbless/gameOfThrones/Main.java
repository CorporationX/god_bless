package faang.school.godbless.gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> vesteros;

    public static void main(String[] args) {
        vesteros = new HashMap<>();
        Main.addHouse(new House("Баратеоны", "Чёрный коронованный олень на золотом поле"));
        Main.addHouse(new House("Ланнистеры", "Золотой лев на алом поле"));
        Main.addHouse(new House("Старки", "Серый лютоволк, бегущий по снежно-белому полю"));
        Main.viewAllHouse();
        Main.removeHouse("Баратеоны");
        System.out.println();
        Main.viewAllHouse();
        System.out.println();
        System.out.println(Main.getSigil("Старки"));
    }

    static void addHouse(House house) {
        vesteros.put(house.getName(), house);
    }

    static void removeHouse(String houseName) {
        vesteros.remove(houseName);
    }

    static String getSigil(String houseName) {
        return vesteros.get(houseName).getSigil();
    }

    static void viewAllHouse() {
        for (Map.Entry<String, House> house : vesteros.entrySet()) {
            System.out.println(house);
        }
    }
}

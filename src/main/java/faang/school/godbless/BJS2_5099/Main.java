package faang.school.godbless.BJS2_5099;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        HOUSES.put("Старк", new House("Старк", "Серый лютоволк, бегущий по снежно-белому полю"));
        HOUSES.put("Ланнистер", new House("Ланнистер", "Золотой лев на алом поле"));
        HOUSES.put("Баратеон", new House("Баратеон", "Чёрный коронованный олень на золотом поле"));

        addHouse("Таргариены", new House("Таргариены", "Targaryen"));
        System.out.println("Добавили дом 'Таргариены': " + HOUSES);
        deleteHouse("Старк");
        System.out.println("Удалили дом 'Старк': " + HOUSES);
        printSigil("Ланнистер");
        printHousesInfo();

    }

    private static void addHouse(String name, House house) {
        HOUSES.put(name, house);
    }

    private static void deleteHouse(String name) {
        HOUSES.remove(name);
    }

    private static void printSigil(String name) {
        System.out.println("Герб " + name + ": " + HOUSES.get(name).getSigil());
    }

    private static void printHousesInfo() {
        for (Map.Entry<String, House> entry : HOUSES.entrySet()) {
            System.out.println("Название дома: " + entry.getKey());
            System.out.println("Больше информации: " + entry.getValue());
        }
    }
}

package faang.school.godbless.hashmap1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        addHouse("Таргариены", "красный трёхглавый дракон на чёрном поле");
        addHouse("Старки", "бегущий серый лютоволк на снежно-белом фоне");
        addHouse("Ланнистеры", "золотой лев на красном поле");
        displayAllHouses();
        findHouse("Старки");
        deleteHouse("Старки");
        findHouse("Старки");
        displayAllHouses();
    }

    public static void addHouse(String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    public static void deleteHouse(String name) {
        houses.remove(name);
    }

    public static void findHouse(String name) {
        if (houses.containsKey(name)) {
            System.out.println(houses.get(name).sigil());
        } else {
            System.out.println("Дома с таким названием не существует");
        }
    }

    public static void displayAllHouses() {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().sigil());
        }
    }
}

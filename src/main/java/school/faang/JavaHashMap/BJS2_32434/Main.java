package school.faang.JavaHashMap.BJS2_32434;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        // Тестирование методов
        addHouse("Stark", "Direwolf");
        addHouse("Lannister", "Lion");
        addHouse("Targaryen", "Dragon");

        printAllHouses();

        searchSigil("Stark");
        searchSigil("Baratheon");

        removeHouse("Lannister");
        printAllHouses();

        removeHouse("Greyjoy");
    }

    public static void addHouse(String name, String sigil) {
        if (name == null || name.isEmpty() || sigil == null || sigil.isEmpty()) {
            System.out.println("Ошибка: Iмя дома и герб не могут быть пустыми");
            return;
        }
        houses.put(name, new House(name, sigil));
        System.out.println("Дом " + name + " добавлен");
    }

    public static void removeHouse(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Ошибка: Iмя дома не может быть пустым");
            return;
        }
        if (houses.remove(name) == null) {
            System.out.println("Дом " + name + " не найден");
        } else {
            System.out.println("Дом " + name + " удален");
        }
    }

    public static void searchSigil(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Ошибка: Iмя дома не может быть пустым");
            return;
        }
        House house = houses.get(name);
        if (house == null) {
            System.out.println("Дом " + name + " не найден");
        } else {
            System.out.println("Герб дома " + name + ": " + house.getSigil());
        }
    }

    public static void printAllHouses() {
        if (houses.isEmpty()) {
            System.out.println("Список домов пуст");
            return;
        }
        System.out.println("Список всех домов:");
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println("Дом " + entry.getKey() + ", Герб: " + entry.getValue().getSigil());
        }
    }
}

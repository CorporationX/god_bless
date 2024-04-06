package faang.school.godbless.houses_vest;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houseMap = new HashMap<>();
        houseMap.put("Stark", new House("Stark", "Direwolf"));
        houseMap.put("Lannister", new House("Lannister", "Lion"));
        houseMap.put("Targaryen", new House("Targaryen", "Dragon"));
        houseMap.put("Greyioy", new House("Greyioy", "Cracen"));

        allHouses(houseMap);
        System.out.println("====================>>>>>>>>>>>>>>>");
        addHouse(houseMap, "Stark", "Direwolf");
        addHouse(houseMap, "Arryn", "Falcon");
        allHouses(houseMap);

        System.out.println("====================>>>>>>>>>>>>>>>");
        deleteHouse(houseMap, "Lannister");
        deleteHouse(houseMap, "Potter");
        allHouses(houseMap);

        System.out.println("====================>>>>>>>>>>>>>>>");
        infoSigil(houseMap, "Stark");
        infoSigil(houseMap, "Potter");

    }

    public static void addHouse(Map<String, House> houseMap, String name, String sigil) {
        if (!houseMap.containsKey(name)) {
            houseMap.put(name, new House(name, sigil));
            System.out.println("Дом " + name + " добавлен");
        } else {
            System.out.println("Дом " + name + " уже есть");
        }
    }

    public static void deleteHouse(Map<String, House> houseMap, String name) {
        if (houseMap.containsKey(name)) {
            houseMap.remove(name);
            System.out.println("Дом " + name + " удалён");
        } else {
            System.out.println("Дом " + name + " не найден");
        }
    }

    public static void infoSigil(Map<String, House> houseMap, String name) {
        House house = houseMap.get(name);
        if (house != null) {
            System.out.println("Герб дома " + name + " - " + house.getSigil());
        } else {
            System.out.println("Дом " + name + " найден");
        }
    }
    public static void allHouses(Map<String, House> houseMap) {
        if (houseMap.isEmpty()) {
            System.out.println("Список домов пуст");
        } else {
            System.out.println("Список всех домов и их гербов:");
            for (Map.Entry<String, House> entry : houseMap.entrySet()) {
                System.out.println("Дом: " + entry.getKey() + ", Герб: " + entry.getValue().getSigil());
            }
        }
    }
}


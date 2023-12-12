package faang.school.godbless.java_hashmap.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {


    private static Map<String, House> houseMap = new HashMap<>();


    static {
        houseMap.put("Старк", new House("Старк", "Лютоволк"));
        houseMap.put("Ланнистер", new House("Ланнистер", "Лев"));
        houseMap.put("Баратеон", new House("Баратеон", "Чёрный олень"));
    }

    public static void main(String[] args) {
        add(new House("Дом Таргариенов", "трёхголовый дракон"));
        remove("Дом Таргариенов");
        get("Баратеон");
        printList();

    }

    static void add(House house) {
        if (house == null) throw new IllegalArgumentException();
        houseMap.put(house.getName(), house);
    }


    static void remove(String name) {
        if (name == null) throw new IllegalArgumentException();
        houseMap.remove(name);
    }

    static void get(String name) {
        if (name == null) throw new IllegalArgumentException();
        System.out.println(houseMap.get(name).getSigil());
    }

    static void printList() {
        for (Map.Entry<String, House> entry :  houseMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}

package faang.school.godbless.hashMap.task_1;

import faang.school.godbless.hashMap.task_1.model.House;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Старк", "Волк");
        House lannister = new House("Ланнистер", "Лев");
        House barateon = new House("Баратеон", "Олень");
        add(stark.getName(), stark);
        add(lannister.getName(), lannister);
        add(barateon.getName(), barateon);
        System.out.println("Мапа до удаления: ");
        printAll();
        remove(lannister.getName());
        System.out.println("Мапа после удаления: ");
        printAll();
        String starkSigil = find(stark.getName());
        System.out.println("Герб старков: " + starkSigil);

    }

    private static void add(String name, House house) {
        HOUSES.put(name, house);
    }

    private static void remove(String name) {
        HOUSES.remove(name);
    }

    private static String find(String name) {
        return HOUSES.get(name).getSigil();
    }

    private static void printAll() {
        HOUSES.forEach((name, house) -> System.out.println(name + " : " + house.getSigil()));
        System.out.println();
    }
}
package faang.school.godbless.sprint_1.throne_games;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, House> map = new HashMap<>();

    public static void main(String[] args) {

        map.put("Старк", new House("Старк", "Sigil-Старк"));
        map.put("Ланистер", new House("Ланистер", "Sigil-Ланистер"));
        map.put("Баратеон", new House("Баратеон", "Sigil-Баратеон"));

        printInfoAboutAllHouses();
        addNewHouse("Таргариан", "Sigil-Таргариан");
        printInfoAboutSigilByHouseName("Таргариан");
        deleteHouseByName("Старк");
        printInfoAboutAllHouses();
    }

    public static void addNewHouse(String name, String sigil) {
        map.put(name, new House(name, sigil));
    }

    public static void deleteHouseByName(String name) {
        map.remove(name);
    }

    public static void printInfoAboutSigilByHouseName(String name) {
        System.out.println(map.get(name).getSigil());
    }

    public static void printInfoAboutAllHouses() {
        map.forEach(((s, house) -> System.out.printf("Дом: %s -> Герб: %s%n", house.getName(), house.getSigil())));
    }

}

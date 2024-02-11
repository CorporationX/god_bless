package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, House> housesMap = new HashMap<>();
        housesMap.put("Starks", new House("Winterfall", "Wolf"));
        housesMap.put("Lanister", new House("Casterly", "Lion"));
        housesMap.put("Barateon", new House("Dragon Stone", "Three-headed Dragon"));

        addHouse((HashMap<String, House>) housesMap, "Targarien", "Dragon Stone");
        removeHouse((HashMap<String, House>) housesMap, "Barateon");
        getHouse((HashMap<String, House>) housesMap, "Starks");

    }

    private static void addHouse(HashMap<String, House> housesMap, String name, String sigil) {
        //добавление
        if (housesMap.containsKey(name)) {
            housesMap.put(name, new House(name, sigil));
        }
        System.out.println("House added: " + name);
    }

    private static void removeHouse(HashMap<String, House> housesMap, String name) {
        //удаление
        if (housesMap.containsKey(name)) {
            housesMap.remove("Starks");
            System.out.println("House removed: " + name);
        } else {
            System.out.println("House not found");
        }
    }

    private static void getHouse(HashMap<String, House> housesMap, String name) {
        //get
        if (housesMap.containsKey(name)) {
            House getHouse = housesMap.get("Lanister");
            System.out.println("House name received:  " + getHouse);
        } else {
            System.out.println("House" + name + "not found:");
        }
    }

    private static void iterateHouse(HashMap<String, House> housesMap, String name, String sigil) {
        //printAll
        for (Map.Entry<String, House> entry : housesMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + "\t" + " Sigil: " + entry.getValue());
        }
    }
}



package GameOfThrons;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        HOUSES.put("Stark", new House("Stark", "Wolf"));
        HOUSES.put("Linester", new House("Linester", "Lion"));
        HOUSES.put("Barateon", new House("Barateon", "Deer"));
        HOUSES.put("Geyjoi", new House("Greyjoy", "Kraken"));

        add("Targaryen", "Dragon");
        printInfo();
        remove("Barateon");
        printInfo();
        System.out.println(getInfo("Stark"));
    }

    public static void add(String houseName, String sigil) {
        HOUSES.put(houseName, new House(houseName, sigil));
        System.out.println("Дом добавлен.");
    }

    public static void remove(String houseName) {
        HOUSES.remove(houseName);
        System.out.println("Дом удален.");
    }

    public static House getInfo(String houseName) {
        return HOUSES.get(houseName);
    }

    public static void printInfo() {
        for (Map.Entry<String, House> entry : HOUSES.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}

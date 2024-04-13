package task1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("Stark", new House("Stark", "1"));
        map.put("Lannister", new House("Lannister", "2"));
        map.put("Baratheon", new House("Baratheon", "3"));
        add("Targaryen", "4");
        delete("Targaryen");
        houseSearch("Stark");
        searchHouses();
    }

    private static void add(String name, String sigil) {
        map.put(name, new House(name, sigil));
    }

    private static void delete(String name) {
        map.remove(name);
    }

    private static void houseSearch(String name) {
        System.out.println(" sigil:  " + map.get(name).getSigil());
    }

    private static void searchHouses() {
        for (String house : map.keySet())
            System.out.println("House: " + house + " sigil: " + map.get(house).getSigil());
    }
}
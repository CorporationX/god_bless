package faang.school.godbless.Hashmap.GameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class MainClass {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        MainClass app = new MainClass();

        app.add(new House("Stark", "1234"));
        app.add(new House("Lannister", "3563"));
        app.add(new House("Baratenon", "8395"));

        House house = app.get("Lannister");
        System.out.println("Selected house: " + house);

        app.delete("Lannister");

        Map<String, House> houses = app.getAll();
        System.out.println("Houses:");
        houses.forEach((name, h) -> System.out.println(name + ": " + h.getSigil()));
    }

    public void add(House house) {
        HOUSES.put(house.getName(), house);
    }

    public void delete(String name) {
        HOUSES.remove(name);
    }

    public House get(String name) {
        return HOUSES.get(name);
    }

    public Map<String, House> getAll() {
        return new HashMap<>(HOUSES);
    }


}

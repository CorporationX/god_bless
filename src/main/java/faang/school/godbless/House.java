package faang.school.godbless;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }
}

class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        houses.put("Старк", new House("Старк", "Волк"));
        houses.put("Ланнистер", new House("Ланнистер", "Лев"));
        houses.put("Баратеон", new House("Баратеон", "Олень"));
    }

    public static void addHouse(Map<String, House> houses, String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    public static String findHouseSigil(HashMap<String, House> houses, String name) {
        if (houses.containsKey(name)) {
            House house = houses.get(name);
            return house.getSigil();
        } else {
            return "Дом не найден";
        }
    }

    public static void removeHouse(HashMap<String, House> houses, String name) {
        houses.remove(name);
    }

    public static void printAllHouses(HashMap<String, House> houses) {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            String name = entry.getKey();
            House house = entry.getValue();
            System.out.println(name + " - " + house.getSigil());
        }
    }
}

package faang.school.godbless.hashmap.got;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> GOT_HOUSES = new HashMap<>();

    public static void main(String[] args) {

        House stark = new House("Stark", "wolf");
        House lannister = new House("Lannister", "lion");
        House targarien = new House("Targarien", "dragon");
        House barateon = new House("Barateon", "deer");
        House tirell = new House("Tirell", "flower");

        GOT_HOUSES.put(stark.getName(), stark);
        GOT_HOUSES.put(lannister.getName(), lannister);
        GOT_HOUSES.put(targarien.getName(), targarien);
        GOT_HOUSES.put(barateon.getName(), barateon);
        GOT_HOUSES.put(tirell.getName(), tirell);
    }

    private static void addNewHouse(String name, House house) {
        GOT_HOUSES.put(name, house);
    }

    private static void deleteHouse(String name) {
        GOT_HOUSES.remove(name);
    }

    private static void findHouse(String name) {
        GOT_HOUSES.get(name).getSigil();
    }

    private static void printAllHouse() {
        for (Map.Entry<String, House> pair : GOT_HOUSES.entrySet()) {
            System.out.println("House: " + pair.getKey() + ", sigil:" + pair.getValue());
        }
    }
}

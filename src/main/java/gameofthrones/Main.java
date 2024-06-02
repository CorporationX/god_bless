package gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, House> map = new HashMap<>();

    public static void main(String[] args) {

        House stark = new House("Stark", "Wolf");
        House lannister = new House("Lannister", "Lion");
        House targarien = new House("Targarien", "Dragon");

        map.put(stark.getName(), stark);
        map.put(lannister.getName(), lannister);
        map.put(targarien.getName(), targarien);

        House.addHouse(map, new House("Test", "Test"));
        House.removeHouse(map, "Test");
        House.getSigil(map, "Stark");
        House.getAllHouses(map);
    }
}

package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        houses.put("Stark", new House("Stark", "Stark Flag"));
        houses.put("Lannister", new House("Lannister", "Lannister Flag"));
        houses.put("Baraeton", new House("Baraeton", "Baraeton Flag"));
        houses.put("Noname", new House("Noname", "Noname Flag"));

        houses.remove("Noname");
        houses.get("Stark");
        System.out.println(houses.get("Stark").getSigil());
        System.out.println(houses);
    }
}

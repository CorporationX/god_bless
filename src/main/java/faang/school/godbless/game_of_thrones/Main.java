package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, House> houses = new HashMap<>();
        houses.put("Старк", new House("Старк", "Волк"));
        houses.put("Ланнистер", new House("Ланнистер", "Лев"));
        houses.put("Баратеон", new House("Баратеон", "Олень"));

        houses.put("Талли", new House("Талли", "Рыба"));
        houses.remove("Ланнистер");
        System.out.println(houses.get("Старк").getSigil());

        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println("Дом: " + entry.getKey()+ " - Герб: " + entry.getValue().getSigil());
        }
    }
}

package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final HashMap<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        houses.put("Старк", new House("Старк", "Волк"));
        houses.put("Ланнистер", new House("Ланнистер", "Лев"));
        houses.put("Баратеон", new House("Баратеон", "Олень"));


        add("Талли", new House("Талли", "Рыба"));
        remove("Ланнистер");
        find("Старк");
        findAll();

    }

    public static void add(String name, House house) {
        houses.put(name, house);
    }
    public static void remove(String name){
        houses.remove(name);
    }
    public static void find(String name){
        System.out.println(houses.get(name).getSigil());
    }

    public static void findAll(){
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println("Дом: " + entry.getKey() + " - Герб: " + entry.getValue().getSigil());
        }
    }
}

package faang.school.godbless.game_of_prestols;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<String, House> map;
        map = new HashMap<>(
                Map.ofEntries(Map.entry("Stark" , new House("Stark", "1")),
                        Map.entry("Lannister" , new House("Lannister", "2")),
                        Map.entry("Barateon" , new House("Barateon", "3")),
                        Map.entry("dom" , new House("dom", "4")))
        );
        printMap(map);
        addHouse(map, new House("domina", "none"));
        deleteHome(map, "dom");
        House house = searchHome(map, "domina");
    }
    public static void printMap(Map<String, House> map){
        for (Map.Entry<String, House> pair: map.entrySet()){
            System.out.println(pair.getKey() + " = " + pair.getValue().getSigil());
        }
    }

    public static void addHouse(Map<String, House> map, House house){
        map.put(house.getName(), house);
    }

    public static void deleteHome(Map<String, House> map, String name){
        map.remove(name);
    }

    public static House searchHome(Map<String, House> map, String name){
        House house = map.get(name);
        System.out.println(house.getSigil());
        return house;
    }
}



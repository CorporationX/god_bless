package faang.school.godbless.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> map = new HashMap<>();
    public static void main(String[] args) {
        House baratheon = new House("Baratheon", "a black stag on a gold background");
        House stark = new House("Stark", "a grey direwolf, over a green escutcheon");
        House lannister = new House("Lannister", "a golden lion on a crimson background");

        add(stark);
        add(baratheon);
        add(lannister);
        listAllHouses();
        delete("Lannister");
        listAllHouses();
        searchForHouse("Baratheon");
    }
    public static void add(House house){
        if (!(house == null)){
            map.put(house.getName(), house);
        }
    }
    public static void delete(String name){
        map.remove(name);
    }

    public static void searchForHouse(String name){
        if (map.containsKey(name)){
            System.out.println("House " + name + "'s is " + map.get(name).getSigil());
        }
    }
    public static void listAllHouses(){
        for (var entry : map.entrySet()){
            System.out.println("House " + entry.getKey() + "'s is " + entry.getValue().getSigil());
        }
    }

}




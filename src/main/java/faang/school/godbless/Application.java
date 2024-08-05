package faang.school.godbless;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        System.out.println("God_Bless");


    }

    public static void putHouse(Map map, String key, House house){
        map.put(key, house);
        System.out.println("House " + house.getName() + " has been putted in the list");
    }

    public static void deleteHouse(Map map, String name){
        map.remove(name);
        System.out.println("House " + name + " removed");
    }

    public static void getHouse(Map map, String name){
        House house = (House) map.get(name);
        System.out.println("House: " + house.getName() + "; Sigil: " + house.getSigil());
    }

    public static void getHousesList(Map<String, House> houses){
        for (Map.Entry<String, House> pair : houses.entrySet()) {
            System.out.println("House: " + pair.getValue().getName());
            System.out.println("|_ Sigil: " + pair.getValue().getSigil());
        }
    }
}
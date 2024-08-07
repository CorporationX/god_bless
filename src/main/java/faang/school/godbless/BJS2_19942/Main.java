package faang.school.godbless.BJS2_19942;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, House> vesteros = new HashMap<>();
        vesteros.put("Stark", new House("Stark", "Wolf"));
        vesteros.put("Barateon", new House("Barateon", "Bear"));
        vesteros.put("Lannister", new House("Lannister", "Eagle"));

    }

    public static void addHouse(HashMap<String, House> houses, String name, String sigil) {
        House house = new House(name, sigil);
        houses.put(house.getName(),house);
    }

    public static void removeHouse(HashMap<String, House> houses, String name){
        houses.remove(name);
    }

    public static void findHouse(HashMap<String, House> houses, String name){
        House house = houses.get(name);
        if (house != null){
            System.out.println(house.getName() + house.getSigil());
        }
        else System.out.println("Don't exist");
    }

    public static void showHouses(HashMap<String, House> houses){
        for (House house : houses.values()){
            System.out.println(house.getName() + house.getSigil());
        }
    }
}

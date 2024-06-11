package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class House {
    private String name;
    private String sigil;

    public House(String name , String sigil){
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }

    public static void addNames(HashMap<String , House> map, String name , String sigil){
        House house = new House(name , sigil);
            map.put(name , house);
    }

    public static void removeHouse(HashMap<String , House> map , String name){
        map.remove(name);
    }

    public static void foundHouse(HashMap<String , House> map , String name){
        House house = map.get(name);
        if(house != null){
            System.out.println("home name: " + house.getName() + "\nhouse sigil: " + house.getSigil());
        } else {
            System.out.println("House is not found");
        }
    }

    public static void infoAllHouse(HashMap<String , House> map){
        System.out.println("Information by all house:");
        for(House house : map.values()){
            System.out.println("\nhouse name: " + house.getName() + "\nhouse sigil: " + house.getSigil());
        }
    }
}


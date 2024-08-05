package Mathew;

import java.util.HashMap;
import java.util.List;

public class Main {
   private static HashMap<String,House> mappa = new HashMap<>();
    public static House addNewHouse(String name, String sigil) {
        return mappa.put(name,new House(name,sigil));
    }
    public static void removeHouse(String name) {
        mappa.remove(name);
    }
    public static String searchHouse(String name) {
        return mappa.get(name).getSigil();
    }
    public static void returnAllHouses() {
        mappa.forEach((key,value) -> System.out.println(key + value.getSigil()));

    }
    public static void main(String[] args) {
        House Lanister = new House("Lanister","Lion");
        House Stark = new House("Stark","Eagle");
        House Barateon = new House("Barateon","Bear");
        mappa.put(Lanister.getName(), Lanister);
        mappa.put(Stark.getName(), Stark);
        mappa.put(Barateon.getName(), Barateon);

        returnAllHouses();
        searchHouse("Barateon");
        removeHouse("Stark");
        addNewHouse("Satsuma","Chicken");

    }
}

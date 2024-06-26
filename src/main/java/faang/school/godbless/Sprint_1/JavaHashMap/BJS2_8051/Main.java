package faang.school.godbless.Sprint_1.JavaHashMap.BJS2_8051;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> houseList = new HashMap<>();
    public static void main(String[] args) {
        houseList.put("Lannistar", new House("Lannistar", "Wolf"));
        houseList.put("Stark", new House("Stark", "Dog"));
        houseList.put("Batiton", new House("Batiton", "Cat"));
        System.out.println("------------------------------------------------------------------");
        addHouse("Biba", "Boba");
        addHouse("Home", "Orel");
        printHouses(houseList);
        System.out.println("------------------------------------------------------------------");
        removeHouse("Home");
        printHouses(houseList);
        System.out.println("------------------------------------------------------------------");
        searchHome("Stark");

    }
    public static void addHouse(String name, String sigil) {
        houseList.put(name, new House(name, sigil));
    }
    public static void removeHouse(String name){
        houseList.remove(name);
    }
    public static void searchHome(String name){
        House house = houseList.get(name);
            System.out.println("Дом " + name + " имеет герб: " + house.getSigil());
    }
    public static void printHouses(Map<String, House> map) {
        System.out.println("Список всех домов и их гербов:");
        for (Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getSigil());
        }
    }
}

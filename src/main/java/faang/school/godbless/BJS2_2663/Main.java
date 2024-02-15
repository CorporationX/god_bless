package faang.school.godbless.BJS2_2663;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var map = new HashMap<String, House>();
        putHouse(map, new House("Stark", "1"));
        putHouse(map, new House("Lannister", "2"));
        putHouse(map, new House("Baratheon", "3"));
        putHouse(map, new House("Baratheon", "3"));
        printAllHouses(map);
        deleteHouse(map, "SStark");
        deleteHouse(map, "Stark");
        printAllHouses(map);
        getHouseSigill(map, "Lannister");
    }

    public static void putHouse(HashMap<String, House> map, House house) {
        if (map.containsKey(house.getName()) || map.containsValue(house)) {
            System.out.println("House already exists!");
        } else {
            map.put(house.getName(), house);
        }
    }

    public static void deleteHouse(HashMap<String, House> map, String name) {
        if (!map.containsKey(name)) {
            System.out.println("Name not found!");
        } else {
            map.remove(name);
        }
    }

    public static void getHouseSigill(HashMap<String, House> map, String name) {
        if (!map.containsKey(name)) {
            System.out.println("Name not found!");
        } else {
            System.out.println(map.get(name).getSigill());
        }
    }

    public static void printAllHouses(HashMap<String, House> map) {
        System.out.println("Houses:");
        for (var entry : map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ");
            System.out.println(entry.getValue().getSigill());
        }
    }

}

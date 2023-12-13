package faang.school.godbless.BJS2_550;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> mapHouse = new HashMap<>();
        House h1 = new House("Lannister", "Lannister's emblem");
        House h2 = new House("Barateon", "Barateon's emblem");
        House h3 = new House("Stark", "Stark's emblem");
        mapHouse.put("Lannister", h1);
        mapHouse.put("Barateon", h2);
        mapHouse.put("Stark", h3);
        deleteHouse(mapHouse, "Stark");
        for (Map.Entry<String, House> entry : mapHouse.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("");
        addNewHouse(mapHouse, h3);
        for (Map.Entry<String, House> entry : mapHouse.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("\n" + searchHouse(mapHouse, "Barateon"));
        listHouses(mapHouse);
    }

    public static Map<String, House> addNewHouse(Map<String, House> mapHouse, House house) {
        mapHouse.put(house.getName(), house);
        return mapHouse;
    }

    public static Map<String, House> deleteHouse(Map<String, House> mapHouse, String nameOfHouse) {
        mapHouse.remove(nameOfHouse);
        return mapHouse;
    }

    public static String searchHouse(Map<String, House> mapHouse, String nameOfHouse) {
        return mapHouse.get(nameOfHouse).getSigil();
    }

    public static void listHouses(Map<String, House> mapHouse) {
        for (Map.Entry<String, House> entry : mapHouse.entrySet()) {
            System.out.println(entry);
        }
    }
}

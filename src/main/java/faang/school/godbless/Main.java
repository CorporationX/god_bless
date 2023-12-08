package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> mapHouse= new HashMap<>();
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
        System.out.println("\n");
        addNewHouse(mapHouse, h3);
        for (Map.Entry<String, House> entry : mapHouse.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("\n" +searchHouse(mapHouse, "Barateon"));
        System.out.println("\n" +listHouses(mapHouse));
    }
    public static Map<String, House> addNewHouse(Map<String, House> mapHouse, House house){
        mapHouse.put(house.getName(), house);
        return mapHouse;
    }
    public static Map<String, House> deleteHouse(Map<String, House> mapHouse, String nameOfHouse){
        mapHouse.remove(nameOfHouse);
        return mapHouse;
    }
    public static String searchHouse(Map<String, House> mapHouse, String nameOfHouse){
        return mapHouse.get(nameOfHouse)+"";
    }
    public static Map<String, House> listHouses(Map<String, House> mapHouse){
        return mapHouse;
    }
}

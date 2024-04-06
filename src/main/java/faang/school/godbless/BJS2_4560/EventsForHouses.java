package faang.school.godbless.BJS2_4560;

import java.util.Map;

public class EventsForHouses {
    public static void printHouses(Map<String, House> houseMap){
        for (String house : houseMap.keySet()){
            System.out.println(house);
        }
        System.out.print("\n");
    }

    public static void addNewHouse(String name, String sigil, Map<String, House> houseMap){
        House newHouse = new House(name, sigil);
        houseMap.put(newHouse.getName(), newHouse);
    }

    public static void deleteHouse(String name, Map<String, House> houseMap){
        houseMap.remove(name);
    }

    public static void searchHouse(String name, Map<String, House> houseMap){
        System.out.println("Дом: " + houseMap.get(name).getName() + ", Флаг: " + houseMap.get(name).getSigil());
        System.out.print("\n");
    }

    public static void printAllInformation(Map<String, House> houseMap){
        for (String house : houseMap.keySet()){
            System.out.println("Дом: " + house + ", Флаг: " + houseMap.get(house).getSigil());
        }
    }
}

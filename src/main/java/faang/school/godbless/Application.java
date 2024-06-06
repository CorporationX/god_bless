package faang.school.godbless;


import java.util.HashMap;
import java.util.Map;

public class Application {


    public static final Map<String, House> houseMap = new HashMap<>();


    public static void main(String[] args) {


        houseMap.put("Stark", new House("Stark", "LutoWolf"));
        houseMap.put("Barateon", new House("Barateon", "Deer"));
        houseMap.put("Lanister", new House("Lanister", "Lion"));

        House.addHouse(new House("Tirel", "Rose"));
        House.removeHouse("Stark");
        House.findHouseByName("Tirel");
        House.printHouses();

        System.out.println(houseMap);



    }
}
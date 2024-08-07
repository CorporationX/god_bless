package faang.school.godbless.GameOfThrones;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    private final static Map<String,House> houses = new HashMap<>();

    public static void main(String[] args) {
        House house1 = new House("House Stark", "Winterfell");
        House house2 = new House("House Lannister", "Casterly Rock");

        addHouse(house1);
        addHouse(house2);
        System.out.println(houses);

        System.out.println(findHouse(house1));
        System.out.println(findHouse(house2));

        System.out.println(allHouses());

        removeHouse(house1);
        removeHouse(house2);

        System.out.println(houses);

    }

    public static void addHouse(House house){
        houses.put(house.getName(),house);
    }
    public static void removeHouse(House house){
        houses.remove(house.getName());
    }
    public static House findHouse(House house){
        return houses.get(house.getName());
    }

    public static List<String> allHouses(){
        List<String> houseInfoList = new ArrayList<>();
        for (House house:houses.values()){
            houseInfoList.add(house.getName() + "-" + house.getSigil());
        }
        return houseInfoList;
    }



}

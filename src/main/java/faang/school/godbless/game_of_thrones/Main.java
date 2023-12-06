package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static HashMap<String, House> houseMap = new HashMap<>();
    
    public static void main(String[] args) {
        
        House lannister = new House("House Lannister", "The golden lion");
        House baratheon = new House("House Baratheon", "The black crowned deer");
        House stark = new House("House Stark", "The head of grey dx irewolf");
        House tyrell = new House("House Tyrell", "Golden rose");
        House arryn = new House("House Arryn", "The white falcon");

        houseMap.put(lannister.getName(), lannister);
        houseMap.put(baratheon.getName(), baratheon);
        houseMap.put(stark.getName(), stark);
        houseMap.put(tyrell.getName(), tyrell);
        houseMap.put(arryn.getName(), arryn);

    }

    public static void addHouse(House house) {
        houseMap.put(house.getName(), house);
    }

    public static void deleteHouseByName(House house) {
        houseMap.remove(house.getName());
    }

    public static void getHouseInfo(House house) {
        if (houseMap.containsKey(house.getName())) {
            System.out.println(houseMap.get(house.getName()).getName() + " sigil is " +
                    houseMap.get(house.getName()).getSigil());
        } else {
            System.out.println("The house was not found!");
        }
    }

    public static void getAllHouses() {
        for (House house : houseMap.values()) {
            System.out.println("House name: " + house.getName() + ", house sigil: " +
                    house.getSigil());
        }
    }

}

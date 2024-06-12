package BJS2_8105;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houseAndSigil = new HashMap<>();

        houseAndSigil.put("Westeros", new House("Westeros","House Nymeros Martell of Sunspear"));
        houseAndSigil.put("Stark",new House("Stark", "Escutcheon-shaped coat of arms "));
        houseAndSigil.put("Baratheon", new House("Baratheon","Black on green"));
        houseAndSigil.put("Lannister",new House("Lannister", "Black on red "));

         houseAndSigil.putAll(newHouse("Vilnius", new House(" Vilnius", "Wolf")));

        showHouseAndSigil(houseAndSigil);

        deleteHouse("Vilnius", houseAndSigil);

        showHouseAndSigil(houseAndSigil);

        searchHouse("Stark",  houseAndSigil);
    }
    public static Map<String, House> newHouse(String house, House houseAndSigil){
        Map<String, House> oneHouseAndSigil = new HashMap<>();
        oneHouseAndSigil.put(house, houseAndSigil);
        return oneHouseAndSigil;
    }

    public static void deleteHouse(String houseName, Map<String, House>houseAndSigil){
        System.out.println(houseAndSigil.remove(houseName));
    }

    public static void searchHouse(String houseName, Map<String, House>houseAndSigil){
        System.out.println(houseAndSigil.get(houseName));
    }

    public static void showHouseAndSigil(Map<String, House>houseAndSigil){
        for (Map.Entry<String, House> oneHouseAndSigil : houseAndSigil.entrySet()){
            System.out.println("House " + oneHouseAndSigil.getKey() +" "+oneHouseAndSigil.getValue().getSigil());
        }
    }
}

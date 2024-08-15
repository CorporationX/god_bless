package BJS2_19866;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, House> houseMap = new HashMap<>();
        House lannister = new House("Lannister", "Lion");
        House stark = new House("Stark", "Wolf");
        House baratheon = new House("Baratheon", "Deer");
        House targarien = new House("Targarien", "Dragon");

        houseMap.put(lannister.getName(), lannister);
        houseMap.put(stark.getName(), stark);
        houseMap.put(baratheon.getName(), baratheon);
        houseMap.put(targarien.getName(), targarien);

        //Add a House to HashMap
        House.addHouse(new House("Tyrrol", "Rose"), houseMap);

        //Trying to pass null as argument
        House.addHouse(null, houseMap);

        //Remove a House from HashMap
        House.removeHouseByName("Lannister", houseMap);

        //Get sigil of the House by House name
        House.sigilOfTheHouse("Stark", houseMap);

        //Get all the Houses
        House.houseAndSigil(houseMap);

    }
}
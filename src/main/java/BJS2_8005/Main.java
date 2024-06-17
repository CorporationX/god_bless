package BJS2_8005;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        House houseStark = new House("Stark", "Wolf");
        House houseLannister = new House("Lannister", "Lion");
        House houseBaratheon = new House("Baratheon", "Deer");
        House.addHouse(houseStark);
        House.addHouse(houseLannister);
        House.addHouse(houseBaratheon);
        House.removeByName("Stark");
        House.sigilInfo("Lannister");
        House.sigilInfo("Stark");
        House.allHouses();
    }
}




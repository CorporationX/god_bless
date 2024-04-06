package faang.school.godbless.BJS2_4560;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Map<String, House> houseMap = new HashMap<>();


        House stark = new House("Stark", "f1");
        House lannister = new House("Lannister", "f2");
        House baratheon = new House("Baratheon", "f3");

        houseMap.put(stark.getName(), stark);
        houseMap.put(lannister.getName(), lannister);
        houseMap.put(baratheon.getName(), baratheon);

        EventsForHouses.printHouses(houseMap);
        EventsForHouses.addNewHouse("Tally", "f2", houseMap);
        EventsForHouses.printHouses(houseMap);
        EventsForHouses.deleteHouse("Stark", houseMap);
        EventsForHouses.printHouses(houseMap);
        EventsForHouses.searchHouse("Baratheon", houseMap);
        EventsForHouses.printAllInformation(houseMap);
    }
}

package faang.school.godbless;

import java.util.Map;
import java.util.HashMap;

import static faang.school.godbless.House.addNames;
import static faang.school.godbless.House.foundHouse;
import static faang.school.godbless.House.infoAllHouse;
import static faang.school.godbless.House.removeHouse;

public class Application {
    public static void main(String[] args) {
        HashMap<String, House> houseMap = new HashMap<>();

        addNames(houseMap, "Stark", "Black");
        addNames(houseMap, "Lannister", "Red");
        addNames(houseMap, "Barateon", "Blue");

        removeHouse(houseMap,"Lannister");

        foundHouse(houseMap,"Lannister");
        foundHouse(houseMap,"Stark");

        infoAllHouse(houseMap);
    }
}  
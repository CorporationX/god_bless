package src.main.java.faang.school.godbless.BSJ2_2048;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> map = new HashMap<>();

    public static void main(String[] args) {
        House house1 = new House("Stark", "Wolf");
        House house2 = new House("Lanister", "Leon");
        House house3 = new House("Baration", "Bear");
        House house4 = new House("Targarian", "Dragon");

        map.put("Stark", house1);
        map.put("Lanister", house2);
        map.put("Baration", house3);
        map.put("Targarian", house4);

        House.addHouse("DeadWalker", "Ice");
        House.deleteHouse("Lanister");
        House.SearchAndPrintHouse("DeadWalker");
        House.showHouseAndSigil();
    }

}

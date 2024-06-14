package faang.school.godbless.BJS2_8093;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Houses houses = new Houses();

        House stark = new House("Stark", "Grey direwolf");
        House lannister = new House("Lannister", "Golden lion");
        House baratheon = new House("Baratheon", "Crowned stag");

        houses.add(stark);
        houses.add(lannister);
        houses.add(baratheon);
        houses.printAllHouses();
        houses.remove("Lannister");
        System.out.println();
        houses.printAllHouses();
        houses.add(new House("Lannister", "Golden lion"));
        System.out.println();
        houses.printHouseSigil("Lannister");
    }


}

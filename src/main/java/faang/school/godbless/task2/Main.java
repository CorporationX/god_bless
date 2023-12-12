package faang.school.godbless.task2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> gameOfThrones = new HashMap<>();

        House Stark = new House("Stark", "Wiinter Wolf");
        House Lanister = new House("Lanister", "Gold Lion");
        House Barateon = new House("Barateon", "Dragon");
        House Greyjoy = new House("Greyjoy", "Kraken");
        House Tally = new House("Tally", "Fish");

        gameOfThrones.put("Stark", Stark);
        gameOfThrones.put("Lanister", Lanister);
        gameOfThrones.put("Barateon", Barateon);
        gameOfThrones.put("Greyjoy", Greyjoy);

        House.showInfo(gameOfThrones);
        System.out.println("ADD ADD ADD ADD ADD ADD ADD ADD ADD");
        House.addHouse(gameOfThrones, "Tally", Tally);
        House.showInfo(gameOfThrones);
        System.out.println("DELETE   LANISTER     DELETE");
        House.removeHouse(gameOfThrones, "Lanister");
        House.showInfo(gameOfThrones);
        System.out.println("Find Find Find Find");
        House.searchOfHouseAndShowInfo(gameOfThrones, "Kraken");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        House.showInfo(gameOfThrones);
    }
}

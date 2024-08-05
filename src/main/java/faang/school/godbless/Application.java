package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");

        Map<String, House> greatHouses = new HashMap<>();

        House house1 = new House("Stark", "Wolf");
        House house2 = new House("Barateon", "Deer");
        House house3 = new House("Grayjoy", "Kraken");
        House house4 = new House("Lanister", "Lion");
        House house5 = new House("Tirel", "Rose");
        House house6 = new House("Martell", "Sun");

        House.addHouse(greatHouses, house1);
        House.addHouse(greatHouses, house2);
        House.addHouse(greatHouses, house3);
        House.addHouse(greatHouses, house4);
        House.addHouse(greatHouses, house5);
        House.addHouse(greatHouses, house6);

        House.getAllHouses(greatHouses);
        System.out.println();

        House.delHouse(greatHouses, "Lanister");

        House.getAllHouses(greatHouses);

        House.getHouse(greatHouses, "Stark");
    }
}
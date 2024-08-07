package faang.school.godbless.gameofthrones;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HouseService houseService = new HouseService();
        HashMap<String, House> houses = new HashMap<>();
        houses.put("Stark", new House("Stark", "Wolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Baratheon", new House("Baratheon", "Deer"));

        houseService.showHousesInfo(houses);
        System.out.println();

        houseService.addHouse(houses, new House("Targarien", "Dragon"));

        houseService.showHousesInfo(houses);
        System.out.println();

        houseService.removeHouse(houses, "Lannister");
        houseService.removeHouse(houses, "Baratheon");
        houseService.removeHouse(houses, "Baratheon");

        houseService.showHousesInfo(houses);
        System.out.println();

        houseService.showSigilByHouseName(houses, "Stark");
        houseService.showSigilByHouseName(houses, "Targarien");
        houseService.showSigilByHouseName(houses, "123");
    }
}

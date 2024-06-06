package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houseMap = new HashMap<>();

        House starkHouse = new House("Старк", "Серый Лютоволк");
        House lannisterHouse = new House("Ланнистер", "Золотой Лев");
        House barateonHouse = new House("Баратеон", "Чёрный Коронованный Олень");

        System.out.println("After adding");
        House.addNewHouse(houseMap, starkHouse);
        House.addNewHouse(houseMap, lannisterHouse);
        House.addNewHouse(houseMap, barateonHouse);
        House.showAllHouses(houseMap);
        System.out.println();

        System.out.println("After deleting starkHouse and lannisterHouse");
        House.deleteHouseByName(houseMap, "Старк");
        House.deleteHouseByName(houseMap, "Ланнистер");
        House.showAllHouses(houseMap);
        System.out.println();

        System.out.println("Getting barateonHouse by name: " + House.getHouseByName(houseMap, "Баратеон"));
        System.out.println();
        System.out.println("Show sigil of barateonHouse by name: ");
        House.showSigilByName(houseMap, "Баратеон");
    }
}

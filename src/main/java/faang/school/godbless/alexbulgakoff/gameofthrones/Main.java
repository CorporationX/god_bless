package faang.school.godbless.alexbulgakoff.gameofthrones;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {

        Map<String, House> vesterosHouse = new HashMap<>();

        final HouseService houseService = new HouseServiceImpl(vesterosHouse);

        House stark = new House("Stark", "Dire wolf");
        House lannister = new House("Lannister", "Lion");
        House baration = new House("Baration", "Black deer");

        houseService.addHouse(stark);
        houseService.addHouse(lannister);
        houseService.addHouse(baration);

        System.out.println(houseService.getAllHouse());

        houseService.deleteHouseByName("Baration");

        System.out.println("All houses after remove");
        System.out.println();
        System.out.println(houseService.getAllHouse());

        System.out.println();
        System.out.println(houseService.searchHouse("lannister"));
    }
}

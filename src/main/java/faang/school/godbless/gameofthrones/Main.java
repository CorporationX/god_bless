package faang.school.godbless.gameofthrones;

import faang.school.godbless.helpers.CustomException;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final HouseManager houseManager = new HouseManager();
    public static void main(String[] args) {
        System.out.println(houseManager.getHouses());
        try {
            houseManager.addHouse("House 3","Баратеон");
            houseManager.addHouse("House 4","Старк");
            System.out.println(houseManager.getHouseByName("House 4"));
        } catch ( CustomException e) {
            e.printError();
        }
    }

}

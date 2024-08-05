package faang.school.godbless.GameOfThrones;

import java.lang.ref.PhantomReference;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, House> HOUSE_BY_NAME = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "sigilstark");
        House lannister = new House("Lannister", "sigillannister");
        House barateon = new House("barateon", "sigilbarateon");
        House pudge = new House("pudge", "sigilpudge");

        HOUSE_BY_NAME.put(stark.getName(), stark);
        HOUSE_BY_NAME.put(lannister.getName(), lannister);
        HOUSE_BY_NAME.put(barateon.getName(), barateon);

        printAllHousesAndSigils();

        addHouse(pudge);

        printAllHousesAndSigils();

        deleteHouse("Lannister");

        printAllHousesAndSigils();

        getSigilInfo("pudge");
    }

    private static void addHouse(House house) {
        HOUSE_BY_NAME.put(house.getName(), house);
    }

    private static void deleteHouse(String houseName) {
        HOUSE_BY_NAME.remove(houseName);
    }

    private static void getSigilInfo(String houseName) {
        System.out.println(HOUSE_BY_NAME.get(houseName).getSigil());
    }

    private static void printAllHousesAndSigils() {
        HOUSE_BY_NAME.forEach( (houseName , house) -> System.out.println(houseName + " : " + house.getSigil()));
        System.out.println("\n");
    }
}

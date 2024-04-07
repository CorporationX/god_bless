package gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        House lannisters = new House("Lannisters", "{$}");
        House starks = new House("Starks", "{*}");
        House barateons = new House("Barateons", "{/}");

        addHouse(lannisters.getName(), lannisters);
        addHouse(starks.getName(), starks);
        addHouse(barateons.getName(), barateons);
        printAllHousesAndSigils();

        deleteHouse(barateons.getName());
        printAllHousesAndSigils();

        System.out.println(findAndPrintInfoAboutSigil("Lannisters"));

        System.out.println(findAndPrintInfoAboutSigil("Doesnt exist"));
    }

    public static void addHouse(String nameOfHouse, House house) {
        HOUSES.put(nameOfHouse, house);
    }

    public static void deleteHouse(String nameOfHouse) {
        HOUSES.remove(nameOfHouse);
    }

    public static String findAndPrintInfoAboutSigil(String nameOfHouse) {
        if (!HOUSES.containsKey(nameOfHouse)) {
            return "\nThere is no such house!\n";
        } else {
            return "Name of House: " + nameOfHouse + "\n" +
                    "Sigil of the found house: " + HOUSES.get(nameOfHouse).getSigil();
        }
    }

    public static void printAllHousesAndSigils() {
        for (Map.Entry<String, House> entry : HOUSES.entrySet()) {
            System.out.println("Name of house: " + entry.getKey());
            System.out.println("Info about house: " + entry.getValue() + "\n");
        }
    }
}

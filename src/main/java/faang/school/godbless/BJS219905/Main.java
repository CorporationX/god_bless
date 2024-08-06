package faang.school.godbless.BJS219905;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class Main {
    private static Map<String, House> housesOfWesteros = new HashMap<>();

    public static void main(String[] args) {
        House Starks = new House("Stark", "Wolf");
        House Lannisters = new House("Lanister", "Gold");
        House Greyjoys = new House("Greyjoy", "Kraken");
        addHouses(Starks);
        addHouses(Lannisters);
        addHouses(Greyjoys);

        removeHouses("Greyjoy");
        printAllHouses();
        System.out.println();

        searchSigilInfo("Stark");
        searchSigilInfo("Alginin");
    }

    public static void addHouses(House house) {
        housesOfWesteros.put(house.getName(), house);
    }

    public static void removeHouses(String hourseName) {
        housesOfWesteros.remove(hourseName);
    }

    private static void searchSigilInfo(String houseName) {
        House house = housesOfWesteros.get(houseName);
        if (Objects.nonNull(house)) {
            System.out.printf("Sigil of house %s - %s\n", houseName, house.getSigil());
        } else {
            System.out.printf("House %s not found\n", houseName);
        }
    }

    public static void printAllHouses() {
        for (House house : housesOfWesteros.values()) {
            System.out.println(house);
        }
    }
}

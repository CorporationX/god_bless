package faang.school.godbless.BJS2_19755;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static Map<String, House> housesOfWesteros = new HashMap<>();

    public static void addHouse(House house) {
        housesOfWesteros.put(house.getName(), house);
    }

    private static void removeHouse(String houseName) {
        housesOfWesteros.remove(houseName);
    }

    private static void searchSigilInfo(String houseName) {
        House house = housesOfWesteros.get(houseName);
        if (Objects.nonNull(house)) {
            System.out.printf("Герб дома %s - %s\n", houseName, house.getSigil());
        } else {
            System.out.printf("Дом %s не найден\n", houseName);
        }
    }

    private static void showAllHouses() {
        housesOfWesteros.values().forEach(
                house -> System.out.printf("Герб дома %s - %s\n", house.getName(), house.getSigil())
        );
    }

    public static void main(String[] args) {
        House lannisters = new House("Ланнистеры", "Золотой лев");
        House starks = new House("Старки", "Серый лютоволк");
        House greyjoys = new House("Грейджои", "Золотой кракен");
        addHouse(lannisters);
        addHouse(starks);
        addHouse(greyjoys);
        showAllHouses();
        System.out.println();

        removeHouse("Ланнистеры");
        showAllHouses();
        System.out.println();

        searchSigilInfo("Cтарки");
        searchSigilInfo("Баратеоны");


    }
}

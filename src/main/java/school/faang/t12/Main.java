package school.faang.t12;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final HashMap<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {

        House targaryen = new House("Targaryen", "Fire And Blood");
        House stark = new House("Stark", "Winter is Coming");
        House lanister = new House("Lanister", "Hear Me Roar");
        House arryn = new House("Stark", "As High As Honor ");

        HOUSES.put("houseOne", targaryen);
        HOUSES.put("houseTwo", stark);
        HOUSES.put("houseTree", lanister);

        addHouse(arryn);
        removeHouse(arryn);
        findHouse(lanister);
        getAllHouses();

    }

    private static void addHouse(House house) {
        HOUSES.put(house.getName(), house);
    }

    private static void removeHouse(House house) {
        HOUSES.remove(house.getName(), house);
    }

    private static void findHouse(House house) {
        System.out.println(HOUSES.get(house).getSigil());
    }

    private static void getAllHouses() {
        for (Map.Entry<String, House> entry : HOUSES.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        HOUSES.put("Stark", new House("Stark", "Stark Flag"));
        HOUSES.put("Lannister", new House("Lannister", "Lannister Flag"));
        HOUSES.put("Baraeton", new House("Baraeton", "Baraeton Flag"));
        HOUSES.put("Noname", new House("Noname", "Noname Flag"));

        addNewHouse(new House("Some house", "Some house flag"));
        deleteHouseByName("Some house");
        findHouseFlagByName("Stark");
        printAllHouses();
    }

    public static void addNewHouse(House house) {
        Objects.requireNonNull(house);
        HOUSES.put(house.getName(), house);
    }

    public static void deleteHouseByName(String name) {
        Objects.requireNonNull(name);
        HOUSES.remove(name);
    }

    public static void findHouseFlagByName(String name) {
        Objects.requireNonNull(name);
        House house = HOUSES.get(name);
        if (house != null) {
            System.out.printf("%s flag: %s\n", house.getName(), house.getSigil());
        } else {
            throw new RuntimeException("There is no house with name " + name);
        }
    }

    public static void printAllHouses() {
        HOUSES.values().stream().forEach(System.out::println);
    }
}

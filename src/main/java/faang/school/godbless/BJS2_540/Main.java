package faang.school.godbless.BJS2_540;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class Main {
    private static HashMap<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        addHouse(new House("Stark", "Direwolf"));
        addHouse(new House("Lannister", "Lion"));
        addHouse(new House("Baratheon", "Stag"));

        allHouseInfo();
    }
    public static void addHouse (House house) {
        houses.put(house.getName(), house);
    }
    public static House removeHouse (String name) {
        return houses.remove(name);
    }
    public static void houseInfo(String name) {
        House house = houses.get(name);
        if (house == null)
            throw new NoSuchElementException("House not found");

        System.out.printf("Name of house: %s%nSigil: %s%n", house.getName(), house.getSigil());
    }
    public static void allHouseInfo() {
        System.out.println("Here are all the houses: \n");
        houses.forEach((name, house) -> System.out.printf("Name of house: %s%nSigil: %s%n%n", name, house.getSigil()));
    }
}

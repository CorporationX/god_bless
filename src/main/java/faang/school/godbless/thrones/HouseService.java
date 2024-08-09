package faang.school.godbless.thrones;

import static faang.school.godbless.thrones.Main.houses;

public class HouseService {

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void removeHouse(String name) {
        houses.remove(name);
    }

    public static House findHouseAndPrintSigillInfo(String name) {
        House house = houses.get(name);

        if (house != null) {
            System.out.println(house.getSigill());
        }

        return house;
    }

    public static void printHouses() {
        houses.forEach((s, house) -> System.out.println("Name " + s + " - " + house));
    }
}
package faang.school.godbless.BJS2_19966;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        houses.put("STARK", new House("STARK", "Winter is coming"));
        houses.put("TARGARYEN", new House("TARGARYEN", "Fire and Blood"));
        houses.put("LANNISTER", new House("LANNISTER", "Hear me Roar"));

        System.out.print("Введите дом и герб через пробел: ");
        var house = in.nextLine().split(" ");
        addHouse(house[0], house[1]);

        System.out.print("\nКакой дом найти?: ");
        findHouse(in.nextLine());

        System.out.println("\nСписок домов:");
        printHouses();

        System.out.print("\nКакой дом удалить?: ");
        deleteHouse(in.nextLine());

        System.out.println("\nСписок после удаления:");
        printHouses();

        in.close();
    }

    public static void addHouse(String houseName, String sigil) {
        houses.put(houseName, new House(houseName, sigil));
    }

    public static void deleteHouse(String houseName) {
        houses.remove(houseName);
    }

    public static void findHouse(String houseName) {
        var house = houses.get(houseName);
        System.out.println("У дома " + houseName + " герб - " + house.getSigill());
    }

    public static void printHouses() {
        for (var entry : houses.entrySet()) {
            System.out.println("Дом " + entry.getKey() + ": герб " + entry.getValue().getSigill());
        }
    }


}
package faang.school.godbless.javaHashMap.gameOfTrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houseMap = new HashMap<>();

    static {
        houseMap.put("Stark", new House("Stark", "A grey direwolf on a white field"));
        houseMap.put("Lannister", new House("Lannister", "A golden lion rampant on a crimson field"));
        houseMap.put("Baratheon", new House("Baratheon", "A crowned black stag rampant on a gold field"));
        houseMap.put("Targaryen", new House("Targaryen", "A red three-headed dragon on a black field"));
        houseMap.put("Tyrell", new House("Tyrell", "A golden rose on a green field"));
        houseMap.put("Greyjoy", new House("Greyjoy", "A golden kraken on a black field"));
    }

    public static void main(String[] args) {
        System.out.println("Library check:");

        System.out.println("Library content at start point:");
        printAllHousesInfo();

        System.out.println("\nAdding new house (Martell)");
        addNewHouse(new House("Martell", "A red sun pierced by a gold spear on an orange field"));
        System.out.println("Library content after that:");
        printAllHousesInfo();

        System.out.println("\nRemoving house (Greyjoy)");
        removeHouse("Greyjoy");
        System.out.println("Library content after that:");
        printAllHousesInfo();

        System.out.println("\nSigil info of the House Stark  ");
        printSigilInfo("Stark");

        System.out.println("\nTrying to print sigil info of the House Greyhoy (was removed)");
        printSigilInfo("Greyjoy");
    }

    private static void addNewHouse(House newHose) {
        houseMap.put(newHose.getName(), newHose);
    }

    private static void removeHouse(String houseName) {
        houseMap.remove(houseName);
    }

    private static void printSigilInfo(String houseName) {
        House foundHouse = houseMap.getOrDefault(houseName, new House("Blank", "There is no such house in our library"));
        System.out.println(foundHouse.getSigil());
    }

    private static void printAllHousesInfo() {
        houseMap.entrySet().forEach(System.out::println);
    }
}

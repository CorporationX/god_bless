package school.faang.gameofthrones;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a HashMap to store houses and their sigils
        Map<String, House> houses = new HashMap<>();

        // Add some initial houses
        houses.put("Stark", new House("Stark", "A grey direwolf on a white field"));
        houses.put("Lannister", new House("Lannister", "A golden lion on a crimson field"));
        houses.put("Baratheon", new House("Baratheon", "A crowned black stag on a gold field"));
        houses.put("Targaryen", new House("Targaryen", "A red three-headed dragon on a black field"));


        // Method to add a new house
        public static void addNewHouse (Map < String, House > houses, House house){
            houses.put(house.getName(), house);
        }

        // Method to remove a house by name
        public static void removeHouse (Map < String, House > houses, String houseName){
            houses.remove(houseName);
        }

        // Method to find a house and print its sigil by name
        public static void findHouseSigil (Map < String, House > houses, String houseName){
            House house = houses.get(houseName);
            if (house != null) {
                System.out.println("House: " + house.getName() + " - Sigil: " + house.getSigil());
            } else {
                System.out.println("House " + houseName + " not found.");
            }
        }

        // Method to print all houses and their sigils
        public static void printAllHouses(Map<String, House> houses){
            for (Map.Entry<String, House> entry : houses.entrySet()) {
                House house = entry.getValue();
                System.out.println("House: " + house.getName() + " - Sigil: " + house.getSigil());
            }
        }

    }
}
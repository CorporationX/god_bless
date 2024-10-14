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
        public static void addNewHouse(Map<String, House> houses, House house) {
            houses.put(house.getName(), house);
        }
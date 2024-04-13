package faang.school.godbless.game_of_throne;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "st");
        House lannister = new House("Lannister", "la");
        House baratheon = new House("Baratheon", "ba");

        add(stark.getName(), stark);
        add(lannister.getName(), lannister);
        add(baratheon.getName(), baratheon);
        System.out.println(houses);
        System.out.println();
        delete(lannister.getName());

        House foundHouse = find(stark.getName());
        if (foundHouse != null) {
            System.out.println("Found House: " + foundHouse.getName() + ", Sigil: " + foundHouse.getSigil());
        } else {
            System.out.println("House " + stark + " not found.");
        }
    }

    public static void add(String name, House house){
        houses.put(name, house);
    }

    public static void delete(String name){
        houses.remove(name);
    }

    public static House find(String name){
        return houses.get(name);
    }
}

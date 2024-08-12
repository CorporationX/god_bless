package BJS2_19866;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class House {
    private final String name;
    private final String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public static void addHouse(House house, Map<String, House> houseMap) {
        try {
            houseMap.putIfAbsent(house.getName(), house);
            System.out.println("Added House - " + house.getName());
        } catch (NullPointerException e) {
            System.out.println("Error house can't be null!");
        }
    }

    public static void removeHouseByName(String name, Map<String, House> houseMap) {
        if (houseMap.containsKey(name)) {
            houseMap.remove(name);
            System.out.println("House " + name + " has been removed!");
        } else {
            System.out.println("There are no such House!");
            throw new IllegalArgumentException();
        }
    }

    public static void sigilOfTheHouse(String name, Map<String, House> houseMap) {
        if (houseMap.containsKey(name)) {
            System.out.println(houseMap.get(name).getSigil());
        } else {
            System.out.println("There are no such House's name!");
            throw new IllegalArgumentException();
        }
    }

    public static void houseAndSigil(Map<String, House> houseMap) {
        for (Map.Entry<String, House> house : houseMap.entrySet()) {
            System.out.println("Name of the House : " + house.getKey() + " and sigil is " + house.getValue().getSigil());
        }
    }
}
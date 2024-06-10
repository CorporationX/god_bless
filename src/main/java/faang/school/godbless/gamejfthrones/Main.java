package faang.school.godbless.gamejfthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        try {
            House starkHouse = new House("Stark", "Grey direwolf on a white field");
            House lannisterHouse = new House("Lannister", "Golden lion on a crimson field");
            House targaryenHouse = new House("Targaryen", "Red three-headed dragon on a black field");
            House baratheonHouse = new House("Baratheon", "Black stag on a gold field");
            House greyjoyHouse = new House("Greyjoy", "Golden kraken on a black field");

            addHouse("Stark", starkHouse);
            addHouse("Lannister", lannisterHouse);
            addHouse("Targaryen", targaryenHouse);
            addHouse("Baratheon", baratheonHouse);
            addHouse("Greyjoy", greyjoyHouse);
            deleteHouse("Tar");
            deleteHouse("Targaryen");
            findHouse("Starkk");
            findHouse("Stark");
            addHouse("", null);
            printHouses();
        } catch (IllegalArgumentException | HouseNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addHouse(String name, House house) {
        validateInput(name, house);
        HOUSES.put(name, house);
        System.out.println("House \"" + name + "\" is added successfully.");
    }

    public static void deleteHouse(String name) {
        validateInput(name);
        if (HOUSES.remove(name) != null) {
            System.out.println("House \"" + name + "\" removed successfully");
        } else {
            throw new HouseNotFoundException("House with name: \"" + name + "\" is not deleted");
        }
    }

    public static void findHouse(String name) {
        validateInput(name);
        if (HOUSES.containsKey(name)) {
            House h = HOUSES.get(name);
            System.out.println("House with name: \"" + h.name() + "\" is found\n" +
                    "Sigil is: \"" + h.sigil() + "\"");
        } else {
            throw new HouseNotFoundException("House with name: \"" + name + "\" is not found");
        }
    }

    public static void printHouses() {
        HOUSES.forEach((k, v) -> System.out.println("House : " + k + ". Sigil : " + v));
    }

    private static void validateInput(String name, House house) {
        if (name == null || name.trim().isEmpty() || house == null) {
            throw new IllegalArgumentException("Check input data! ");
        }
    }

    private static void validateInput(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("House name cannot be null or empty");
        }
    }
}

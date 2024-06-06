package faang.school.godbless.BJS28024;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, House> houseLibrary = new HashMap<>();
        addHouse(new House("Stark", "A grey direwolf on a white field"), houseLibrary);
        addHouse(new House("Lannister", "A golden lion rampant on a crimson field"), houseLibrary);
        addHouse(new House("Baratheon", " A crowned black stag rampant on a gold field"), houseLibrary);

        printLibrary(houseLibrary);

        removeHouse("Stark", houseLibrary);

        printLibrary(houseLibrary);

        removeHouse("Stark", houseLibrary);

        System.out.println(searchSigil("Lannister", houseLibrary));
        System.out.println(searchSigil("Stark", houseLibrary));
    }

    public static void addHouse(House house, Map<String, House> library) {
        library.put(house.getName(), house);
    }

    public static void removeHouse(String houseName, Map<String, House> library) {
        library.remove(houseName);
    }

    public static String searchSigil(String houseName, Map<String, House> library) {
        if (library.containsKey(houseName)) {
            return "House " + houseName + " has next sigil: " + library.get(houseName).getSigil();
        } else {
            return "House " + houseName + " not found in the library";
        }
    }

    public static void printLibrary(Map<String, House> library) {
        System.out.println("Now the Library includes next Houses:");
        library.forEach((key, value) -> System.out.println("House: " + key + " , Sigil: " + value.getSigil()));
    }
}

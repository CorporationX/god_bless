package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private static Map<String,House> houses = new HashMap<String,House>();

    public static void main(String[] args) {

        houses.put("Stark", new House("Ned","Direwolf"));
        houses.put("Lanister", new House("Jaime","Lion"));
        houses.put("Barateon", new House("Robert","Stag"));

        addHouse("Targaryen", new House("Aegon","Dragon"));
        deleteHouse("Barateon");
        findHouse("Lanister");
        findHouseSigil("Stark");


        printInfo((HashMap<String, House>) houses);
    }
    public static void addHouse(String name, House house) {
        houses.put(name, house);
        System.out.println("Adding House: " + name + " house: " + house);
    }
    public static void deleteHouse(String name) {
        houses.remove(name);
        System.out.println("Deleting House: " + name);
    }
    public static void printInfo(HashMap<String,House> hous) {
        for(Map.Entry<String,House> entry : hous.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void findHouse(String name) {
        if (houses.containsKey(name)) {
            System.out.println("Found House: " + name);
        } else {
            System.out.println("Not found House: " + name);
        }
    }
        public static void findHouseSigil(String sigil) {
            if(houses.containsKey(sigil)) {
                System.out.println("Found sigil: " + sigil + houses.get(sigil));
            } else {
                System.out.println("Not found House: "  + sigil + houses.get(sigil));
            }
    }
}
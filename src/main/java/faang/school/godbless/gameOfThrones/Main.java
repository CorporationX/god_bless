package faang.school.godbless.gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Старк", "Герб Старков");
        House lanister = new House("Ланнистер", "Герб Ланнистеров");
        House baratheon = new House("Баратеон", "Герб Баратеонов");
        House talli = new House("Талли", "Герб Талли");
        House martell = new House("Мартелл", "Герб Мартелл");
        houses.put(stark.getName(), stark);
        houses.put(lanister.getName(), lanister);
        houses.put(baratheon.getName(), baratheon);
        houses.put(talli.getName(), talli);
        houses.put(martell.getName(), martell);

        printAllHouses();
        System.out.println("------------------------------------------");
        House greyjoy = new House("Грейджой", "Герб Грейджой");
        addHouse(greyjoy);
        printAllHouses();
        System.out.println("------------------------------------------");
        removeHouse("Ланнистер");
        printAllHouses();
        System.out.println("------------------------------------------");
        System.out.println(getSigil("Старк"));
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void removeHouse(String name) {
        houses.remove(name);
    }

    public static String getSigil(String name) {
        return houses.containsKey(name) ? houses.get(name).getSigil() : null;
    }

    public static void printAllHouses() {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

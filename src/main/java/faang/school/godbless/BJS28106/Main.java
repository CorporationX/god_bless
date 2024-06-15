package faang.school.godbless.BJS28106;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap<String, House> mapOfHouses = new HashMap<>();

    public static void main(String[] args) {

        mapOfHouses.put("Stark", new House("Stark", "Wolf"));
        mapOfHouses.put("Lannister", new House("Lannister", "Lion"));
        mapOfHouses.put("Targarien", new House("Targatien", "Dragon"));
        mapOfHouses.put("Baratheon ", new House("Baratheon ", "Deer"));
        mapOfHouses.put("Tyrell", new House("Tyrell", "Flower"));
        mapOfHouses.put("Arryn", new House("Arryn", "Eagle"));
        mapOfHouses.put("Baelish", new House("Baelish", "Bird"));
        mapOfHouses.put("Baratheon of Dragonstone", new House("Baratheon of Dragonstone", "The Fiery Deer"));
        mapOfHouses.put("Clegane", new House("Clegane", "Dog"));
        mapOfHouses.put("Dondarrion", new House("Dondarrion", "Thunderstorm"));
        mapOfHouses.put("Dayne", new House("Dayne", "Sword"));
        mapOfHouses.put("Greyjoy", new House("Greyjoy", "Squid"));
        mapOfHouses.put("Hightower", new House("Hightower", "Burning Tower"));
        mapOfHouses.put("Martell", new House("Martell", "The sun"));
        mapOfHouses.put("Mormont", new House("Mormont", "Mormont"));
        mapOfHouses.put("Reed", new House("Reed", "Crocodile"));
        mapOfHouses.put("Seaworth", new House("Seaworth", "Ship"));
        mapOfHouses.put("Stark", new House("Stark", "Wolf"));
        mapOfHouses.put("Tarth", new House("Tarth", "The Sun and the Moon"));
        mapOfHouses.put("Tully", new House("Tully", "Fish"));

        Main.findHouse("Stark");
        Main.viewAllHouses(mapOfHouses);
        Main.addNewHouse("Силачи", "Гиря");
        Main.removeHouse("Lannister");
        Main.viewAllHouses(mapOfHouses);
    }

    public static void addNewHouse(String nameHouse, String sigil) {
        mapOfHouses.put(nameHouse, new House(nameHouse, sigil));
        System.out.println("Новый дом " + nameHouse + " успешно добавлен.");
        System.out.println();
    }

    public static void removeHouse(String nameHouse) {
        mapOfHouses.remove(nameHouse);
        System.out.println("Дом " + nameHouse + " удален.");
        System.out.println();
    }

    public static void findHouse(String nameHouse) {
        House sigilOfHouse = mapOfHouses.get(nameHouse);
        System.out.println("Грб - " + sigilOfHouse.sigil());
        System.out.println();
    }

    public static void viewAllHouses(Map<String, House> mapOfHouses) {
        for (Map.Entry<String, House> house : mapOfHouses.entrySet()) {
            House infoOfhouse = house.getValue();
            System.out.println(infoOfhouse);
        }
        System.out.println();
    }
}
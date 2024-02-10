package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.Map;



public class Main {


    private static final Map<String, House> houses = new HashMap<>();

    static{
        houses.put("Старк", new House("Старк", "Волк"));
        houses.put("Ланнистер", new House("Ланнистер", "Лев"));
        houses.put("Баратеон", new House("Баратеон", "Олень"));
        houses.put("Таргариен", new House("Таргариен", "Дракон"));
        houses.put("Грейджой", new House("Грейджой", "Кракен"));
        houses.put("Аррен", new House("Аррен", "Сокол"));
    }
    public void addNewHouse(String houseName, String sigil, Map<String, House> houses){
        houses.put(houseName, new House(houseName, sigil));
    }
    public void deleteHouse(Map<String, House> houses, String houseName){
        House removedHouse = houses.remove(houseName);
        if (removedHouse != null) {
            System.out.println("House '" + houseName + "' removed from the map.");
        } else {
            System.out.println("House '" + houseName + "' not found in the map.");
        }
    }

    public void findSigilByName(Map<String, House> houses, String houseName){
        if(houses.containsKey(houseName)){
            System.out.println(houses.get(houseName));
        }else{
            System.out.println("House with given name does not exist");
        }
    }
    public void printAllHouses(Map<String, House> houses){
        for(Map.Entry<String, House> entry: houses.entrySet()){
            String name = entry.getKey();;
            House house = entry.getValue();
            System.out.println("House: " + name + ", House details: " + house.toString());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("All houses:");
        main.printAllHouses(houses);
        main.addNewHouse("Мартелл", "Солнце и копье", houses);
        System.out.println("All houses:");
        main.printAllHouses(houses);
        main.deleteHouse( houses, "Таргариен" );
        System.out.println("All houses:");
        main.printAllHouses(houses);
        main.findSigilByName( houses, "Таргариен" );
        main.findSigilByName( houses, "Ланнистер" );
        main.findSigilByName( houses, "Старк" );
    }
}

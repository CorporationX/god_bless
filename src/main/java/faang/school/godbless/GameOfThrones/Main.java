package faang.school.godbless.GameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, House> housesAndEmblem = new HashMap<>();

        House stark = new House("Старк", "лютоволк");
        House lannister = new House("Ланнистер", "лев рыкающий");
        House barateon = new House("Баратеон", "черный коронованный олень на золотом поле");

        housesAndEmblem.put(stark.getName(), stark);
        housesAndEmblem.put(lannister.getName(), lannister);

        allHouses(housesAndEmblem);
        addHouse(housesAndEmblem, barateon);
        searchHouse(housesAndEmblem, "Баратеон");
        deleteHouse(housesAndEmblem, stark);
        allHouses(housesAndEmblem);

    }

    public static void addHouse(Map<String, House> mapOfHouse, House house) {
        System.out.println("Добавили дом :" + house.getName());
        mapOfHouse.put(house.getName(), house);
    }

    public static void deleteHouse(Map<String, House> mapOfHouse, House house) {
        System.out.println("Удалили дом :" + house.getName());
        mapOfHouse.remove(house.getName(), house);
    }

    public static void searchHouse(Map<String, House> mapOfHouse, String name) {
        System.out.println("Поиск дома :" + name);
        if (mapOfHouse.containsKey(name)){
            System.out.println(mapOfHouse.get(name));
        }
    }

    public static void allHouses(Map<String, House> mapOfHouse){
        System.out.println("Список всех домов:");
        for(Map.Entry<String, House> entry: mapOfHouse.entrySet())
            System.out.println(entry);
    }
}

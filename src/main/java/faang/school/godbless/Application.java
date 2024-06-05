package faang.school.godbless;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    static Map<String, House> houseAll = new HashMap<>();
    public static void main(String[] args) {
        House stark = new House("Старк", "Волк");
        House lannister = new House("Ланистер", "Лев");
        House barateon = new House("Баратеон", "Олень");

        addHouse(stark);
        addHouse(lannister);
        addHouse(barateon);
        System.out.println(houseAll);
        System.out.println(searchSigil("Баратеон"));
        System.out.println(listAllHouseAndSigil());
    }

//    добавление нового дома
    static void addHouse(House newHouse){
        houseAll.put(newHouse.getName(), newHouse);
    }

//    удаление дома по его названию;
    static void removeHouse(String nameHouse){
        houseAll.remove(nameHouse);
    }

//    поиск дома и вывод информации о гербе дома по его названию;
    static String searchSigil(@NonNull String nameHouse){
        if (!houseAll.containsKey(nameHouse)){
            throw new NullPointerException("Такого дома нет");
        }
        return houseAll.get(nameHouse).getSigil();
    }

//    вывод списка всех домов и их гербов
    static List<House> listAllHouseAndSigil(){
        List<House> houses = new ArrayList<>();
        for (Map.Entry<String, House> map:houseAll.entrySet()) {
            houses.add(map.getValue());
        }
        return houses;
    }

}

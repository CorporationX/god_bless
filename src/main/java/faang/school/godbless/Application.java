package faang.school.godbless;

import java.util.HashMap;
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
        searchSigil("Баратеон");
        listAllHouseAndSigil();
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
    static void searchSigil(String nameHouse){
        System.out.println(houseAll.get(nameHouse).getSigil());
    }

//    вывод списка всех домов и их гербов
    static void listAllHouseAndSigil(){
        System.out.println(houseAll.values());;
    }

}

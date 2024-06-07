package faang.school.godbless.GameOfTrone;

import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, Houses> houseAlL = new HashMap<>();

    public static void main(String[] args) {

        Houses stark = new Houses("Старк", "Волк");
        Houses lannister = new Houses("Ланистер", "Лев");
        Houses barateon = new Houses("Баратеон", "Олень");

        addHouse(stark);
        addHouse(lannister);
        addHouse(barateon);
        System.out.println(houseAlL);
        System.out.println(searchSigil("Баратеон"));
        System.out.println(listAllHouseAndSigil());
    }

    //    добавление нового дома
    static void addHouse(Houses newHouses) {
        houseAlL.put(newHouses.getName(), newHouses);
    }

    //    удаление дома по его названию;
    static void removeHouse(String nameHouse) {
        houseAlL.remove(nameHouse);
    }

    //    поиск дома и вывод информации о гербе дома по его названию;
    static String searchSigil(@NonNull String nameHouse) {
        if (!houseAlL.containsKey(nameHouse)) {
            throw new NullPointerException("Такого дома нет");
        }
        return houseAlL.get(nameHouse).getSigil();
    }

    //    вывод списка всех домов и их гербов
    static List<Houses> listAllHouseAndSigil() {
        return houseAlL.values().stream().toList();
    }

}

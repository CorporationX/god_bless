package faang.school.godbless.prestol_game;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class House {

    private String name;
    private String sigil;

    //добавление нового дома
    public static void addHouse(House house, Map<String, House> houses) {
        houses.put(house.getName(), house);
    }

    //удаление дома по его названию
    public void deleteHouseByName(String name, HashMap<String, House> houses) {
        if (houses.containsKey(name)) {
            houses.remove(name);
        } else {
            throw new RuntimeException("Такого дома не существует!");
        }
    }

    //поиск дома и вывод информации о гербе дома по его названию
    public void getHouseInformationByHisName(String name, HashMap<String, House> houses) {
        if (houses.containsKey(name)) {
            System.out.println("Дом " + name + " имеет аттрибуты: " + houses.get(name));
        } else {
            throw new RuntimeException("Такого дома не существует!");
        }
    }

    //вывод списка всех домов и их гербов
    public static void showAllHousesData(Map<String, House> houses) {
        System.out.println(houses);
    }
}

